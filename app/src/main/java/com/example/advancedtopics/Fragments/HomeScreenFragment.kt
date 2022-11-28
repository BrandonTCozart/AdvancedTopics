package com.example.advancedtopics.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.advancedtopics.R
import com.example.advancedtopics.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeScreenFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.buttonRealm.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.buttonRetrofit.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_retrofitFragment)
        }

        binding.buttonRoom.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_roomFragment)
        }

        binding.buttonService.setOnClickListener{
             findNavController().navigate(R.id.action_FirstFragment_to_serviceFragment)
        }

        binding.buttonSwitch.setOnClickListener {

        }

        binding.button6.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_backgroundFragment)
        }

        binding.buttonOpen.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_openFragment)
        }


        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}