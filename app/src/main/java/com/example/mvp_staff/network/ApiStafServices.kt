package com.example.mvp_staff.network

import com.example.mvp_staff.model.GetAllStafResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiStafServices {
    @GET("staf")
    fun getAllStaf() : Call<List<GetAllStafResponseItem>>
}