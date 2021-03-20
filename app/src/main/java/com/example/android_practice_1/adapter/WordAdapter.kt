package com.example.android_practice_1.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_practice_1.databinding.RecyclerviewItemBinding
import com.example.android_practice_1.model.Word
import com.example.android_practice_1.view.ClickListener

class WordAdapter(private val words : List<Word>, private val clickListener: ClickListener) : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

    class WordViewHolder(private val binding: RecyclerviewItemBinding, private val clickListener: ClickListener) : RecyclerView.ViewHolder(binding.root) {
            fun bind(word: Word) {
                binding.textView.text = word.word
                binding.btnDelete.setOnClickListener{
                    clickListener.wordClicked(word)
                }
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(view, clickListener)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(words[position])
    }

    override fun getItemCount(): Int {
        return words.size
    }
}