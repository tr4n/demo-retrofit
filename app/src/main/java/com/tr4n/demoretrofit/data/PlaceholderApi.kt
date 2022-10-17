package com.tr4n.demoretrofit.data

import retrofit2.Call
import retrofit2.http.GET

interface PlaceholderApi {
    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}
