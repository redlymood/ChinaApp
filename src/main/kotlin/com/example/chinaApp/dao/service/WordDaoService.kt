package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.WordEntity
import com.example.chinaApp.dao.repository.WordRepository
import org.springframework.stereotype.Service

@Service
class WordDaoService (
    private val wordRepository: WordRepository
) {

    fun findRandomWord() : WordEntity {
        return wordRepository.findRandomWord()
    }
}
