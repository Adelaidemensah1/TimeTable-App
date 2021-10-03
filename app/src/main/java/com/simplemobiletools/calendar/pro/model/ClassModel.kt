package com.simplemobiletools.calendar.pro.model

 import android.os.Parcelable
 import kotlinx.parcelize.Parcelize

@Parcelize
data class ClassModel(
    var courseName: String? = null,
    var courseDescription: String? = null,
    var courseLink: String? = null,
    var courseId: String? = null

) : Parcelable
