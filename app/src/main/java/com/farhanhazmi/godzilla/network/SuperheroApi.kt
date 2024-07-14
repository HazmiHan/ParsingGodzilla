package com.farhanhazmi.godzilla.network

//M Farhan Hazmi 10121081

import com.farhanhazmi.godzilla.model.Superhero
import retrofit2.Call
import retrofit2.http.GET

interface SuperheroApi {
    @GET("287")
    fun getSuperhero(): Call<Superhero>
}