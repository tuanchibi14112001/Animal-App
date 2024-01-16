package com.example.animalapp.api

import com.example.animalapp.utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitInstance {
    companion object{
       private val retrofit by lazy {
           Retrofit.Builder()
               .baseUrl(Constant.BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
       }
        val api: ApiService by lazy {
            retrofit.create(ApiService::class.java)
        }
    }
}