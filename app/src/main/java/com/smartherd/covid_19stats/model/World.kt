package com.smartherd.covid_19stats.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class World(
	val recoveredPerOneMillion: Double? = null,
	val cases: Int? = null,
	val critical: Int? = null,
	val oneCasePerPeople: Int? = null,
	val active: Int? = null,
	val testsPerOneMillion: Double? = null,
	val population: Long? = null,
	val affectedCountries: Int? = null,
	val oneDeathPerPeople: Int? = null,
	val recovered: Int? = null,
	val oneTestPerPeople: Int? = null,
	val tests: Int? = null,
	val criticalPerOneMillion: Double? = null,
	val deathsPerOneMillion: Double? = null,
	val todayRecovered: Int? = null,
	val casesPerOneMillion: Int? = null,
	val updated: Long? = null,
	val deaths: Int? = null,
	val activePerOneMillion: Double? = null,
	val todayCases: Int? = null,
	val todayDeaths: Int? = null
) : Parcelable

