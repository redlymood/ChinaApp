package com.example.chinaApp.dto

import java.util.*

data class Feedback(
    val id: UUID? = null,
    val feedbackText: String? = null,
    val user: User? = null,
    val lesson: Lesson? = null,
)
