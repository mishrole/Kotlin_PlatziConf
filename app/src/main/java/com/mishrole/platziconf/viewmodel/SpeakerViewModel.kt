package com.mishrole.platziconf.viewmodel

import androidx.lifecycle.MutableLiveData
import com.mishrole.platziconf.model.Speaker
import com.mishrole.platziconf.network.Callback
import com.mishrole.platziconf.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel {
    private val firestoreService = FirestoreService()
    private val allSpeakers : MutableLiveData<List<Speaker>> = MutableLiveData()
    private val isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getFirebaseSpeakers()
    }

    private fun getFirebaseSpeakers() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {

            override fun onSuccess(result: List<Speaker>?) {
                allSpeakers.postValue(result)
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