package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ItemService {
    @GET("items")
    suspend fun getAllItems(): List<ItemModel>
}