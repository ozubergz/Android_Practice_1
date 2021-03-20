package com.example.android_practice_1.data

import androidx.room.*
import com.example.android_practice_1.model.Word
import kotlinx.coroutines.flow.Flow

/* Dao must be either an interface or abstract */
@Dao
interface WordDao {
    @Query("SELECT * FROM  word_table ORDER BY word ASC")
    fun getAllWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteWord(word: Word)
}