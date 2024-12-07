package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.KnowledgeBaseEntity
import com.example.chinaApp.dao.repository.KnowledgeBaseRepository
import org.springframework.stereotype.Service

@Service
class KnowledgeBaseDaoService (
    private val knowledgeBaseRepository: KnowledgeBaseRepository
) {

    fun findAllCategories() : List<String> {
        return knowledgeBaseRepository.findAllCategories()
    }

    fun findAllSubcategoriesByCategory(category: String) : List<String> {
        return knowledgeBaseRepository.findAllSubcategoriesByCategory(category)
    }

    fun findByCategoryAndSubcategory(category: String, subcategory: String) : List<KnowledgeBaseEntity> {
        return knowledgeBaseRepository.findByCategoryAndSubcategory(category, subcategory)
    }
}
