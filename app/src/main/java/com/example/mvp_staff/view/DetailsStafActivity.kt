package com.example.mvp_staff.view
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.mvp_staff.R
import com.example.mvp_staff.model.GetAllStafResponseItem
import com.example.mvp_staff.presenter.DetailStafPresenter
import com.example.mvp_staff.presenter.DetailStafView
import kotlinx.android.synthetic.main.activity_details_staf.*

class DetailsStafActivity : AppCompatActivity(), DetailStafView {
    private lateinit var presenter : DetailStafPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_staf)

        val staf = intent.getSerializableExtra("STAF") as GetAllStafResponseItem
        presenter = DetailStafPresenter(this, staf)
        presenter.getDataStaff()
    }

    override fun onProcessed(detail: GetAllStafResponseItem) {
        detail_staf_created_at.text = "Created at : \n${detail.createdAt}"
        detail_staf_name.text = "Name : \n${detail.name}"
        detail_staf_email.text = "Email : \n${detail.email}"
        Glide.with(detail_staf_image.context)
            .load(detail.image)
            .error(R.drawable.ic_launcher_background)
            .override(100, 160)
            .into(detail_staf_image)
    }
}