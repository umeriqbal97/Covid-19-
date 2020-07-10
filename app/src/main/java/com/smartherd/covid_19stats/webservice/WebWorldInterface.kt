package com.smartherd.covid_19stats.webservice

import com.smartherd.covid_19stats.model.World
import retrofit2.Call
import retrofit2.http.GET

interface WebWorldInterface {

    @GET("all")
    fun getWorldData(): Call<World>
}