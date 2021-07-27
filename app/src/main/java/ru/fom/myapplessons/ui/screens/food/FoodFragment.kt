package ru.fom.myapplessons.ui.screens.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.fom.myapplessons.R
import ru.fom.myapplessons.databinding.FragmentCivilizationBinding
import ru.fom.myapplessons.databinding.FragmentFoodBinding


class FoodFragment : Fragment() {

    private var _binding: FragmentFoodBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        return  binding.root
    }

}