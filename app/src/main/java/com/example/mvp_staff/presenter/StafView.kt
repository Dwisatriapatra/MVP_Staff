package com.example.mvp_staff.presenter

import com.example.mvp_staff.model.GetAllStafResponseItem

interface StafView {
    fun onSuccess(pesan : String, newsData : List<GetAllStafResponseItem>)
    fun onFailed(pesan : String)
}