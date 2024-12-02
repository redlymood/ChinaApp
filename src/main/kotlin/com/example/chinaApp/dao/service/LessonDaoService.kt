package com.example.chinaApp.dao.service

import com.example.chinaApp.dao.entity.LessonEntity
import com.example.chinaApp.dao.repository.LessonRepository
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Service
import java.util.*

@Service
@Slf4j
@RequiredArgsConstructor
class LessonDaoService(
    private val lessonRepository: LessonRepository
) {

    fun findById(id: UUID?): Optional<LessonEntity?> {
        return lessonRepository.findById(id!!)
    }

    fun findAll(): List<LessonEntity> {
        return lessonRepository.findAll()
    }
}
