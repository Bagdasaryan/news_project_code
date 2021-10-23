package com.example.feature_main

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeRepository(homePresenter: HomePresenter) {
    private var mPresenter: HomePresenter? = null
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()

    init {
        mPresenter = homePresenter
    }

    fun getHomeNews() {
        mCompositeDisposable.add(HomeProvider().getAllNewsProvider().getAllNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                mPresenter!!.loadListOfNews(it)
            }, {
                println("ERROR")
            }))
    }
}
