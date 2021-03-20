package com.example.android_practice_1.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_practice_1.R
import com.example.android_practice_1.adapter.WordAdapter
import com.example.android_practice_1.databinding.ActivityMainBinding
import com.example.android_practice_1.model.Word
import com.example.android_practice_1.viewmodel.WordViewModel

interface ClickListener {
    fun wordClicked(word: Word)
}


class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<WordViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabAdd.setOnClickListener {
            val action = Intent(this, AddActivity::class.java)
            startActivity(action)
        }

        viewModel.readData.observeForever {
            binding.rvWord.adapter = WordAdapter(it, this)
        }

        binding.rvWord.layoutManager = LinearLayoutManager(this)
    }

    override fun wordClicked(word: Word) {
        viewModel.delete(word)
    }
}