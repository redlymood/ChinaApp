package com.example.chinaApp.dto

import java.util.*

data class User(
    val id: UUID? = null,
    val email: String? = null,
    val name: String? = null,
    val password: String? = null,
    val role: String? = null,
)
