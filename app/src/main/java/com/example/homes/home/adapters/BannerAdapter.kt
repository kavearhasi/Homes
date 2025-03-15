package com.example.homes.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.homes.R

class BannerAdapter(private val imageList: List<Int>) :
    RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {
    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById<ImageView>(R.id.bannerImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.banner_slider, parent, false)
        return BannerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.imageView.setImageResource(imageList[position])
    }
}