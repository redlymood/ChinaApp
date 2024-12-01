package com.example.chinaApp.dto

import java.util.*

data class CreateFeedbackRequest(
    val lessonId: UUID? = null,
    val feedbackText: String? = null
)
