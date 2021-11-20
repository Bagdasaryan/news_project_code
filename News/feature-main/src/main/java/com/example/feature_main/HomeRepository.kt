package com.example.feature_main

import android.app.Activity
import android.content.Context
import android.widget.ProgressBar
import com.example.core_architecture.CreatePreferences
import com.example.core_architecture.UNWANTED_NEWS
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeRepository(homePresenter: HomePresenter, context: Context) {
    private var mPresenter: HomePresenter? = null
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private var mContext = context

    init {
        mPresenter = homePresenter
    }

    fun getHomeNews() {
        mPresenter!!.loadActiveProgressBar()
        mCompositeDisposable.add(HomeProvider().getAllNewsProvider().getAllNews()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                mPresenter!!.loadHideProgressBar()
                mPresenter!!.loadListOfNews(it)
            }, {
                mPresenter!!.loadHideProgressBar()
                println("ERROR")
            }))
    }

    fun getQuizRepository() {
        mPresenter!!.loadActiveProgressBar()
        mCompositeDisposable.add(HomeProvider().getAllQuizProvider().getAllQuestions()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                mPresenter!!.loadHideProgressBar()
                mPresenter!!.loadListOfQuiz(it)
            }, {
                mPresenter!!.loadHideProgressBar()
            })
        )
    }

    fun getUnwantedNews() {
        val data = CreatePreferences(mContext).getPreferencesData<String>(UNWANTED_NEWS) as String

        mPresenter!!.loadActiveProgressBar()
        mPresenter!!.loadHideUnwantedContent(data)
        mPresenter!!.loadHideProgressBar()
    }
}
