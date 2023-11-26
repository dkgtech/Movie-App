package com.dkgtech.movie.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Orientation
import com.dkgtech.movie.adapter.RecyclerWhatStreaming
import com.dkgtech.movie.api.ApiInterface
import com.dkgtech.movie.databinding.ActivityMainBinding
import com.dkgtech.movie.model.DataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val apiInterface = ApiInterface.create()

    companion object {
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

        apiInterface.getWhatsStreaming(country)
            .enqueue(object : Callback<DataModel> {
                override fun onResponse(
                    call: Call<DataModel>,
                    response: Response<DataModel>
                ) {
                    if (response.isSuccessful) {
                        response.body().let {
                            val data = response.body()!!.data

                            binding.rcViewGetWhatStreaming.layoutManager =
                                LinearLayoutManager(
                                    this@MainActivity,
                                    LinearLayoutManager.HORIZONTAL, false
                                )
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