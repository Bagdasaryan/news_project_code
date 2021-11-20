package com.example.core_network.quiz_questions

import com.example.core_network.Endpoints
import com.example.core_network.FileLocation
import io.reactivex.Single
import retrofit2.http.GET

interface QuizGet {
    @GET("Bagdasaryan/news-project/main/QUIZ_QUESTIONS/QuizQuestionsEng.json")
    fun getAllQuestions(): Single<QuizResponse>
}
