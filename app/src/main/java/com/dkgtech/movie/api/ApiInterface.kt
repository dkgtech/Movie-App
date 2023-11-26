package com.dkgtech.movie.api

import com.dkgtech.movie.model.DataModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    @GET("getWhatsStreaming")
    @Headers(
        "X-RapidAPI-Key: ac07a503edmshbf4fc6fc1e76a8dp1a9d8fjsnbfca73785334",
        "X-RapidAPI-Host:imdb188.p.rapidapi.com "
    )
    fun getWhatsStreaming(
        @Query("country") country: String,
    ): Call<DataModel>

    @GET("getWeekTop10")
    fun getWeeklyTop10Movies(): Call<DataModel>


    companion object {
        const val BASE_URL = "https://imdb188.p.rapidapi.com/api/v1/"

        fun create(): ApiInterface {
            val retrofit =
                Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return retrofit.create(ApiInterface::class.java)
        }

    }

}