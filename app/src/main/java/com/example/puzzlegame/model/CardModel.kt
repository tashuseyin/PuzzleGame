package com.example.puzzlegame.model

data class CardModel(
    val id: Int,
    val imagePath: Int,
    var isImageSelected: Boolean = false,
    var  isImagesMatched: Boolean = false,
    var isOpen: Boolean = false
    ) {

}
