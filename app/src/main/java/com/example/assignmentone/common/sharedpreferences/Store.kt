package com.example.assignmentone.common.sharedpreferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.map
import java.util.concurrent.Flow

class Store(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("Store")
        val BOTTOM_BAR_CLICKABLE = booleanPreferencesKey("bottom_bar_clikable")
        val ICON_COLOR_CHANGE = intPreferencesKey("icon_color_change")

    }

    // to get the email
    val getBottomBarStatus: kotlinx.coroutines.flow.Flow<Boolean?> = context.dataStore.data
        .map { preferences ->
            preferences[BOTTOM_BAR_CLICKABLE] ?: false
        }
    val getIconColorStatus: kotlinx.coroutines.flow.Flow<Int?> = context.dataStore.data
        .map { preferences ->
            preferences[ICON_COLOR_CHANGE] ?: com.example.assignmentone.R.id.sportsFragment
        }

    // to save the email
    suspend fun saveBottomBarStatus(name: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[BOTTOM_BAR_CLICKABLE] = name
        }
    }
    suspend fun saveIconColorStatus(id: Int) {
        context.dataStore.edit { preferences ->
            preferences[ICON_COLOR_CHANGE] = id
        }
    }
}