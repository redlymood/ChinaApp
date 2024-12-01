package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.QuestionEntity
import com.example.chinaApp.dao.repository.QuestionRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
@RequiredArgsConstructor
class QuestionDaoService {
    private val questionRepository: QuestionRepository? = null

    fun findRandomQuestion(): QuestionEntity {
        return questionRepository!!.findRandomQuestion()
    }
}
