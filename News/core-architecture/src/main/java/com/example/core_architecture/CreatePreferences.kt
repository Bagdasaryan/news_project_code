package com.example.core_architecture

import android.content.Context
import android.content.SharedPreferences

class CreatePreferences(context: Context) {
    var mTestPreference: SharedPreferences =
        context.getSharedPreferences(TEST_KEY, Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor? =
        mTestPreference.edit()

    fun putPreferencesData(mData: Any, key: String) {
        when(mData) {
            is Int -> {
                editor!!.putInt(key, mData)
                editor!!.commit()
            }

            is String -> {
                editor!!.putString(key, mData)
                editor!!.commit()
            }
        }
    }

    inline fun <reified T> getPreferencesData(key: String): Any {
        when (T::class) {
            Int::class -> {
                // Int
                return mTestPreference.getInt(key, -1)
            }
            String::class -> {
                // String
                return mTestPreference.getString(key, "")!!
            }
        }

        return -1
    }
}