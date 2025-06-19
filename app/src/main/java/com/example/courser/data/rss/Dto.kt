package com.example.courser.data.rss

import retrofit2.Response
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url

interface Dto {
    @GET
    suspend fun downloadJson(@Url fileUrl: String): Response<ResponseBody>
}
