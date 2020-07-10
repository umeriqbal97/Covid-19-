package com.smartherd.covid_19stats.webservice


import com.smartherd.covid_19stats.model.Country
import retrofit2.Call
import retrofit2.http.GET

interface WebCountriesInterface {

    @GET("countries")
    fun getCountriesList(): Call<List<Country>>
}