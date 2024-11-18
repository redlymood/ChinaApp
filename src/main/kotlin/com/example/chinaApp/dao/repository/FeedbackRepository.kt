package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.FeedbackEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedbackRepository : JpaRepository<FeedbackEntity, UUID?>{
//    fun getAllBy
}
