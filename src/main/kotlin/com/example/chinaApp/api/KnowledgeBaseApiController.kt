package com.example.chinaApp.api

import com.example.chinaApp.dto.KnowledgeBase
import com.example.chinaApp.service.KnowledgeBaseService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class KnowledgeBaseApiController {
    private val knowledgeBaseService: KnowledgeBaseService? = null

    @GetMapping("/knowledge/categories")
    fun allCategories() : List<String> {
        return knowledgeBaseService!!.allCategories
    }

    @GetMapping("/knowledge/{category}/subcategories")
    fun getAllSubcategoriesByCategory(@PathVariable category: String): List<String> {
        return knowledgeBaseService!!.getAllSubcategoriesByCategory(category)
    }

    @GetMapping("/knowledge/{category}/{subcategory}")
    fun getAllByCategoryAndSubcategory(@PathVariable category: String, @PathVariable subcategory: String): List<KnowledgeBase> {
        return knowledgeBaseService!!.getAllByCategoryAndSubcategory(category, subcategory)
    }
}
