package com.tr4n.demoretrofit.data

import retrofit2.http.GET

interface PlaceholderApi {
    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
