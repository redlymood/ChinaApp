package com.example.chinaApp.dto

import java.util.*

data class Question(
    val id: UUID? = null,
    val questionRus: String? = null,
    val questionCh: String? = null,
    val lessons: List<Lesson>? = null,
    val answers: List<Answer>? = null
)
