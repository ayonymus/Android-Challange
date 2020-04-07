package com.ayon.marvel.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comic(
    val title: String,
    val description: String?,
    val thumbnail: String
): Parcelable