package com.smartherd.covid_19stats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryInfo(
    val flag: String? = null

) : Parcelable