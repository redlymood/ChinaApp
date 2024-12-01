package com.example.chinaApp.service

import com.example.chinaApp.dao.service.FeedbackDaoService
import com.example.chinaApp.dao.service.UserDaoService
import com.example.chinaApp.dto.Feedback
import com.example.chinaApp.dto.User
import com.example.chinaApp.util.ObjectConverter
import org.springframework.stereotype.Service

@Service
class AdminService(private val feedbackDaoService: FeedbackDaoService,
                   private val userDaoService: UserDaoService,
                   private val objectConverter: ObjectConverter
) {

    fun getFeedbackList(): List<Feedback> {
        val feedbackEntities = feedbackDaoService!!.findAll()
        return feedbackEntities.map { entity -> objectConverter.run { entity!!.toDTO() } }
    }

    fun getUserList(): List<User> {
        val userEntities = userDaoService!!.findAll()
        return userEntities.map {entity -> objectConverter.run { entity.toDTO() }}
    }
}