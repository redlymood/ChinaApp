package com.example.chinaApp.service

import com.example.chinaApp.dao.service.KnowledgeBaseDaoService
import com.example.chinaApp.dto.KnowledgeBase
import org.springframework.stereotype.Service

@Service
class KnowledgeBaseService (private val objectConverter: ConverterService,
                            private val knowledgeBaseDaoService: KnowledgeBaseDaoService
) {

    fun allCategories(): List<String> {
        return knowledgeBaseDaoService.findAllCategories()
    }

    fun getAllSubcategoriesByCategory(category: String): List<String> {
        return knowledgeBaseDaoService.findAllSubcategoriesByCategory(category)
    }

    fun getAllByCategoryAndSubcategory(category: String, subcategory: String) : List<KnowledgeBase> {
        val entities = knowledgeBaseDaoService
            .findByCategoryAndSubcategory(category, subcategory)
        return entities.map { entity -> objectConverter.convert(entity) }
    }
}
