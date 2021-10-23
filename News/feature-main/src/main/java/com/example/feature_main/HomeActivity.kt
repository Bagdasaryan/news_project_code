package com.example.feature_main

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.all_news.NewsStruct
import com.example.feature_main.recycler_two_columns.TwoColumnsAdapter


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
        val recyclerView: RecyclerView = findViewById(R.id.all_news_recycler)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val adapter = TwoColumnsAdapter(news.allNews!!, object: TwoColumnsAdapter.Callback {
            override fun onItemClicked(item: NewsStruct) {
                // Some code...
            }
        })
        recyclerView.adapter = adapter
    }
}
