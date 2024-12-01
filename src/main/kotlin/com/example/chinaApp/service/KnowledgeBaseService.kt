package com.example.chinaApp.service

import com.example.chinaApp.dao.service.KnowledgeBaseDaoService
import com.example.chinaApp.dto.KnowledgeBase
import com.example.chinaApp.util.ObjectConverter
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
class KnowledgeBaseService (private val objectConverter: ObjectConverter) {
    private val knowledgeBaseDaoService: KnowledgeBaseDaoService? = null

    fun allCategories(): List<String> {
        return knowledgeBaseDaoService!!.findAllCategories()
    }

    fun getAllSubcategoriesByCategory(category: String): List<String> {
        return knowledgeBaseDaoService!!.findAllSubcategoriesByCategory(category)
    }

    fun getAllByCategoryAndSubcategory(category: String, subcategory: String) : List<KnowledgeBase> {
        val entities = knowledgeBaseDaoService!!
            .findByCategoryAndSubcategory(category, subcategory)
        return entities.map { entity -> objectConverter.run { entity.toDTO() } }
    }
}
