package com.example.feature_quiz_questions

import android.content.Context
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class QuizQuestionsRepository(quizPresenter: QuizQuestionsPresenter, context: Context) {
    private var mPresenter = quizPresenter
    private var mCompositeDisposable: CompositeDisposable = CompositeDisposable()
    private var mContext = context

    fun getQuizRepository() {
        mPresenter.loadActiveProgressBar()
        mCompositeDisposable.add(QuizQuestionsProvider().getAllQuizProvider().getAllQuestions()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({
                mPresenter.loadHideProgressBar()
                mPresenter.loadQuizQuestions(it)
            }, {
                mPresenter.loadHideProgressBar()
            }))
    }
}