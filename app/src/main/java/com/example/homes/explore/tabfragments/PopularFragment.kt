package com.example.homes.explore.tabfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.homes.R
import com.example.homes.explore.adapter.PostAdapter
import com.example.homes.explore.data.Post


class PopularFragment : Fragment() {

    private lateinit var postAdapter: PostAdapter
    private lateinit var postView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val posts = listOf(
            Post(
                R.drawable.profile1,
                "David Yu",
                "1 hr ago",
                "Level 1",
                "This sofa is a dream! Unbelievably comfortable and the perfect centerpiece for our living room, we are in love with it. ",
                R.drawable.post1img1,
                R.drawable.post1img2,
                "mary and 20 others reacted",
                221,
                100
            ),
            Post(
                R.drawable.profile2,
                "Ben Lyric",
                "10 hr ago",
                "Level 3",
                "Our new  table is absolutely stunning! It's the perfect blend of style and durability, making every meal feel special. ",
                R.drawable.post2img1,
                R.drawable.post2img2,
                "chris and 45 others reacted",
                456,
                200
            )
        )

        init(view, posts)

    }

    private fun init(view: View, posts: List<Post>) {
        postView = view.findViewById(R.id.posts)
        postAdapter = PostAdapter(posts)
        postView.adapter = postAdapter
        postView.layoutManager = LinearLayoutManager(context)

    }

}