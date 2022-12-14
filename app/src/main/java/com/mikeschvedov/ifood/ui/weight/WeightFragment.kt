package com.mikeschvedov.ifood.ui.weight

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mikeschvedov.ifood.databinding.FragmentWeightBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeightFragment : Fragment() {

    private var _binding: FragmentWeightBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWeightBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}