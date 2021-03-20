package com.example.android_practice_1.view

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.android_practice_1.R
import com.example.android_practice_1.databinding.ActivityAddBinding
import com.example.android_practice_1.model.Word
import com.example.android_practice_1.viewmodel.WordViewModel

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private val viewModel by viewModels<WordViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val word = binding.etInput.text.toString()
            val newWord = Word(word)
            viewModel.insert(newWord)
        }

    }
}