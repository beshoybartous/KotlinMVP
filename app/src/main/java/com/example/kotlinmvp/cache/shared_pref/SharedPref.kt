package com.example.kotlinmvp.cache.shared_pref

object SharedPref {
    private const val KEY_NOTIFICATION_TOKEN = "notification_token"

    fun getNotificationToken(): String? {
        return SharedPrefManager.getString(KEY_NOTIFICATION_TOKEN)
    }

    fun setNotificationToken(token: String) {
        SharedPrefManager.setString(
            KEY_NOTIFICATION_TOKEN, token
        )
    }
}