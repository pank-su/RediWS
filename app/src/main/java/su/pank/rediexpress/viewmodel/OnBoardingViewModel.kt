package su.pank.rediexpress.viewmodel

import android.content.Context
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class OnBoardingViewModel(context: Context) : ViewModel() {

    var isSeen by mutableStateOf(false)

    init {

        viewModelScope.launch {
            context.dataStore.data.map { preferences ->
                preferences[booleanPreferencesKey("isSeen")] ?: false
            }.collect {
                isSeen = it
            }
        }
    }

    fun isSeenEd(context: Context){
        CoroutineScope(Dispatchers.IO).launch {
            context.dataStore.edit {
                it[booleanPreferencesKey("isSeen")] = true
            }
        }
        isSeen = true
    }
}