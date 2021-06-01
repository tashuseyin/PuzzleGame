package com.example.puzzlegame.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.puzzlegame.databinding.RowItemBinding
import com.example.puzzlegame.model.CardModel

class PuzzleGameAdapter(
    private val onItemClickListener: (Int) -> Unit
) :
    ListAdapter<CardModel, PuzzleGameViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PuzzleGameViewHolder {
        val binding = RowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PuzzleGameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PuzzleGameViewHolder, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }


    class DiffCallback : DiffUtil.ItemCallback<CardModel>() {
        override fun areItemsTheSame(oldItem: CardModel, newItem: CardModel): Boolean {
            return oldItem.isOpen == newItem.isOpen
        }

        override fun areContentsTheSame(oldItem: CardModel, newItem: CardModel): Boolean {
            return oldItem == newItem
        }
    }
}