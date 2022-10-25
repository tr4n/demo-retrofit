package com.tr4n.demoretrofit.ui

import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.tr4n.demoretrofit.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textPosts = findViewById<TextView>(R.id.textPosts)

        progressBar.isVisible = true
        textPosts.isVisible = false

        viewModel.getPhotos(
            onLoadDataSuccess = { posts ->
                val postTitles =
                    posts.joinToString(transform = { it.title }, separator = "\n--------\n")
                textPosts.text = postTitles
                textPosts.isVisible = true
                progressBar.isVisible = false
            },
            onLoadDataFailure = {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                progressBar.isVisible = false
            }
        )
    }
}
