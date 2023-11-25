package com.dkgtech.movie.api

import com.dkgtech.movie.model.DataModel
import com.dkgtech.movie.model.Title
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
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

}