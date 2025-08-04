package com.example.convercalc

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DialogFragmentUnitSelector: DialogFragment() {

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {

            val builder = AlertDialog.Builder(it)
            val inflater = LayoutInflater.from(it)
            val view = inflater.inflate(R.layout.dialog_unit_selector, null)

            val buttonExit: Button = view.findViewById(R.id.button_dialog_unit_selector_exit)

            buttonExit.setOnClickListener {
                dismiss()
            }

            builder.setView(view)
            builder.create()


        } ?: throw IllegalStateException("Activity cannot be null")
    }

}