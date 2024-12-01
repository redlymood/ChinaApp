package com.example.chinaApp.dto

data class Question(
    val id: Long? = null,
    val questionRus: String? = null,
    val questionCh: String? = null,
    val lessons: List<Lesson>? = null,
    val answers: List<Answer>? = null
)
