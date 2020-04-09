package com.bigranch.android.criminalintent

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

private const val ARG_TIME = "time"

@Suppress("DEPRECATION")
class TimePickerFragment: DialogFragment() {

    interface Callbacks {
        fun onTimeSelected(hour: Int, minutes: Int)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val timeListener = TimePickerDialog.OnTimeSetListener {
                _: TimePicker, hour:Int, minute:Int ->

            targetFragment?.let { fragment ->
                (fragment as Callbacks).onTimeSelected(hour, minute)
            }
        }

        val date = arguments?.get(ARG_TIME) as Date
        val hour = date.hours
        val minute = date.minutes

        return TimePickerDialog(requireContext(), timeListener, hour, minute, true)
    }

    companion object {
        fun newInstance(date:Date): TimePickerFragment {
            val args = Bundle().apply {
                putSerializable(ARG_TIME, date)
            }

            return TimePickerFragment().apply {
                arguments = args
            }
        }
    }
}