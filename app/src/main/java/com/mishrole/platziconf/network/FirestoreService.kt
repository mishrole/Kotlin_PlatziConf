package com.mishrole.platziconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.mishrole.platziconf.model.Conference
import com.mishrole.platziconf.model.Speaker

class FirestoreService {
    private val firebaseFirestore = FirebaseFirestore.getInstance()
    private val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    // Executes on class instance -> Persistence Enabled
    init {
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback : Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION)
            .orderBy(SPEAKERS_ORDER_BY)
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    callback.onSuccess(document.toObject(Speaker::class.java))
                    break
                }
            }
    }

    fun getConferences(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                for ( document in result) {
                    callback.onSuccess(document.toObject(Conference::class.java))
                    break
                }
            }
    }

    companion object FirestoreCollections {
        const val CONFERENCES_COLLECTION = "conferences"
        const val SPEAKERS_COLLECTION = "speakers"
        const val SPEAKERS_ORDER_BY = "category"
    }

}