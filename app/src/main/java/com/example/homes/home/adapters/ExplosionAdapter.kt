package com.example.homes.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homes.R
import com.example.homes.home.data.Explosion

class ExplosionAdapter(private val explosion: List<Explosion>) :
    RecyclerView.Adapter<ExplosionAdapter.ExplosionViewHolder>() {
    inner class ExplosionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val explosionImageLeft: ImageView =
            itemView.findViewById(R.id.explosionImageLeft)
        val explosionTextLeft: TextView = itemView.findViewById(R.id.explosionTextLeft)
        val explosionImageRight: ImageView =
            itemView.findViewById(R.id.explosionImageRight)
        val explosionTextRight: TextView = itemView.findViewById(R.id.explosionTextRight)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExplosionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.explosion_slider, parent, false)
        return ExplosionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return explosion.size
    }

    override fun onBindViewHolder(holder: ExplosionViewHolder, position: Int) {

        val leftExplosion = explosion[position]
        val rightExplosion = explosion.getOrElse(position + 1) { leftExplosion }

        holder.explosionImageLeft.setImageResource(leftExplosion.image)
        holder.explosionTextLeft.text = leftExplosion.imageText

        holder.explosionImageRight.setImageResource(rightExplosion.image)
        holder.explosionTextRight.text = rightExplosion.imageText
    }
}