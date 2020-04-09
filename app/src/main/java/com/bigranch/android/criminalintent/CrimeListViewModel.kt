package com.bigranch.android.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    /*Database doesn't work from book, most likely outdated*/

    private val crimeRepository = CrimeRepository.get()
    var crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime: Crime) {
        crimeRepository.addCrime(crime)
    }
}