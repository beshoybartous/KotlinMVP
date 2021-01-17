package com.example.kotlinmvp.cache.shared_pref

import android.content.Context
import android.content.SharedPreferences
import com.example.kotlinmvp.ApplicationClass

object SharedPrefManager {

    private const val SHARED_PREFERENCE_NAME = "app.sharedPref"
    private val sharedPreferences: SharedPreferences

    init {
        val context: Context = ApplicationClass.context()
        sharedPreferences = context.getSharedPreferences(
            SHARED_PREFERENCE_NAME,
            Context.MODE_PRIVATE
        )
    }

    fun setString(key: String, value: String) {
        val editor = sharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getString(key: String): String? {
        return getString(key, null)
    }

    fun getString(key: String, def: String?): String? {
        return sharedPreferences.getString(key, def)
    }

    fun setInteger(key: String, value: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    fun getInteger(key: String): Int {
        return sharedPreferences.getInt(key, -1)
    }

    fun getLong(key: String): Long {
        return sharedPreferences.getLong(key, -1)
    }

    fun setLong(key: String, value: Long) {
        val editor = sharedPreferences.edit()
        editor.putLong(key, value)
        editor.apply()
    }

    fun setBoolean(key: String, value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun getBoolean(key: String): Boolean {
        return getBoolean(key, false)
    }

    fun getBoolean(key: String, def: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, def)
    }

    fun setFloat(key: String, value: Float) {
        val editor = sharedPreferences.edit()
        editor.putFloat(key, value)
        editor.apply()
    }

    fun remove(key: String) {
        val editor = sharedPreferences.edit()
        editor.remove(key)
        editor.apply()
    }

    fun getFloat(key: String): Float {
        return sharedPreferences.getFloat(key, 0.0f)
    }

    fun clearAll() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}
