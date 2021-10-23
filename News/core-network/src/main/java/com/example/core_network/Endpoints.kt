package com.example.core_network

enum class Endpoints(val link: String) {
    Alpha("https://raw.githubusercontent.com/"),
    Beta(""),
    Production("")
}

class NewsApp {
    val NewsAppEndpoint = Endpoints.Alpha.link
}
