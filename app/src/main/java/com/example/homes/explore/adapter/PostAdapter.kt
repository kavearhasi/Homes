package com.example.homes.explore.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homes.R
import com.example.homes.explore.data.Post

class PostAdapter(private val posts: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile: ImageView = itemView.findViewById(R.id.profile)
        val userName: TextView = itemView.findViewById(R.id.userName)
        val active: TextView = itemView.findViewById(R.id.active)
        val level: TextView = itemView.findViewById(R.id.level)
        val description: TextView = itemView.findViewById(R.id.description)
        val image1: ImageView = itemView.findViewById(R.id.image1)
        val image2: ImageView = itemView.findViewById(R.id.image2)
        val reaction: TextView = itemView.findViewById(R.id.likes)
        val likes: TextView = itemView.findViewById(R.id.thumbsUP)
        val comments: TextView = itemView.findViewById(R.id.comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.posts, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.profile.setImageResource(posts[position].profile)
        holder.userName.text = posts[position].userName
        holder.active.text = posts[position].active
        holder.level.text = posts[position].level
        holder.description.text = posts[position].description
        holder.image1.setImageResource(posts[position].image1)
        holder.image2.setImageResource(posts[position].image2)
        holder.reaction.text = posts[position].reaction
        holder.likes.text = posts[position].like.toString()
        holder.comments.text = posts[position].comment.toString()
    }
}