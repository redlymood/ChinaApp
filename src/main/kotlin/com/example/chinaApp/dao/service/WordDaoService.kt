package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.WordEntity
import com.example.chinaApp.dao.repository.WordRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
@RequiredArgsConstructor
class WordDaoService (
    private val wordRepository: WordRepository
) {

    fun findRandomWord() : WordEntity {
        return wordRepository.findRandomWord()
    }
}
