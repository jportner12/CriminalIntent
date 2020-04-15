package com.bigranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat
import java.util.*

@Entity
data class Crime(@PrimaryKey val id: UUID =UUID.randomUUID(),
                 var title:String = "",
                 var date: Date = Date(),
                 //var date: String = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH).format(Date().time), // Turned this off for the emulator to test
                 var isSolved:Boolean = false,
                 //var requiresPolice: Boolean = false) //this must be deleted because of the database testing
                 var suspect: String = "",
                 var number: String = "")
