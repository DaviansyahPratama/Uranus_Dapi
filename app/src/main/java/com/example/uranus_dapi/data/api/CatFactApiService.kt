package com.example.uranus_dapi.data.api

import com.example.uranus_dapi.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
