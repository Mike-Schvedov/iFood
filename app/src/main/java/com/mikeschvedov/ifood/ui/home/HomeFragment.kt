package com.mikeschvedov.ifood.ui.home


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikeschvedov.ifood.R
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import com.mikeschvedov.ifood.databinding.FragmentHomeBinding
import com.mikeschvedov.ifood.utils.permissions.Permission
import com.mikeschvedov.ifood.utils.permissions.PermissionManager
import dagger.hilt.android.AndroidEntryPoint
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.util.*


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var homeViewModel: HomeViewModel

    private var currentHour: Int = 0
    private var currentYear: Int = 0
    private var currentMonth: Int = 0
    private var currentDay: Int= 0

    private lateinit var homeDatePicker: DatePicker

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        /* ViewModel */
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        /* Binding */
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /* Adapter */
        val adapter = homeViewModel.getRecyclerAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerview.adapter = adapter

        /* Initialize Main Date Picker */
        homeDatePicker = binding.datePickerHome

        /* onClickListeners */
        onClickListeners()

        /* Live Data Observers */
        observers()

        /* Other Methods */
        initializeDate()
        populateDatePickerAtStart()

        return root
    }


    private fun onClickListeners() {
        binding.searchButton.setOnClickListener{
            // Loading the expenses after picking another date
            populateRecyclerList()
            showDailyTitle()
        }

        binding.fabAddEntry.setOnClickListener {
            val dateBundle = Bundle()
            dateBundle.putInt("hour", currentHour)
            dateBundle.putInt("day", homeDatePicker.dayOfMonth)
            dateBundle.putInt("month", homeDatePicker.month+1) // increasing by 1 because the date picker shows one less
            dateBundle.putInt("year", homeDatePicker.year)
            findNavController().navigate(R.id.action_HomeFragment_to_AddEntryFragment, dateBundle)
        }

        binding.mainDailyDate.setOnClickListener {
          hideDailyTitle()
        }
    }

    private fun setDailyTitle(currentDay: Int, currentMonth: Int, currentYear: Int) {
        binding.mainDailyDate.text = "$currentDay/${currentMonth + 1}/${currentYear.toString().drop(2)}"
    }

    fun showDailyTitle(){
        binding.mainDailyDate.visibility = View.VISIBLE
        binding.searchButton.visibility = View.GONE
        binding.datePickerHome.visibility = View.GONE
    }

    fun hideDailyTitle(){
        binding.mainDailyDate.visibility = View.GONE
        binding.searchButton.visibility = View.VISIBLE
        binding.datePickerHome.visibility = View.VISIBLE
    }

    private fun observers() {
        homeViewModel.isListEmpty.observe(viewLifecycleOwner){
            hideRecyclerView(it)
        }
        homeViewModel.totalDailyCalories.observe(viewLifecycleOwner){ totalCalories->
            binding.caloriesEatenTodayXml.text = totalCalories.toString()
        }
        homeViewModel.totalDailyCarbs.observe(viewLifecycleOwner){ totalCarbs->
            binding.carbsDataText.text = totalCarbs
        }
        homeViewModel.totalDailyNetoCarbs.observe(viewLifecycleOwner){ totalNetCarbs->
            binding.carbsNetoDataText.text = totalNetCarbs
        }
        homeViewModel.totalDailyProtein.observe(viewLifecycleOwner){ totalProtein->
            binding.proteinDataText.text = totalProtein
        }
        homeViewModel.totalDailyFats.observe(viewLifecycleOwner){ totalFats->
            binding.fatsDataText.text = totalFats
        }
        homeViewModel.itemToDelete.observe(viewLifecycleOwner){ itemToDelete->
            showAlertDialog(itemToDelete)
        }
    }

    private fun populateRecyclerList() {
        homeViewModel.getAllEntriesByDate(
            day = homeDatePicker.dayOfMonth,
            // increasing by 1 because the date picker actually stands on -1
            month = homeDatePicker.month+1,
            year = homeDatePicker.year)

        setDailyTitle(homeDatePicker.dayOfMonth, homeDatePicker.month, homeDatePicker.year)

    }

    private fun populateDatePickerAtStart() {
        homeDatePicker.updateDate(currentYear, currentMonth, currentDay)
        // Loading the expenses with this date
        populateRecyclerList()
    }

    private fun initializeDate() {
        // Getting the current dates to set in DatePicker
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        currentHour = calendar[Calendar.HOUR_OF_DAY]
        currentYear = calendar[Calendar.YEAR]
        // We actually get the month at -1 but it's ok, because the date picker needs to receive -1 (it displays +1)
        currentMonth = calendar[Calendar.MONTH]
        currentDay = calendar[Calendar.DAY_OF_MONTH]

        // Backup database
        Toast.makeText(requireContext(), "BACKING UP DATABASE", Toast.LENGTH_SHORT).show()
        backupDatabase()
    }

    private fun hideRecyclerView(b: Boolean) {
        if (b){
            binding.recyclerview.visibility = View.INVISIBLE
            binding.nothingToShowTextview.visibility = View.VISIBLE
        }else{
            binding.recyclerview.visibility = View.VISIBLE
            binding.nothingToShowTextview.visibility = View.INVISIBLE
        }
    }

    private fun showAlertDialog(clickedEntry: FoodEntry) {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.custom_delete_dialog)
        dialog.setCancelable(true)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.dialog_animation

        val saveBTN = dialog.findViewById<AppCompatButton>(R.id.save_button)
        saveBTN.setOnClickListener {
            homeViewModel.deleteItem(clickedEntry)
            Toast.makeText(requireContext(), "רישום נמחק", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        val cancelBTN = dialog.findViewById<AppCompatButton>(R.id.cancel_button)
        cancelBTN.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    override fun onResume() {
        super.onResume()
        populateRecyclerList()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private fun backupDatabase(){
        // Requesting Storage permissions
        PermissionManager.from(this)
            .request(Permission.Storage)
            .rationale("Allow writing to storage?")
            .checkPermission {  granted: Boolean ->
                if(granted){
                    println("Permission Granted")
                    // Doing the actually backup
                    copyAllRelatedFiles()
                }else{
                    Toast.makeText(requireContext(), "Permission Denied", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun  copyAllRelatedFiles(){

        /* Don't forget that we are using "android:requestLegacyExternalStorage="true" in the Manifest application tag.
             Otherwise it doesn't let us write to the storage...*/

        //Each time we open our app, it will backup our database.
        //It will also override backups that were created in the same date, because they have the same folder names

        val baseDatabasePath =  "data/data/com.mikeschvedov.ifood/databases"
         // INTERNAL STORAGE -> DOWNLOAD - > iFoodBackups
        val destinationBackupPath =  Environment.getExternalStoragePublicDirectory( "Download")
        val dateFormat = "${currentDay}_${currentMonth+1}_${currentYear}"
        copyFile("${baseDatabasePath}/FoodDB","${destinationBackupPath}/iFoodBackups/Backup_$dateFormat/FoodDB_Backup")
        copyFile("${baseDatabasePath}/FoodDB-shm","${destinationBackupPath}/iFoodBackups/Backup_$dateFormat/FoodDB-shm_Backup")
        copyFile("${baseDatabasePath}/FoodDB-wal","${destinationBackupPath}/iFoodBackups/Backup_$dateFormat/FoodDB-wal_Backup")
    }

    private fun copyFile(sourcePath: String, destinationPath: String) {
        val source = File(sourcePath)
        val destination = File(destinationPath)

        try {
            // Using the commons-io library (we use it as a local jar in the libs folder)
            FileUtils.copyFile(source, destination)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }



}