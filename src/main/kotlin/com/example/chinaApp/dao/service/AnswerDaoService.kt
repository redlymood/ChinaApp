package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.AnswerEntity
import com.example.chinaApp.dao.repository.AnswerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AnswerDaoService (
    private val answerRepository: AnswerRepository
) {

    fun findAnswersByQuestionId(questionId: UUID): List<AnswerEntity> {
        return answerRepository.findByQuestionId(questionId)
    }
}
