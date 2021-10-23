package com.example.feature_main.recycler_two_columns

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.core_network.all_news.AllNewsResponse
import com.example.core_network.all_news.NewsStruct
import com.example.feature_main.R
import com.squareup.picasso.Picasso

class TwoColumnsAdapter(var items: List<NewsStruct>, val callback: Callback): RecyclerView.Adapter<TwoColumnsAdapter.MainHolder>() {
    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val allNewsTitle = itemView.findViewById<TextView>(R.id.all_news_title)
        private val allNewsImage = itemView.findViewById<ImageView>(R.id.all_news_image)

        fun bind(item: NewsStruct) {
            allNewsTitle.text = item.newsTitle
            Picasso.get()
                .load(item.newsImage)
//                .resize(50, 50)
                .into(allNewsImage)

            itemView.setOnClickListener {
                // Do nothing
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.two_column_recycler, parent, false))

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    interface Callback {
        fun onItemClicked(item: NewsStruct)
    }
}