package com.example.animalapp.repository

import com.example.animalapp.api.ApiService
import com.example.animalapp.api.RetrofitInstance
import com.example.animalapp.model.AnimalType
import com.example.animalapp.utils.Resource
import retrofit2.await


class AnimalTypeRepoImpl : AnimalTypeRepo {
    override suspend fun getAnimalType(): Resource<List<AnimalType>> {
        return try {
            val result = RetrofitInstance.api.getAnimalType().await()
            Resource.success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.error(e.toString())
        }
    }
}