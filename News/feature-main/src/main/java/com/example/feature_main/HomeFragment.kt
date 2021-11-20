package com.example.feature_main

import android.content.Intent
import androidx.fragment.app.Fragment
import android.graphics.Point

import android.os.Bundle
import android.view.Display

import android.view.ViewGroup

import android.view.LayoutInflater
import android.view.View
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.all_news.NewsStruct
import com.example.feature_main.adapters.TwoColumnsAdapter
import com.example.core_architecture.CreateFragment
import com.example.core_architecture.QUIZ_TYPE_CODE
import com.example.core_architecture.navigation.Navigation
import com.example.core_network.quiz_questions.QuizResponse
import com.example.core_network.quiz_questions.QuizTypesStruct
import com.example.feature_main.adapters.QuizAdapter
import com.example.feature_main.fragments.DetailNewsFragment
import com.example.feature_quiz_questions.QuizQuestionsActivity


class HomeFragment(): Fragment(), HomePresenter.View {
    private var mPresenter: HomePresenter? = null
    private var mRepository: HomeRepository? = null
    private val mActivity = activity
    private val mContext = context
    private var progressBar: ProgressBar? = null
    private lateinit var mRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_home_fragment, container, false)
        // Inflate the layout for this fragment
        progressBar = view.findViewById(R.id.progress_bar) as ProgressBar
        mRecyclerView = view.findViewById(R.id.quiz_recycler) as RecyclerView

        startProgram()

        return view
    }

    companion object {
        fun newInstance() = HomeFragment()
    }

    private fun startProgram() {
        mPresenter = HomePresenter(this)
        mRepository = HomeRepository(mPresenter!!, requireContext())

//        mRepository!!.getHomeNews()
//        mRepository!!.getUnwantedNews()
        mRepository!!.getQuizRepository()
    }

    override fun showListOfNews(news: AllNewsResponse) {

    }

    override fun hideUnwantedContent(newsName: String) {

    }

    override fun showListOfQuiz(quiz: QuizResponse) {
//        val recyclerView: RecyclerView = (requireActivity() as HomeActivity).findViewById(R.id.all_news_recycler)
        mRecyclerView.layoutManager = GridLayoutManager(mContext, 2)

        val display: Display = (requireActivity() as HomeActivity).windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        println("Quiz types -> ${quiz.quizTypes}")

        val adapter = QuizAdapter(quiz.quizTypes!! as MutableList, object: QuizAdapter.Callback {
            override fun onItemClicked(item: QuizTypesStruct) {
                val mIntent = Intent(requireContext(), QuizQuestionsActivity::class.java)
                mIntent.putExtra(QUIZ_TYPE_CODE, item.typeCode)
                requireContext().startActivity(mIntent)
            }
        }, size)
        mRecyclerView.adapter = adapter
    }

    override fun activeProgressBar() {
        progressBar!!.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        progressBar!!.visibility = ProgressBar.GONE
    }
}