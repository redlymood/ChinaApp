package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.ProgressEntity
import com.example.chinaApp.dao.repository.ProgressRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProgressDaoService (
    private val progressRepository: ProgressRepository
) {

    fun getNumberOfLessonsCompleted(userId: UUID?): Long {
        return progressRepository.getNumberOfLessonsCompleted(userId!!)
    }

    fun findByUserId(userId: UUID?): List<ProgressEntity> {
        return progressRepository.findByUserId(userId!!)
    }

    fun save(progressEntity: ProgressEntity): ProgressEntity {
        return progressRepository.save(progressEntity)
    }

    fun findByUserIdAndLessonId(userId: UUID, lessonId: UUID): Optional<ProgressEntity> {
        return progressRepository.findByUserIdAndLessonId(userId, lessonId)
    }
}
