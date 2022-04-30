package com.example.mvp_staff.presenter

import com.example.mvp_staff.model.GetAllStafResponseItem

interface DetailStafView {
    fun onProcessed(detail : GetAllStafResponseItem)
}