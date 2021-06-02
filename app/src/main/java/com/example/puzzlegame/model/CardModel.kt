package com.example.puzzlegame.model

data class CardModel(
    val id: Int,
    val imagePath: Int,
    val isImageSelected: Boolean = false,
    var isImagesMatched: Boolean = false,
    var isOpen: Boolean = false
    ) {

}
