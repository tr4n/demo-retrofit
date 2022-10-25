package com.tr4n.demoretrofit.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tr4n.demoretrofit.data.ApiSingleton
import com.tr4n.demoretrofit.data.Post
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val api = ApiSingleton.getInstance()

    fun getPhotos(
        onLoadDataSuccess: (List<Post>) -> Unit,
        onLoadDataFailure: (Throwable) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val posts = api.getPosts()
                onLoadDataSuccess(posts)
            } catch (e: Exception) {
                onLoadDataFailure(e)
            }
        }

    }
}
