package com.bigranch.android.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    /*Database doesn't work from book, most likely outdated*/

    private val crimeRepository = CrimeRepository.get()
    var crimeListLiveData = crimeRepository.getCrimes()

    /*init {
        //val crimeList = mutableListOf<Crime>()
        for (i in 0 until 10) {
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.isSolved= i%2 == 0
            crimeRepository.addCrime(crime)
        }
        //crimeListLiveData = MutableLiveData<MutableList<Crime>>().apply { postValue(crimeList) }
    }*/
}