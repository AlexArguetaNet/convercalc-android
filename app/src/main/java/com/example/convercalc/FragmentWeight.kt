package com.example.convercalc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentWeight.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentWeight : Fragment() {

    val calculator = WeightCalculator()
    private lateinit var editTextInput: EditText
    private lateinit var textViewOutput: TextView
    private lateinit var buttonConvert: Button


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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_weight, container, false)

        editTextInput = view.findViewById(R.id.edit_text_distance_input)
        textViewOutput = view.findViewById(R.id.text_view_weight_output)
        buttonConvert = view.findViewById(R.id.button_convert_weight)

        buttonConvert.setOnClickListener {
            convert()
        }




        // Inflate the layout for this fragment
        return view
    }

    @SuppressLint("DefaultLocale")
    fun convert() {
        val input = editTextInput.text.toString()
        if (!input.isEmpty()) {

            val output = calculator.lbsAndKgs(input.toDouble())
            textViewOutput.text = String.format("%.1f", output)

        } else {
            Toast.makeText(context, "Enter a number", Toast.LENGTH_SHORT).show()
        }
    }

    // TODO: Implement this function
    fun swapUnits() {

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentWeight.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentWeight().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}