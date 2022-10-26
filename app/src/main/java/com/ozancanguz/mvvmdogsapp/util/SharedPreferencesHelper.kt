package com.ozancanguz.mvvmdogsapp.util

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.core.content.edit

class SharedPreferencesHelper {
    companion object {
        private var prefs: SharedPreferences? = null
        @Volatile
        private var instance: SharedPreferencesHelper? = null
        private var LOCK = Any()

        operator fun invoke(context: Context): SharedPreferencesHelper =
            instance ?: synchronized(LOCK) {
                instance ?: buildHelper(context).also {
                    instance = it
                }
            }

        private fun buildHelper(context: Context): SharedPreferencesHelper {
            prefs = PreferenceManager.getDefaultSharedPreferences(context)
            return SharedPreferencesHelper()
        }

        private const val PREF_TIME = "Pref time"
    }
    fun saveUpdateTime(time: Long) {
        prefs?.edit(commit = true) {putLong(Companion.PREF_TIME, time)}
    }

    fun getUpdateTime() = prefs?.getLong(Companion.PREF_TIME, 0)

    fun getCacheDuration() = prefs?.getString("pref_cache_duration", "")
}


