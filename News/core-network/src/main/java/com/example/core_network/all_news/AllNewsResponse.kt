package com.example.core_network.all_news

import com.google.gson.annotations.SerializedName

class AllNewsResponse {
    @SerializedName("AllNews")
    var allNews: List<NewsStruct>? = listOf()
}

class NewsStruct {
    @SerializedName("NewsName")
    var newsName: String? = ""

    @SerializedName("NewsTitle")
    var newsTitle: String? = ""

    @SerializedName("NewsDescription")
    var newsDescription: String? = ""

    @SerializedName("NewsImage")
    var newsImage: String? = ""
}
