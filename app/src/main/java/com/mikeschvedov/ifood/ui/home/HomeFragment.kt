package com.mikeschvedov.ifood.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mikeschvedov.ifood.R
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
            findNavController().navigate(R.id.action_HomeFragment_to_AddEntryFragment)
        }
    }

    private fun observers() {
        homeViewModel.isListEmpty.observe(viewLifecycleOwner){
            hideRecyclerView(it)
        }
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

    private fun populateRecyclerList() {
        homeViewModel.getAllEntriesByDate(
            day = homeDatePicker.dayOfMonth,
            month = homeDatePicker.month + 1,
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
        currentMonth = calendar[Calendar.MONTH]
        currentDay = calendar[Calendar.DAY_OF_MONTH]
        println("INITIALIZED DATE:")
        println("hour: $currentHour")
        println("day: $currentDay")
        println("month: $currentMonth")
        println("year: $currentYear")
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