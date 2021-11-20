package com.example.core_network

enum class Endpoints(val link: String) {
    Alpha("https://raw.githubusercontent.com/"),
    Beta(""),
    Production("")
}

enum class FileLocation(val location: String) {
    QuizQuestionsEng("Bagdasaryan/news-project/main/QUIZ_QUESTIONS/QuizQuestionsEng.json")
}

val NewsAppEndpoint = Endpoints.Alpha.link
val QuizAppEndpoint = Endpoints.Alpha.link
