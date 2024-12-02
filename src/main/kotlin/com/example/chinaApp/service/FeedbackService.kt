package com.example.chinaApp.service

import com.example.chinaApp.dao.entity.FeedbackEntity
import com.example.chinaApp.dao.service.FeedbackDaoService
import com.example.chinaApp.dao.service.LessonDaoService
import com.example.chinaApp.dao.service.UserDaoService
import com.example.chinaApp.dto.Feedback
import com.example.chinaApp.exceptions.LessonNotFoundException
import com.example.chinaApp.exceptions.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class FeedbackService (private val feedbackDaoService: FeedbackDaoService,
    private val userDaoService: UserDaoService,
    private val lessonDaoService: LessonDaoService
) {

    fun addFeedback(feedback: Feedback) {
        val user = feedback.userId?.let { userDaoService.findById(it) }
        val lesson = feedback.lessonId?.let { lessonDaoService.findById(it) }

        if (lesson?.isEmpty != false) {
            throw LessonNotFoundException("Не удалось оставить отзыв: урок не найден")
        }
        if (user?.isEmpty != false) {
            throw UserNotFoundException("Не удалось оставить отзыв: пользоватль не найден")
        }

        val feedbackEntity = FeedbackEntity(
            feedbackText = feedback.feedbackText,
            user = user.get(),
            lesson = lesson.get()
        )
        feedbackDaoService.save(feedbackEntity)

    }
}