package com.bigranch.android.criminalintent

import java.text.DateFormat
import java.util.*

data class Crime(val id: UUID =UUID.randomUUID(),
                 var title:String = "",
                 var date: String = DateFormat.getDateInstance(DateFormat.FULL, Locale.ENGLISH).format(Date().time),
                 var isSolved:Boolean = false,
                 var requiresPolice: Boolean = false){

}