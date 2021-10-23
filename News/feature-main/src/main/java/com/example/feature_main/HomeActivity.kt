package com.example.feature_main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toolbar
import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.all_news.NewsStruct


class HomeActivity : AppCompatActivity(), HomePresenter.View {
    private var mPresenter: HomePresenter? = null
    private var mRepository: HomeRepository? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        mPresenter = HomePresenter(this)
        mRepository = HomeRepository(mPresenter!!)

        mRepository!!.getHomeNews()
    }

    override fun showListOfNews(news: AllNewsResponse) {
        println("Test -> ${news}")
        Toast.makeText(applicationContext, news.allNews!![0].newsDescription, Toast.LENGTH_SHORT).show()
    }
}
