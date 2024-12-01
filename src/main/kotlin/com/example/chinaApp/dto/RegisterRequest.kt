package com.example.chinaApp.dto

import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable
import java.util.UUID

data class RegisterRequest(
    @field:Nullable
    val id: UUID?,
    @field:NotNull
    val email: String,
    @field:NotNull
    val password: String,
    @field:NotNull
    val name: String,
    @field:NotNull
    val role: String
)
