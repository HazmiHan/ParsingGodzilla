package com.farhanhazmi.godzilla.network

//M Farhan Hazmi 10121081

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://superheroapi.com/api/ef42ba119aacd7b122fc1ee196069ee6/"

    val api: SuperheroApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperheroApi::class.java)
    }
}