package com.sergeyjojo.todolisttrain.NetworkService

import com.sergeyjojo.todolisttrain.NetworkService.MatchResponse.MatchResponse
import com.sergeyjojo.todolisttrain.NetworkService.ProfileResponse.ProfileData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitIServiceInterface {

    @GET("players/{account_id}")
    suspend fun account_id(@Path("account_id") id: Int): Call<ProfileData>

    @GET("matches/{match_id}")
    suspend fun match_id(@Path("match_id") id: Int): Call<MatchResponse>

}