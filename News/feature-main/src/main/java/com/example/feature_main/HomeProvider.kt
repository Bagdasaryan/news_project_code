package com.example.feature_main

import com.example.core_network.Endpoints
import com.example.core_network.NewsAppEndpoint
import com.example.core_network.QuizAppEndpoint
import com.example.core_network.all_news.AllNewsGet
import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.quiz_questions.QuizGet
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class HomeProvider {
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getAllNewsProvider(): AllNewsGet {
        println("Endpoint -> ${Endpoints.Alpha.link}")

        return Retrofit.Builder()
            .baseUrl(NewsAppEndpoint)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AllNewsGet::class.java)
    }

    fun getAllQuizProvider(): QuizGet {
        return Retrofit.Builder()
            .baseUrl(QuizAppEndpoint)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(QuizGet::class.java)
    }
}
