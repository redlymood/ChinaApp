package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.QuestionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface QuestionRepository : JpaRepository<QuestionEntity?, UUID?> {

    @Query("""SELECT * FROM question
                ORDER BY RANDOM()
                LIMIT 1""")
    fun findRandomQuestion() : QuestionEntity
}
