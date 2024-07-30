package com.devrodrigomoreira.motivation

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivantion", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    fun getKey(key: String): String {
        return security.getString(key, "") ?: ""
    }
}