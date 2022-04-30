package com.example.mvp_staff.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvp_staff.R
import com.example.mvp_staff.model.GetAllStafResponseItem
import kotlinx.android.synthetic.main.item_staf.view.*

class StafAdapter(
    private val listStaf : List<GetAllStafResponseItem>,
    val onClick : (GetAllStafResponseItem) -> Unit
    ) :
    RecyclerView.Adapter<StafAdapter.ViewHolder>() {
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StafAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_staf, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StafAdapter.ViewHolder, position: Int) {
        with(holder.itemView){
            with(listStaf[position]){
                staff_created_at.text = "Created at : \n$createdAt"
                staff_name.text = "Name : \n$name"
                staff_email.text = "Email : \n$email"
                Glide.with(staff_image.context)
                    .load(image)
                    .error(R.drawable.ic_launcher_background)
                    .override(50, 80)
                    .into(staff_image)
                staff_see_details.setOnClickListener {
                    onClick(listStaf[position]!!)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return listStaf.size
    }
}