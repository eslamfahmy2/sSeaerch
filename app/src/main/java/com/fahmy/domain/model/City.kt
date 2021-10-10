package com.fahmy.domain.model

data class City(
    val name: String,
    val image: String? = "https://www.example.com/image.jpg",
    val description: String? = "description",
)