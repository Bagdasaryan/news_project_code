package com.example.feature_main

import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.all_news.NewsStruct
import com.example.core_network.quiz_questions.QuizResponse

class HomePresenter(view: View) {
    private var mView = view

    fun loadListOfNews(news: AllNewsResponse) {
        mView.showListOfNews(news)
    }

    fun loadHideUnwantedContent(newsName: String) {
        mView.hideUnwantedContent(newsName)
    }

    // for quiz
    fun loadListOfQuiz(quiz: QuizResponse) {
        mView.showListOfQuiz(quiz)
    }

    fun loadActiveProgressBar() {
        mView.activeProgressBar()
    }

    fun loadHideProgressBar() {
        mView.hideProgressBar()
    }

    interface View {
        fun showListOfNews(news: AllNewsResponse)
        fun hideUnwantedContent(newsName: String)

        // for quiz
        fun showListOfQuiz(quiz: QuizResponse)

        fun activeProgressBar()
        fun hideProgressBar()
    }
}