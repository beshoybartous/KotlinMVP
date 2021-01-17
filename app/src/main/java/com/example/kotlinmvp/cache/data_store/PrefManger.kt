package com.example.kotlinmvp.cache.data_store

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.createDataStore
import com.example.kotlinmvp.ApplicationClass
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.IOException

object PrefManger {

    private val dataStore: DataStore<Preferences> =
        ApplicationClass.context().createDataStore(
            name = "settings"
        )


    private suspend fun update(
        key: Preferences.Key<String>,
        value: String
    ) {
        dataStore.addToLocalStorage {
            this[key] = value
        }
    }

    private suspend fun DataStore<Preferences>.addToLocalStorage(mutableFunc: MutablePreferences.() -> Unit) {
        edit {
            mutableFunc(it)
        }
    }

    private suspend inline fun <reified T> DataStore<Preferences>.getFromLocalStorage(
        PreferencesKey: Preferences.Key<T>, crossinline func: T.() -> Unit
    ) {
        data.catch {
            if (it is IOException) {
                emit(emptyPreferences())
            } else {
                throw it
            }
        }.map {
            it[PreferencesKey]
        }.collect {
            it?.let {
                func.invoke(it)
            }
        }
    }

    suspend fun get(key: Preferences.Key<String>) {
        dataStore.getFromLocalStorage(key) {
        }
    }

}