package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.LessonEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface LessonRepository : JpaRepository<LessonEntity?, UUID?>
