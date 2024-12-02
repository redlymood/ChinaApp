package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.QuestionEntity
import com.example.chinaApp.dao.repository.QuestionRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.UUID

@Service
@Slf4j
@RequiredArgsConstructor
class QuestionDaoService (
    private val questionRepository: QuestionRepository
) {

    fun findRandomQuestion(): QuestionEntity {
        return questionRepository.findRandomQuestion()
    }

    fun findByLessonId(lessonId: UUID): List<QuestionEntity> {
        return questionRepository.findByLessonId(lessonId)
    }
}
