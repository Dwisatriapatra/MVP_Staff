package com.example.mvp_staff.presenter

import com.example.mvp_staff.model.GetAllStafResponseItem

class DetailStafPresenter(private val detailStafView: DetailStafView, private val detailStaf : GetAllStafResponseItem) {
    fun getDataStaff(){
        detailStafView.onProcessed(detailStaf)
    }
}