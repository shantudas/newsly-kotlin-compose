package com.example.newslykotlincompose.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newslykotlincompose.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    val repository: ArticleRepository,
) : ViewModel() {

    companion object {
        const val TAG = "ArticleListViewModel"
    }
    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            val results = repository.getArticles()
            Log.d(TAG, "getArticles: "+results.body()?.status)
            Log.d(TAG, "getArticles: "+results.body()?.articles?.size)
            Log.d(TAG, "getArticles: "+results.body()?.totalResults)
        }
    }
}