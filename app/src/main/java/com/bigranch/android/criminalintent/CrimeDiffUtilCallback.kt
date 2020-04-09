package com.bigranch.android.criminalintent

import androidx.recyclerview.widget.DiffUtil

/*
* This Class is used for the Ch 12 challenge but submit list doesn't work with my emulator
* */

class CrimeDiffUtilCallback : DiffUtil.ItemCallback<Crime>() {
    override fun areItemsTheSame(oldItem: Crime, newItem: Crime): Boolean {
        return oldItem.id == newItem.id
        /*return (oldItem.title == newItem.title) &&
                (oldItem.date == newItem.date) &&
                (oldItem.id == newItem.id) &&
                (oldItem.isSolved == newItem.isSolved)*/
    }

    override fun areContentsTheSame(oldItem: Crime, newItem: Crime): Boolean {
        return oldItem== newItem
        /*return (oldItem.title == newItem.title) &&
                (oldItem.date == newItem.date) &&
                (oldItem.id == newItem.id) &&
                (oldItem.isSolved == newItem.isSolved)*/
    }

}