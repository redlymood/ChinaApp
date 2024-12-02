package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.AnswerEntity
import com.example.chinaApp.dao.repository.AnswerRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
@RequiredArgsConstructor
class AnswerDaoService (
    private val answerRepository: AnswerRepository
) {

    fun findAnswersByQuestionId(questionId: UUID): List<AnswerEntity> {
        return answerRepository.findByQuestionId(questionId)
    }
}
