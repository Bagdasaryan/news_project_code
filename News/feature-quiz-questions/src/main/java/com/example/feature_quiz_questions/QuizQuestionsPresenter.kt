package com.example.feature_quiz_questions

import android.widget.Button
import com.example.core_network.quiz_questions.QuizResponse

class QuizQuestionsPresenter(view: View) {
    private val mView = view

    fun loadQuizQuestions(quiz: QuizResponse) {
        mView.showQuizQuestions(quiz)
    }

    fun loadActiveProgressBar() {
        mView.activeProgressBar()
    }

    fun loadHideProgressBar() {
        mView.hideProgressBar()
    }

    fun loadClickFirst() {
        mView.clickFirstAnswer()
    }

    fun loadClickSecond() {
        mView.clickSecondAnswer()
    }

    fun loadClickThird() {
        mView.clickThirdAnswer()
    }

    fun loadClickFourth() {
        mView.clickFourthAnswer()
    }

    fun doButtonClickLogic(button: Button, pos: Int) {
        mView.buttonClickLogic(button, pos)
    }

    fun loadFinishWindow() {
        mView.showFinishWindow()
    }

    interface View {
        fun showQuizQuestions(quiz: QuizResponse)
        fun clickFirstAnswer()
        fun clickSecondAnswer()
        fun clickThirdAnswer()
        fun clickFourthAnswer()
        fun buttonClickLogic(button: Button, pos: Int)
        fun showFinishWindow()

        fun activeProgressBar()
        fun hideProgressBar()
    }
}