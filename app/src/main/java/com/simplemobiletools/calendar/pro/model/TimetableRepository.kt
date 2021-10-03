package com.simplemobiletools.calendar.pro.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore


class TimetableRepository(
    private val firestore_DB: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val executiveRef: CollectionReference = firestore_DB.collection( "onlineLearningPlatform")
) {
    private val onlineLearningPlatform: MutableLiveData<List<OnlineLearningPlatform>> = MutableLiveData<List<OnlineLearningPlatform>>()


    //Get online Learning Platforms from firestore
    fun getLessons(): LiveData<List<OnlineLearningPlatform>> {
        executiveRef.addSnapshotListener { value, error ->
            val lessons: MutableList<OnlineLearningPlatform> = ArrayList()
            if (value != null) {
                for (doc in value) {
                    if (doc != null) {
                        lessons.add(doc.toObject(OnlineLearningPlatform::class.java))
                    }
                }
            }
            onlineLearningPlatform.postValue(lessons)
        }
        return onlineLearningPlatform
    }
}