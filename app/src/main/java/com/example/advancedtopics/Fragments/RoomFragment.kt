package com.example.advancedtopics.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.advancedtopics.DataClass.Description
import com.example.advancedtopics.R
import com.example.advancedtopics.databinding.FragmentRoomBinding
import com.example.advancedtopics.ViewModels.roomDataViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RoomFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RoomFragment : Fragment() {

    private var _binding:FragmentRoomBinding? = null
    private val binding get() = _binding!!

    private val viewModel: roomDataViewModel by activityViewModels()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        // Create the observer which updates the UI.
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            binding.textView5.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.currentName.observe(this, nameObserver)
    }




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRoomBinding.inflate(inflater, container, false)



        binding.buttonCreateEntry.setOnClickListener {

            if(binding.editTextTextName.text.isBlank()||binding.editTextTextNameDescription.text.isBlank()||binding.editTextTextId.text.isBlank()){
                Toast.makeText(context, "All Fields Must Be Filled", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.insertDesc(context!!, Description(Integer.parseInt(binding.editTextTextId.text.toString()),binding.editTextTextName.text.toString(), binding.editTextTextNameDescription.text.toString()))
                binding.editTextTextName.setText("")
                binding.editTextTextNameDescription.setText("")
                binding.editTextTextId.setText("")
            }




        }


        binding.buttonGetEntry.setOnClickListener {

            binding.textViewDescriptionEnquire.text = viewModel.getSpecificDescription(context!!, binding.editTextTextNameEnquire.text.toString())

        }

        binding.button7.setOnClickListener {

            //viewModel.currentName.value(binding.editTextTextPersonName.text)
            viewModel.currentName.postValue(binding.editTextTextPersonName.text.toString())

        }



        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RoomFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RoomFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}