package com.example.android_practice_1.repo

import com.example.android_practice_1.data.WordDao
import com.example.android_practice_1.model.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {

    val allWords: Flow<List<Word>> = wordDao.getAllWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}