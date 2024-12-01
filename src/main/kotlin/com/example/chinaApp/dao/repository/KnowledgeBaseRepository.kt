package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.KnowledgeBaseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface KnowledgeBaseRepository : JpaRepository<KnowledgeBaseEntity?, UUID?> {

    @Query("SELECT DISTINCT k.category FROM KnowledgeBaseEntity k")
    fun findAllCategories() : List<String>

    @Query("SELECT DISTINCT k.subcategory FROM KnowledgeBaseEntity k WHERE k.category = :category")
    fun findAllSubcategoriesByCategory(@Param("category") category: String) : List<String>

    fun findByCategoryAndSubcategory(category: String, subcategory: String): List<KnowledgeBaseEntity>
}
