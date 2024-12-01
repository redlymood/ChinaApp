package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.AnswerEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface AnswerRepository : JpaRepository<AnswerEntity?, UUID?>
