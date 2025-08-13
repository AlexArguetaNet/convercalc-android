package com.example.convercalc

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDistance.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDistance : Fragment(), DialogFragmentUnitSelector.OnUnitSelectedListener {

    private lateinit var editTextDistanceInput: EditText
    private lateinit var textViewDistanceInputUnit: TextView
    private lateinit var textViewDistanceOutput: TextView
    private lateinit var textViewDistanceOutputUnit: TextView
    private lateinit var buttonConvertDistance: Button
    private lateinit var imageViewIconSwap: ImageView
    val calculator = Calculator()

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

        val view = inflater.inflate(R.layout.fragment_distance, container, false)

        editTextDistanceInput = view.findViewById(R.id.edit_text_distance_input)
        textViewDistanceInputUnit = view.findViewById(R.id.text_view_weight_input_unit)
        textViewDistanceOutput = view.findViewById(R.id.text_view_weight_output)
        textViewDistanceOutputUnit = view.findViewById(R.id.text_view_weight_output_unit)
        buttonConvertDistance = view.findViewById(R.id.button_convert_weight)
        imageViewIconSwap = view.findViewById(R.id.image_view_distance_icon_swap)

        buttonConvertDistance.setOnClickListener {
            convertDistance()
        }

        imageViewIconSwap.setOnClickListener {
            swapUnits()
        }

        textViewDistanceInputUnit.setOnClickListener {

            val units = arrayOf("inches", "centimeters", "feet", "yards")
            val dialogUnitSelector = DialogFragmentUnitSelector.newInstance(units)
            dialogUnitSelector.setOnUnitSelectedListener(this)
            dialogUnitSelector.show(childFragmentManager, "dialog_unit_selector")

        }



        // Inflate the layout for this fragment
        return view
    }

    @SuppressLint("DefaultLocale")
    fun convertDistance() {
        val input = editTextDistanceInput.text.toString()
        if (!input.isEmpty()) {

            val output = calculator.inchesAndCentimeters(input.toDouble())
            textViewDistanceOutput.text = String.format("%.1f", output)

        } else {
            Toast.makeText(context, "Enter a number", Toast.LENGTH_SHORT).show()
        }
    }

    fun swapUnits() {

        calculator.setSwapUnits(!calculator.getSwapUnits())
        if (calculator.getSwapUnits()) {
            textViewDistanceInputUnit.text = getString(R.string.cm)
            textViewDistanceOutputUnit.text = getString(R.string.in_abbreviation)
        } else {
            textViewDistanceInputUnit.text = getString(R.string.in_abbreviation)
            textViewDistanceOutputUnit.text = getString(R.string.cm)
        }

        if (editTextDistanceInput.text.toString().isNotEmpty()) {
            convertDistance()
        }

    }

    override fun onUnitSelected(unit: String) {
        textViewDistanceInputUnit.text = unit
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentDistance.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentDistance().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}