package com.example.newslykotlincompose.data.mappers

import com.example.newslykotlincompose.data.local.ArticleEntity
import com.example.newslykotlincompose.data.remote.ArticleDto
import com.example.newslykotlincompose.domain.model.Article

fun ArticleDto.toArticleEntity(): ArticleEntity {
    return ArticleEntity(
        id = id,
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )
}

fun ArticleEntity.toArticle(): Article {
    return Article(
        id = id,
        author = author,
        title = title,
        description = description,
        url = url,
        urlToImage = urlToImage,
        publishedAt = publishedAt,
        content = content
    )
}