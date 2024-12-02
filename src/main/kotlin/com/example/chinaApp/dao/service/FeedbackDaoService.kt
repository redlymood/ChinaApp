package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.FeedbackEntity
import com.example.chinaApp.dao.repository.FeedbackRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.UUID

@Service
@Slf4j
@RequiredArgsConstructor
class FeedbackDaoService (
    private val feedbackRepository: FeedbackRepository
) {

    fun findAll(): List<FeedbackEntity?> {
        return feedbackRepository.findAll()
    }

    fun save(feedbackEntity: FeedbackEntity) : FeedbackEntity {
        return feedbackRepository.save(feedbackEntity)
    }

    fun findByUserId(userId: UUID) : List<FeedbackEntity> {
        return feedbackRepository.findByUserId(userId)
    }

    fun findByLessonId(lessonId: UUID) : List<FeedbackEntity> {
        return feedbackRepository.findByLessonId(lessonId)
    }
}
