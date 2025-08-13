package com.example.convercalc

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class DialogFragmentUnitSelector: DialogFragment() {

    private lateinit var radioGroupUnits: RadioGroup
    public lateinit var currentUnit: String

    interface OnUnitSelectedListener {
        fun onUnitSelected(unit: String)
    }
    private var onUnitSelectedListener: OnUnitSelectedListener? = null

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            // Build AlertDialog
            val builder = AlertDialog.Builder(it)
            val inflater = LayoutInflater.from(it)
            val view = inflater.inflate(R.layout.dialog_unit_selector, null)

            // Initialize UI components
            radioGroupUnits = view.findViewById(R.id.radio_group_units)


            // Get units array and create radio buttons for radio group
            val units = arguments?.getStringArray(ARG_UNITS)
            if (units != null) {
                createRadioButtons(units)
            }

            // Listener for radio group
            radioGroupUnits.setOnCheckedChangeListener { group, checkedId ->

                val selectedRadioButton: RadioButton = group.findViewById(checkedId)
                currentUnit = selectedRadioButton.text.toString()

                onUnitSelectedListener?.onUnitSelected(currentUnit)

                Handler(Looper.getMainLooper()).postDelayed({
                    dismiss()
                }, 400)

            }

            builder.setView(view)
            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }

    companion object {
        private const val ARG_UNITS = "units"

        fun newInstance(units: Array<String>): DialogFragmentUnitSelector {
            val fragment = DialogFragmentUnitSelector()
            val args = Bundle()
            args.putStringArray(ARG_UNITS, units)
            fragment.arguments = args
            return fragment
        }
    }

    fun setOnUnitSelectedListener(listener: OnUnitSelectedListener) {
        this.onUnitSelectedListener = listener
    }

    fun createRadioButtons(unitsArray: Array<String>) {

        // Clear all existing radio buttons
        radioGroupUnits.removeAllViews()

        for (unit in unitsArray) {
            val radioButton = RadioButton(context)
            radioButton.text = unit
            radioButton.id = View.generateViewId()
            radioGroupUnits.addView(radioButton)
        }


    }

}