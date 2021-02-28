package com.example.android_practice_1.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.android_practice_1.data.WordRoomDB
import com.example.android_practice_1.model.Word
import com.example.android_practice_1.repo.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repo: WordRepository

    init {
        val wordDao = WordRoomDB.getDataBase(application).wordDao()
        repo = WordRepository(wordDao)
    }

    val words = repo.allWords.asLiveData(viewModelScope.coroutineContext)

    fun insert(word: Word) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.insert(word)
        }
    }
}