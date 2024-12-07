package com.example.chinaApp.api

import com.example.chinaApp.dto.KnowledgeBase
import com.example.chinaApp.service.KnowledgeBaseService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class KnowledgeBaseApiController (
    private val knowledgeBaseService: KnowledgeBaseService
) {

    @GetMapping("/knowledge/categories")
    fun allCategories() : ResponseEntity<List<String>> {
        return ResponseEntity.ok().body(knowledgeBaseService.allCategories())
    }

    @GetMapping("/knowledge/{category}/subcategories")
    fun getAllSubcategoriesByCategory(@PathVariable category: String): ResponseEntity<List<String>> {
        return ResponseEntity.ok().body(knowledgeBaseService.getAllSubcategoriesByCategory(category))
    }

    @GetMapping("/knowledge/{category}/{subcategory}")
    fun getAllByCategoryAndSubcategory(@PathVariable category: String, @PathVariable subcategory: String): ResponseEntity<List<KnowledgeBase>> {
        return ResponseEntity.ok().body(knowledgeBaseService.getAllByCategoryAndSubcategory(category, subcategory))
    }
}
