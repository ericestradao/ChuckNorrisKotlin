package com.example.user.chucknorriskotlin.Model

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface ChuckNorrisInterface {

    @GET("random")
    fun getJokes(): Call<ChuckNorrisPojo>

    @GET("random?")
    fun getCharacter(@Query("firstName") firstName : String,
                     @Query("lastName") lastName : String): Call<NeverEndingPojo>

    @GET("random/20")
    fun getList(): Call<NeverEndingPojo>


}