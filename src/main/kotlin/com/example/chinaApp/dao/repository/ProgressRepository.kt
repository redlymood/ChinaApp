package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.ProgressEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.*

interface ProgressRepository : JpaRepository<ProgressEntity?, UUID?> {

    @Query(nativeQuery = true, value = """
        select count(*)
        from progress as p inner join lesson as l on p.lesson_id = l.id
        where p.user_id = :user_id and p.status = 'completed'
    """)
    fun getNumberOfLessonsCompleted(@Param("user_id") userId: UUID): Long

    fun findByUserId(userId: UUID): List<ProgressEntity>

    fun findByUserIdAndLessonId(userId: UUID, lessonId: UUID): Optional<ProgressEntity>
}


