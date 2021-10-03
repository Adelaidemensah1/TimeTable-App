package com.simplemobiletools.calendar.pro.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class OnlineLearningPlatform(
    val olpLogo: String? = null,
    val olpUrl: String? = null,
    val olpTitle: String? = null,
): Parcelable
