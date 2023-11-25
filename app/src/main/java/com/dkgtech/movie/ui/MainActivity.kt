package com.dkgtech.movie.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.movie.adapter.RecyclerWhatStreaming
import com.dkgtech.movie.api.ApiInterface
import com.dkgtech.movie.databinding.ActivityMainBinding
import com.dkgtech.movie.model.DataModel
import com.dkgtech.movie.model.Title
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var arrData: List<Title>

    companion object {
        const val BASE_URL = "https://imdb188.p.rapidapi.com/api/v1/"
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {

            getWhatStreaming("US")

        }
    }

    private fun getWhatStreaming(country: String) {
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiInterface::class.java)

        retrofit.getWhatsStreaming(country)
            .enqueue(object : Callback<DataModel> {
                override fun onResponse(
                    call: Call<DataModel>,
                    response: Response<DataModel>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            val data = response.body()!!.data
                            /* val options = BitmapFactory.Options()
                             options.inSampleSize = 2 // Adjust the value as needed
                             val bitmap = BitmapFactory.decodeFile("${data[0].edges}", options)
                             val maxWidth = 800
                             val maxHeight = 600
                             val scaledBitmap =
                                 Bitmap.createScaledBitmap(bitmap, maxWidth, maxHeight, true)*/


                            binding.rcViewGetWhatStreaming.layoutManager =
                                GridLayoutManager(this@MainActivity, 2)
                            binding.rcViewGetWhatStreaming.adapter =
                                RecyclerWhatStreaming(
                                    this@MainActivity,
                                    arrData = data[0].edges
                                )

                        }
                    }
                }

                override fun onFailure(call: Call<DataModel>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }


            })

    }

}