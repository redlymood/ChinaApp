package com.example.chinaApp.service

import com.example.chinaApp.dao.service.FeedbackDaoService
import com.example.chinaApp.dto.CreateFeedbackRequest


class FeedbackService (private val feedbackDaoService: FeedbackDaoService,
    private val systemUserService: SystemUserService) {

    fun addFeedback(createFeedbackRequest: CreateFeedbackRequest) {
        val user = systemUserService.getCurrentUser()

    }
}