package com.example.mvp_staff.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvp_staff.R
import com.example.mvp_staff.adapter.StafAdapter
import com.example.mvp_staff.model.GetAllStafResponseItem
import com.example.mvp_staff.presenter.StafPresenter
import com.example.mvp_staff.presenter.StafView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), StafView {
    private lateinit var presenter : StafPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = StafPresenter(this)
        presenter.getDataStaf()
    }

    override fun onSuccess(pesan: String, newsData: List<GetAllStafResponseItem>) {
        rv_staf.layoutManager = LinearLayoutManager(this)
        rv_staf.adapter = StafAdapter(newsData){
            val intent = Intent(this, DetailsStafActivity::class.java)
            intent.putExtra("STAF", it)
            startActivity(intent)
        }
    }

    override fun onFailed(pesan: String) {
        Toast.makeText(this, pesan, Toast.LENGTH_SHORT).show()
    }
}