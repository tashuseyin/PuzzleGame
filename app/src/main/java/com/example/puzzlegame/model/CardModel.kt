package com.example.puzzlegame.model

data class CardModel(
    val id: Int,
    val imagePath: Int,
    val isImageSelected: Boolean = false,
    val  isImagesMatched: Boolean = false,
    val isOpen: Boolean = false
    ) {

}
