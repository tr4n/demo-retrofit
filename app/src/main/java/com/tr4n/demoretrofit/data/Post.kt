package com.tr4n.demoretrofit.data

import com.google.gson.annotations.SerializedName

// ...
//  {
//    "userId": 1,
//    "id": 1,
//    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
//    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
//  },
// ...
data class Post(
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)
