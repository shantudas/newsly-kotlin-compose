package com.example.newslykotlincompose.di

import android.content.Context
import androidx.room.Room
import com.example.newslykotlincompose.data.local.ArticleDatabase
import com.example.newslykotlincompose.data.remote.ArticleApi
import com.example.newslykotlincompose.data.remote.ArticleRepositoryImpl
import com.example.newslykotlincompose.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideArticleDatabase(@ApplicationContext context: Context): ArticleDatabase {
        return Room.databaseBuilder(
            context,
            ArticleDatabase::class.java,
            "articles.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideArticleApi(): ArticleApi {
        return Retrofit.Builder()
            .baseUrl(ArticleApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideArticleRepository(api: ArticleApi): ArticleRepository {
        return ArticleRepositoryImpl(api)
    }

}