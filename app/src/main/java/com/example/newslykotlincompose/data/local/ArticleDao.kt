package com.example.newslykotlincompose.data.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAllArticles(articles: List<ArticleEntity>)

    @Query("SELECT * FROM articleentity")
    fun getAllArticles(): List<ArticleEntity>

    @Delete
    suspend fun deleteArticle(article: ArticleEntity)
}