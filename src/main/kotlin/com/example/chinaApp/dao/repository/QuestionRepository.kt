package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface QuestionRepository : JpaRepository<QuestionEntity?, UUID?> {

    @Query(nativeQuery = true, value = """SELECT * FROM question
                ORDER BY RANDOM()
                LIMIT 1""")
    fun findRandomQuestion() : QuestionEntity

    @Query(nativeQuery = true, value = """select question.* from question q
        |inner join lesson_question lq on q.id = lq.question_id
        |where lq.lesson_id = :lessonId""")
    fun findByLessonId(lessonId: UUID): List<QuestionEntity>
}
