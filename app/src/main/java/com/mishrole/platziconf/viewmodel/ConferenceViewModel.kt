package com.mishrole.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mishrole.platziconf.model.Conference
import com.mishrole.platziconf.network.Callback
import com.mishrole.platziconf.network.FirestoreService
import java.lang.Exception

class ConferenceViewModel {
    private val firestoreService = FirestoreService()
    private val allConferences : MutableLiveData<List<Conference>> = MutableLiveData()
    private val isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getFirebaseConferences()
    }

    private fun getFirebaseConferences() {
        firestoreService.getConferences(object : Callback<List<Conference>> {

            override fun onSuccess(result: List<Conference>?) {
                allConferences.postValue(result)
                isProcessFinished()
            }

            override fun onFailed(exception: Exception) {
                isProcessFinished()
            }
        })
    }

    private fun isProcessFinished() {
        isLoading.value = true
    }
}