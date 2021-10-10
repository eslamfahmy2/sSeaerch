package com.fahmy.data.dto.news

import com.google.gson.annotations.SerializedName

data class ResponseDto(

    @SerializedName("articles")
    val articles: List<ArticleDto>,

    @SerializedName("status")
    val status: String,

    @SerializedName("totalResults")
    val totalResults: Int,
)