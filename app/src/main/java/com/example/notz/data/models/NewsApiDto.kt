package com.example.notz.data.models

data class NewsApiDto (
    val status: String?,
    val totalResults: Int?,
    val articles: List<ArticleApiDto>
)

data class ArticleApiDto(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
)