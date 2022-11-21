package com.example.advancedtopics.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.advancedtopics.Adapter.quoteAdapter
import com.example.advancedtopics.R
import com.example.advancedtopics.ViewModels.RetrofitViewModel
import com.example.advancedtopics.databinding.FragmentRetrofitBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RetrofitFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RetrofitFragment : Fragment() {

    private var _binding: FragmentRetrofitBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RetrofitViewModel by activityViewModels()


    lateinit var resultArray: ArrayList<com.example.advancedtopics.DataClass.Result>
    lateinit var adapter: quoteAdapter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRetrofitBinding.inflate(inflater, container, false)



        viewModel.makeApiCall()

        binding.recyclerView.layoutManager = LinearLayoutManager(context)

        val nameObserver = Observer<List<com.example.advancedtopics.DataClass.Result>> { newName ->
            // Update the UI, in this case, a TextView.
            //binding.textView.text = newName.toString()
            adapter = quoteAdapter(viewModel.liveDataList)
            binding.recyclerView.adapter = adapter
        }

        viewModel.liveDataList.observe(viewLifecycleOwner, nameObserver)





        binding.button3.setOnClickListener {

        }

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_retrofitFragment_to_FirstFragment)
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
         * @return A new instance of fragment RetrofitFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RetrofitFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}