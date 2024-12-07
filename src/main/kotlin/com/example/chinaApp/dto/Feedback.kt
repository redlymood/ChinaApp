package com.example.chinaApp.dto

import java.util.*

data class Feedback(
    val id: UUID? = null,
    val feedbackText: String? = null,
    val userId: UUID? = null,
    val lessonId: UUID? = null,
)
