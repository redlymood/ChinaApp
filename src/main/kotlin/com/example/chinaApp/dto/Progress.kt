package com.example.chinaApp.dto

import java.util.*

data class Progress(
    val id: UUID? = null,
    val status: String? = null,
    val userId: UUID? = null,
    val lessonId: UUID? = null
)
