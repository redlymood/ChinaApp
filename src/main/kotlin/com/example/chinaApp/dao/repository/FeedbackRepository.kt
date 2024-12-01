package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.FeedbackEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface FeedbackRepository : JpaRepository<FeedbackEntity?, UUID?> {

    fun findByUserId(userId: UUID) : List<FeedbackEntity>

    fun findByLessonId(lessonId: UUID) : List<FeedbackEntity>
}