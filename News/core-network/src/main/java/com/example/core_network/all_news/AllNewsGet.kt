package com.example.core_network.all_news

import io.reactivex.Single
import retrofit2.http.GET

interface AllNewsGet {
    @GET("Bagdasaryan/news-project/main/ALL_NEWS/NewsFile.json")
    fun getAllNews(): Single<AllNewsResponse>
}
