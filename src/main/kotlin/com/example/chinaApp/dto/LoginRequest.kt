package com.example.chinaApp.dto

import org.jetbrains.annotations.NotNull

data class LoginRequest(
    @field:NotNull("email")
    val email: String,
    @field:NotNull("password")
    val password: String
)