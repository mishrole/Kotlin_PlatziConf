package com.mishrole.platziconf.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.mishrole.platziconf.core.entity.Conference
import com.mishrole.platziconf.core.entity.Speaker

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
                callback.onSuccess(result.toObjects(Speaker::class.java))
            }
    }

    fun getConferences(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION)
            .get()
            .addOnSuccessListener { result ->
                callback.onSuccess(result.toObjects(Conference::class.java))
            }
    }

    companion object FirestoreCollections {
        const val CONFERENCES_COLLECTION = "conferences"
        const val SPEAKERS_COLLECTION = "speakers"
        const val SPEAKERS_ORDER_BY = "category"
    }

}