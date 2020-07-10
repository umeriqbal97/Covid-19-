package com.smartherd.covid_19stats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
	val continent: String? = null,
	val country: String? = null,
	val recoveredPerOneMillion: Double? = null,
	val cases: Int? = null,
	val critical: Int? = null,
	val oneCasePerPeople: Int? = null,
	val active: Int? = null,
	val testsPerOneMillion: Int? = null,
	val population: Int? = null,
	val oneDeathPerPeople: Int? = null,
	val recovered: Int? = null,
	val oneTestPerPeople: Int? = null,
	val tests: Int? = null,
	val criticalPerOneMillion: Double? = null,
	val deathsPerOneMillion: Int? = null,
	val todayRecovered: Int? = null,
	val casesPerOneMillion: Int? = null,
	val countryInfo: CountryInfo? = null,
	val updated: Long? = null,
	val deaths: Int? = null,
	val activePerOneMillion: Double? = null,
	val todayCases: Int? = null,
	val todayDeaths: Int? = null
) : Parcelable

@Parcelize
data class CountryInfo(
	val flag: String? = null,
	val id: Int? = null,
	val iso2: String? = null,
	val lat: Int? = null,
	val jsonMemberLong: Int? = null,
	val iso3: String? = null
) : Parcelable

