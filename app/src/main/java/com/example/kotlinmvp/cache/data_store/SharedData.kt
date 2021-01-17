package com.example.kotlinmvp.cache.data_store

import androidx.datastore.preferences.core.preferencesKey

class SharedData {
    object PreferenceKeys {
        val USER_NAME = preferencesKey<String>("user_name")
        val USER_ID = preferencesKey<Int>("user_id")
    }
}