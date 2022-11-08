package com.example.advancedtopics.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advancedtopics.Adapter.profileAdapter
import com.example.advancedtopics.Classes.Profile
import com.example.advancedtopics.R
import com.example.advancedtopics.ViewModels.SecondFragment2ViewModel
import com.example.advancedtopics.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    lateinit var profiles: ArrayList<Profile>
    lateinit var adapter: profileAdapter
    private val viewModel: SecondFragment2ViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.buttonCreateNew.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_secondFragment2)
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }




        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profiles = viewModel.updateListOfProfiles()
        adapter = profileAdapter(profiles)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(context)

        adapter.setOnItemClickListener(object : profileAdapter.onItemClickListener{

            override fun onItemClick(position: Int) {

                //setFragmentResult("requestKey", bundleOf("bundleKey" to position))
                //Toast.makeText(context, "Section", Toast.LENGTH_SHORT).show()

            }
        })

        adapter.setOnDeleteButtonListener(object : profileAdapter.onDeleteButtonClickListener{

            override fun onDeleteButtonClick(position: Int) {

                //Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show()
                viewModel.deleteProfile(position)
                profiles.removeAt(position)
                adapter.notifyItemRemoved(position)

            }
        })

        binding.buttonFilter.setOnClickListener {
            profiles.clear()
            profiles.addAll(viewModel.ageFilter(25))
            adapter.notifyDataSetChanged()
        }

        binding.buttonReset.setOnClickListener {
            profiles.clear()
            profiles.addAll(viewModel.updateListOfProfiles())
            adapter.notifyDataSetChanged()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}