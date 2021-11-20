package com.example.core_network.quiz_questions

import com.google.gson.annotations.SerializedName

class QuizResponse {
    @SerializedName("QuizTypes")
    var quizTypes: List<QuizTypesStruct>? = listOf()

    @SerializedName("AllQuestions")
    var allQuestions: List<QuizStruct>? = listOf()
}

class QuizTypesStruct {
    @SerializedName("TypeName")
    var typeName: String? = ""

    @SerializedName("TypeCode")
    var typeCode: Int = 0

    @SerializedName("TypeImage")
    var typeImage: String? = ""
}

class QuizStruct {
    @SerializedName("QuizType")
    var questionType: Int = 0

    @SerializedName("Question")
    var question: String? = ""

    @SerializedName("AnswerFirst")
    var answerFirst: String? = ""

    @SerializedName("AnswerSecond")
    var answerSecond: String? = ""

    @SerializedName("AnswerThird")
    var answerThird: String? = ""

    @SerializedName("AnswerFourth")
    var answerFourth: String? = ""

    @SerializedName("RightAnswer")
    var rightAnswer: Int = 0
}
