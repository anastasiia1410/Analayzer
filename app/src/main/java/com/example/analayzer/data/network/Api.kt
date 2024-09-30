package com.example.analayzer.data.network

import com.example.analayzer.data.network.entity.response.GetMessageResponse
import retrofit2.http.GET

interface Api {

    @GET("getUpdates")
    suspend fun getMessage(): GetMessageResponse

}