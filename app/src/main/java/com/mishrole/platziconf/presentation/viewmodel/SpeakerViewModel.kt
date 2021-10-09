package com.mishrole.platziconf.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mishrole.platziconf.core.entity.Speaker
import com.mishrole.platziconf.network.Callback
import com.mishrole.platziconf.network.FirestoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class SpeakerViewModel : BaseViewModel() {
    private val firestoreService = FirestoreService()
    val speakersListResult : MutableLiveData<List<Speaker>> = MutableLiveData()

    fun refreshSpeakers() {
        setLoadingStatus(true)
        getFirebaseSpeakers()
    }

    private fun setLoadingStatus(status : Boolean) {
        loadingStatus.postValue(status)
    }

    private fun getFirebaseSpeakers() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    firestoreService.getSpeakers(object : Callback<List<Speaker>> {

                        override fun onSuccess(result: List<Speaker>?) {
                            speakersListResult.postValue(result)
                            setLoadingStatus(false)
                        }

                        override fun onFailed(exception: Exception) {
                            Log.e("getFirebaseSpeakers", "$exception")
                        }
                    })
                } catch (ex: Exception) {
                    Log.e("getFirebaseSpeakers", "$ex")
                }
            }
        }
    }

}