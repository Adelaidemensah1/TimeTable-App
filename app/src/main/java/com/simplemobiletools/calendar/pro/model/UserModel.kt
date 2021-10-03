package com.simplemobiletools.calendar.pro.model

 import android.os.Parcelable
 import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    var userName: String? = null,
    var userEmail: String? = null,
    var userProfileUrl: String? = null,
    var userId: String? = null

) : Parcelable
