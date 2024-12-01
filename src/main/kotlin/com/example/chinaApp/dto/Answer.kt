package com.example.chinaApp.dto

import java.util.*

data class Answer(
    val id: UUID? = null,
    val answerText: String? = null,
    val isCorrect: Boolean? = null,
    val users: List<User>? = null,
    val question: Question? = null
)
