package com.example.feature_main

import com.example.core_network.Endpoints
import com.example.core_network.all_news.AllNewsGet
import com.example.core_network.all_news.AllNewsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HomeProvider {
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getAllNewsProvider(): AllNewsGet {
        println("Endpoint -> ${Endpoints.Alpha.link}")

        return Retrofit.Builder()
            .baseUrl(Endpoints.Alpha.link)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(AllNewsGet::class.java)
    }
}
