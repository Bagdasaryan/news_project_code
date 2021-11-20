package com.example.feature_quiz_questions

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_architecture.QUIZ_TYPE_CODE
import com.example.core_network.quiz_questions.QuizResponse
import com.example.core_network.quiz_questions.QuizStruct
import com.example.feature_quiz_questions.adapters.QuizFinishAdapter
import com.example.feature_quiz_questions.model.QuizAnswersModel

class QuizQuestionsActivity: AppCompatActivity(), QuizQuestionsPresenter.View {
    private var mPresenter: QuizQuestionsPresenter? = null
    private var mRepository: QuizQuestionsRepository? = null
    private var progressBar: ProgressBar? = null
    private var quizScreen: LinearLayout? = null
    private var quizList: List<QuizStruct>? = listOf()
    private var position = 0
    private var points = 0
    private var timer: CountDownTimer? = null
    private var incorrectlyAnsweredQuestions: MutableList<QuizAnswersModel>? = mutableListOf()
    private var rightAnswerText = ""

    private var mainLayout: LinearLayout? = null
    private var finishLayout: LinearLayout? = null

    private var btnFirst: Button? = null
    private var btnSecond: Button? = null
    private var btnThird: Button? = null
    private var btnFourth: Button? = null
    private var tvPosition: TextView? = null
    private var tvQuestion: TextView? = null
    private var tvTime: TextView? = null
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_quiz_question)

        mainLayout = findViewById(R.id.quiz_screen)
        finishLayout = findViewById(R.id.finish_window)

        progressBar = findViewById(R.id.progress_bar)
        btnFirst = findViewById(R.id.btnFirst)
        btnSecond = findViewById(R.id.btnSecond)
        btnThird = findViewById(R.id.btnThird)
        btnFourth = findViewById(R.id.btnFourth)
        tvPosition = findViewById(R.id.tvPosition)
        tvQuestion = findViewById(R.id.tvQuestion)
        tvTime = findViewById(R.id.tvTime)
        mRecyclerView = findViewById(R.id.recycler_finish)

        startProgram()
    }

    private fun startProgram() {
        mPresenter = QuizQuestionsPresenter(this)
        mRepository = QuizQuestionsRepository(mPresenter!!, applicationContext)

        mRepository!!.getQuizRepository()
    }

    override fun showQuizQuestions(quiz: QuizResponse) {

        quizList = quiz.allQuestions!!.filter { it.questionType == intent.getIntExtra(QUIZ_TYPE_CODE, -1) }

        tvPosition!!.text = "${points}/${quizList!!.size}"
        if(position < quizList!!.size) {
            rightAnswerText = when(quizList!![position].rightAnswer) {
                1 -> {
                    quizList!![position].answerFirst!!
                }
                2 -> {
                    quizList!![position].answerSecond!!
                }
                3 -> {
                    quizList!![position].answerThird!!
                } else -> {
                    quizList!![position].answerFourth!!
                }
            }

            timer = object: CountDownTimer(30000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    if(millisUntilFinished/1000 > 9) {
                        tvTime!!.text = "00:${(millisUntilFinished/1000)}"
                    } else {
                        tvTime!!.text = "00:0${(millisUntilFinished/1000)}"
                    }
                }
                override fun onFinish() {
                    incorrectlyAnsweredQuestions!!.add(QuizAnswersModel(
                        quizList!![position].question,
                        "",
                        rightAnswerText
                    ))
                    position++
                    timer!!.cancel()
                    startProgram()
                }
            }
            timer!!.start()

            tvQuestion!!.text = quizList!![position].question
            btnFirst!!.text = quizList!![position].answerFirst
            btnSecond!!.text = quizList!![position].answerSecond
            btnThird!!.text = quizList!![position].answerThird
            btnFourth!!.text = quizList!![position].answerFourth
        } else {
            // showFinishWindow()
            mPresenter!!.loadFinishWindow()
        }

        mPresenter!!.loadClickFirst()
        mPresenter!!.loadClickSecond()
        mPresenter!!.loadClickThird()
        mPresenter!!.loadClickFourth()
    }

    override fun activeProgressBar() {
        mainLayout!!.visibility = LinearLayout.GONE
        progressBar!!.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        mainLayout!!.visibility = LinearLayout.VISIBLE
        progressBar!!.visibility = ProgressBar.GONE
    }

    override fun clickFirstAnswer() {
        mPresenter!!.doButtonClickLogic(btnFirst!!, 1)
    }

    override fun clickSecondAnswer() {
        mPresenter!!.doButtonClickLogic(btnSecond!!, 2)
    }

    override fun clickThirdAnswer() {
        mPresenter!!.doButtonClickLogic(btnThird!!, 3)
    }

    override fun clickFourthAnswer() {
        mPresenter!!.doButtonClickLogic(btnFourth!!, 4)
    }

    override fun buttonClickLogic(button: Button, pos: Int) {
        button.setOnClickListener {
            if(position < quizList!!.size) {
                if(quizList!![position].rightAnswer == pos) {
                    points++
                    Toast.makeText(applicationContext, "Yes", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "No", Toast.LENGTH_SHORT).show()
                    incorrectlyAnsweredQuestions!!.add(QuizAnswersModel(
                        quizList!![position].question,
                        button.text.toString(),
                        rightAnswerText
                    ))
                }
                position++
                timer!!.cancel()
                startProgram()
            } else {
                // Do something...
            }
        }
    }

    override fun showFinishWindow() {
        mainLayout!!.visibility = LinearLayout.GONE
        finishLayout!!.visibility = LinearLayout.VISIBLE

        val tvPointsFinish: TextView = findViewById(R.id.tvPointsFinish)
        val tvResultCommentFinish: TextView = findViewById(R.id.tvResultCommentFinish)

        tvPointsFinish.text = "Your points ${points.toString()}"
        tvResultCommentFinish.text = if((points*100)/quizList!!.size >= 90) {
            "Wery good!!"
        } else if((points*100)/quizList!!.size >= 50 && (points*100)/quizList!!.size < 90) {
            "Normal!"
        } else {
            "Not good :("
        }

        mRecyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = QuizFinishAdapter(incorrectlyAnsweredQuestions!!)
        mRecyclerView.adapter = adapter
    }
}
