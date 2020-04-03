package com.bigranch.android.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    var crimeListLiveData = crimeRepository.getCrimes()

    init {
        val crime = Crime()
        crimeListLiveData = MutableLiveData<List<Crime>>().apply { postValue(listOf(crime)) }
    }
}