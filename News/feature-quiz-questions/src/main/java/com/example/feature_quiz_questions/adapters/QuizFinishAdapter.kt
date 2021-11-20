package com.example.feature_quiz_questions.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_quiz_questions.R
import com.example.feature_quiz_questions.model.QuizAnswersModel

class QuizFinishAdapter(var items: MutableList<QuizAnswersModel>)
    : RecyclerView.Adapter<QuizFinishAdapter.MainHolder>() {

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val quizLayout = itemView.findViewById<LinearLayout>(R.id.quiz_finish_layout)
        private val quizFinishQuestion = itemView.findViewById<TextView>(R.id.quiz_question)
        private val quizFinishMyAnswer = itemView.findViewById<TextView>(R.id.my_answer)
        private val quizFinishRightAnswer = itemView.findViewById<TextView>(R.id.right_answer)

        fun bind(item: QuizAnswersModel) {
            //
            quizFinishQuestion.text = "Question: ${item.question}"
            quizFinishMyAnswer.text = "Your answer: ${item.yourAnswer}"
            quizFinishRightAnswer.text = "Right answer: ${item.rightAnswer}"

//            itemView.setOnClickListener {
//                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_quiz_finish, parent, false))

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    interface Callback {
        fun onItemClicked(item: QuizAnswersModel)
    }
}
