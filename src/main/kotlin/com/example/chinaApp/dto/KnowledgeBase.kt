package com.example.chinaApp.dto

import java.util.*

data class KnowledgeBase(
    val id: UUID? = null,
    val category: String? = null,
    val subcategory: String? = null,
    val content: String? = null
)
