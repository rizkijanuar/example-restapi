package com.example.examplerestapi.data.api

import com.example.examplerestapi.data.response.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Routes {

    @GET("movie/now_playing")
    suspend fun getNowPlaying(
        @Header("Authorization") token: String,
        @Query("language") lang: String,
        @Query("page") page: Int,
        @Query("region") region: String
    ): NowPlayingResponse


}