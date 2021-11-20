package com.example.feature_main.adapters

import android.graphics.Point
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.core_architecture.CreatePreferences
import com.example.core_architecture.UNWANTED_NEWS
import com.example.core_network.all_news.NewsStruct
import com.example.feature_main.R
import com.squareup.picasso.Picasso

class TwoColumnsAdapter(var items: MutableList<NewsStruct>, val callback: Callback, size: Point)
    : RecyclerView.Adapter<TwoColumnsAdapter.MainHolder>() {

    private val mSize = size

    inner class MainHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val allNewsTitle = itemView.findViewById<TextView>(R.id.all_news_title)
        private val allNewsImage = itemView.findViewById<ImageView>(R.id.all_news_image)
        private val allNewsLayout = itemView.findViewById<LinearLayout>(R.id.all_news_layout)
        private val getPrefs = CreatePreferences(itemView.context).getPreferencesData<String>(UNWANTED_NEWS) as String
        private val strs = getPrefs.split(",").toTypedArray()

        fun bind(item: NewsStruct) {
            val params = allNewsLayout.layoutParams
            params.height = ((mSize.x) / 2) - 5
            params.width = ((mSize.x) / 2) - 5

            allNewsTitle.text = item.newsTitle
            Picasso.get()
                .load(item.newsImage)
                .resize((mSize.x)/2, (mSize.x)/2)
                .into(allNewsImage)

            itemView.setOnClickListener {
                if (adapterPosition != RecyclerView.NO_POSITION) callback.onItemClicked(items[adapterPosition])
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