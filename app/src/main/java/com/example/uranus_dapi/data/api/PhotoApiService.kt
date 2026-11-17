package com.example.uranus_dapi.data.api

import com.example.uranus_dapi.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}
