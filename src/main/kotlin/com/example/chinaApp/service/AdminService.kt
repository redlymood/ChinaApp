package com.example.chinaApp.service

import com.example.chinaApp.dao.service.FeedbackDaoService
import com.example.chinaApp.dao.service.ProgressDaoService
import com.example.chinaApp.dao.service.UserDaoService
import com.example.chinaApp.dto.Feedback
import com.example.chinaApp.dto.User
import com.example.chinaApp.dto.UserInfo
import com.example.chinaApp.exceptions.UserNotFoundException
import com.example.chinaApp.util.ConverterService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class AdminService(private val feedbackDaoService: FeedbackDaoService,
                   private val userDaoService: UserDaoService,
                   private val progressDaoService: ProgressDaoService,
                   private val objectConverter: ConverterService
) {

    fun getFeedbackList(): List<Feedback> {
        val feedbackEntities = feedbackDaoService.findAll()
        return feedbackEntities.mapNotNull { feedbackEntity ->
            feedbackEntity?.let { objectConverter.convert(it)}}
    }

    fun getUserList(): List<User> {
        val userEntities = userDaoService.findAll()
        return userEntities.map { entity -> objectConverter.convert(entity) }
    }

    fun getUserInfo(userId: UUID): UserInfo {
        val user = userDaoService.findById(userId)
        if (user.isEmpty) {
            throw UserNotFoundException("Не удалось получить информацию о пользователе: пользователь не найден")
        }
        val userEntity = user.get()
        val progress = progressDaoService.getNumberOfLessonsCompleted(userId)
        return UserInfo(id = userEntity.id,
            email = userEntity.email,
            name = userEntity.name,
            password = userEntity.password,
            role = userEntity.role,
            progress = progress,
            feedbacks = userEntity.feedbacks?.map { feedbackEntity -> objectConverter.convert(feedbackEntity) }
            )
    }
}