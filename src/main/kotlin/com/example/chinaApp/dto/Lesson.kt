package com.example.chinaApp.dto

import java.util.*

data class Lesson(
    val id: UUID? = null,
    val lessonNumber: String? = null,
    val nameRus: String? = null,
    val nameCh: String? = null,
    val threshold: Int? = null,
    val description: String? = null,
    val feedbacks: List<Feedback>? = null,
    val questions: List<Question>? = null
)
