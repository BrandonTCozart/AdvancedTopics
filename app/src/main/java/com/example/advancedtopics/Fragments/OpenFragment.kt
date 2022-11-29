package com.example.advancedtopics.Fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.advancedtopics.Interfaces.IActivityTransaction
import com.example.advancedtopics.databinding.FragmentOpenBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OpenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OpenFragment : Fragment() {

    private var _binding: FragmentOpenBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOpenBinding.inflate(inflater, container, false)


        binding.buttonTest.setOnClickListener {

//            val webIntent: Intent = Uri.parse("https://www.android.com").let { webpage ->
//                Intent(Intent.ACTION_VIEW, webpage)
//            }
//
//            startActivity(webIntent)


//            val launchIntent = requireActivity().packageManager.getLaunchIntentForPackage("com.google.android.youtube")
//
//            if (launchIntent != null) {
//                startActivity(launchIntent) //null pointer check in case package name was not found
//            }else{
//                Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
//            }



            /*
            var intent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setPackage("com.google.android.youtube")
            startActivity(intent)

             */

            Ilistener.toNewApplication()

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
         * @return A new instance of fragment OpenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OpenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }





    lateinit var Ilistener: IActivityTransaction

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is IActivityTransaction){
            Ilistener = context // Ilistener is equal to the context which is the main activity
        }else{
            throw java.lang.RuntimeException("must apply context")
        }
    }

}