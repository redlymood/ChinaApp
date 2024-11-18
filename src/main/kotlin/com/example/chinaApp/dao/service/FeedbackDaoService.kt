package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.FeedbackEntity
import com.example.chinaApp.dao.repository.FeedbackRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service

@Service
@Slf4j
@RequiredArgsConstructor
class FeedbackDaoService {
    private val feedbackRepository: FeedbackRepository? = null

    fun findAll(): List<FeedbackEntity?> {
//        return feedbackRepository!!.getAll()
        return emptyList()
    }
}
