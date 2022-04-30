package com.example.mvp_staff.presenter

import com.example.mvp_staff.model.GetAllStafResponseItem
import com.example.mvp_staff.network.ApiStafClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StafPresenter(val viewStafView: StafView) {
    fun getDataStaf(){
        ApiStafClient.instance.getAllStaf()
            .enqueue(object : Callback<List<GetAllStafResponseItem>> {
                override fun onResponse(
                    call: Call<List<GetAllStafResponseItem>>,
                    response: Response<List<GetAllStafResponseItem>>
                ) {
                    if(response.isSuccessful){
                        viewStafView.onSuccess(response.message(), response.body()!!)
                    }else{
                        viewStafView.onFailed(response.message())
                    }
                }
                override fun onFailure(call: Call<List<GetAllStafResponseItem>>, t: Throwable) {
                    viewStafView.onFailed(t.message!!)
                }

            })
    }
}