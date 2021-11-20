package com.example.feature_quiz_questions

import com.example.core_network.QuizAppEndpoint
import com.example.core_network.quiz_questions.QuizGet
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class QuizQuestionsProvider {
    fun getAllQuizProvider(): QuizGet {
        return Retrofit.Builder()
            .baseUrl(QuizAppEndpoint)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(QuizGet::class.java)
    }
}
