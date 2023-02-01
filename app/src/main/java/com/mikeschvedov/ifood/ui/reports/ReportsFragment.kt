package com.mikeschvedov.ifood.ui.reports

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mikeschvedov.ifood.R
import com.mikeschvedov.ifood.data.local_data.database.entities.FoodEntry
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodArchive
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodCategory
import com.mikeschvedov.ifood.data.local_data.hardcoded.FoodSaved
import com.mikeschvedov.ifood.databinding.FragmentAddEntryBinding
import com.mikeschvedov.ifood.utils.displayToast
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.roundToInt

@AndroidEntryPoint
class ReportsFragment : Fragment() {

    private var _binding: FragmentAddEntryBinding? = null

    private val binding get() = _binding!!

    private lateinit var reportsViewModel: ReportsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        /* ViewModel */
        reportsViewModel =  ViewModelProvider(this).get(ReportsViewModel::class.java)

        /* Binding */
        _binding = FragmentAddEntryBinding.inflate(inflater, container, false)

        return  binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}