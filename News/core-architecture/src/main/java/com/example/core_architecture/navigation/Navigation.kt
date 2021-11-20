package com.example.core_architecture.navigation

import android.content.Context
import android.content.Intent

class Navigation(context: Context) {
    val mContext = context

    inline fun <reified B>navigateToActivity() {
        mContext.startActivity(Intent(mContext, B::class.java))
    }
}