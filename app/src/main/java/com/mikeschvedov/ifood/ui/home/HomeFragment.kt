package com.mikeschvedov.ifood.ui.home


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
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
import dagger.hilt.android.AndroidEntryPoint
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
        }
        binding.fabAddEntry.setOnClickListener {
            val dateBundle = Bundle()
            dateBundle.putInt("hour", currentHour)
            dateBundle.putInt("day", homeDatePicker.dayOfMonth)
            dateBundle.putInt("month", homeDatePicker.month+1) // increasing by 1 because the date picker shows one less
            dateBundle.putInt("year", homeDatePicker.year)
            findNavController().navigate(R.id.action_HomeFragment_to_AddEntryFragment, dateBundle)
        }
    }

    private fun observers() {
        homeViewModel.isListEmpty.observe(viewLifecycleOwner){
            hideRecyclerView(it)
        }
        homeViewModel.totalDailyCalories.observe(viewLifecycleOwner){ totalCalories->
            binding.caloriesEatenTodayXml.text = totalCalories.toString()
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
    }

    private fun populateDatePickerAtStart() {
        homeDatePicker.updateDate(currentYear, currentMonth, currentDay)
        // Loading the expenses with this date
        populateRecyclerList()
    }

    private fun initializeDate() {
        // Getting the current dates to set in DatePicker
        val calendar = Calendar.getInstance(TimeZone.getDefault())
        currentHour = calendar[Calendar.HOUR]
        currentYear = calendar[Calendar.YEAR]
        // We actually get the month at -1 but it's ok, because the date picker needs to receive -1 (it displays +1)
        currentMonth = calendar[Calendar.MONTH]
        currentDay = calendar[Calendar.DAY_OF_MONTH]
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
}