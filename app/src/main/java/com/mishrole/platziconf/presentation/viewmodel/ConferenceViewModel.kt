package com.mishrole.platziconf.presentation.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mishrole.platziconf.core.entity.Conference
import com.mishrole.platziconf.network.Callback
import com.mishrole.platziconf.network.FirestoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ConferenceViewModel : BaseViewModel() {
    private val firestoreService = FirestoreService()
    val conferencesListResult : MutableLiveData<List<Conference>> = MutableLiveData()

    fun refreshConferences() {
        setLoadingStatus(true)
        getFirebaseConferences()
    }

    private fun setLoadingStatus(status : Boolean) {
        loadingStatus.postValue(status)
    }

    private fun getFirebaseConferences() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                try {
                    firestoreService.getConferences(object : Callback<List<Conference>> {

                        override fun onSuccess(result: List<Conference>?) {
                            conferencesListResult.postValue(result)
                            setLoadingStatus(false)
                        }

                        override fun onFailed(exception: Exception) {
                            Log.e("getFirebaseConferences", "$exception")
                        }
                    })
                } catch (ex: Exception) {
                    Log.e("getFirebaseConferences", "$ex")
                }
            }
        }
    }

}