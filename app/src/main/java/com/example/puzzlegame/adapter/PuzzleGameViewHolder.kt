package com.example.puzzlegame.adapter


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.puzzlegame.R
import com.example.puzzlegame.databinding.RowItemBinding
import com.example.puzzlegame.model.CardModel

class PuzzleGameViewHolder(private val binding: RowItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: CardModel, onItemClickListener: (Int) -> Unit) {

        if (item.isOpen) {
            binding.imageItem.setImageResource(item.imagePath)
            binding.root.isEnabled = false
        } else {
            binding.imageItem.setImageResource(R.drawable.image_background)
            binding.root.isEnabled = true
        }

        binding.root.setOnClickListener {
            if (RecyclerView.NO_POSITION != adapterPosition)
                onItemClickListener(adapterPosition)


        }
    }



}


