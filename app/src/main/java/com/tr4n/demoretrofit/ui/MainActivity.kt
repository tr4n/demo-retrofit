package com.tr4n.demoretrofit.ui

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.tr4n.demoretrofit.R
import com.tr4n.demoretrofit.data.ApiSingleton
import com.tr4n.demoretrofit.data.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiSingleton.getInstance().getPosts().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                val posts = response.body() ?: emptyList()
                val postTitles =
                    posts.joinToString(transform = { it.title }, separator = "\n--------\n")
                findViewById<TextView>(R.id.textPosts).text = postTitles
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                Log.e("TAG", "onFailure: ", t)
            }
        })
    }
}