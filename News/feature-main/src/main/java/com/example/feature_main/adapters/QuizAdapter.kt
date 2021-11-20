package com.example.feature_main.adapters

import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core_network.quiz_questions.QuizTypesStruct
import com.example.feature_main.R
import com.squareup.picasso.Picasso

class QuizAdapter(var items: MutableList<QuizTypesStruct>, val callback: Callback, size: Point)
    : RecyclerView.Adapter<QuizAdapter.MainHolder>() {

    private val mSize = size

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val quizLayout = itemView.findViewById<LinearLayout>(R.id.quiz_layout)
        private val quizTitle = itemView.findViewById<TextView>(R.id.quiz_title)
        private val quizImage = itemView.findViewById<ImageView>(R.id.quiz_image)

        fun bind(item: QuizTypesStruct) {
            val params = quizLayout.layoutParams
            params.height = ((mSize.x) / 2) - 10
            params.width = ((mSize.x) / 2) - 10

            quizTitle.text = item.typeName
            Picasso.get()
                .load(item.typeImage)
                .resize((mSize.x)/2, (mSize.x)/2)
                .into(quizImage)

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_quiz, parent, false))

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    interface Callback {
        fun onItemClicked(item: QuizTypesStruct)
    }
}
