package com.example.feature_main

import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.all_news.NewsStruct

class HomePresenter(view: View) {
    private var mView: View? = null

    init {
        mView = view
    }

    fun loadListOfNews(news: AllNewsResponse) {
        mView!!.showListOfNews(news)
    }

    interface View {
        fun showListOfNews(news: AllNewsResponse)
    }
}