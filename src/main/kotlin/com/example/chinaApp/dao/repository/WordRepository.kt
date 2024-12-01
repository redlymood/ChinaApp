package com.example.chinaApp.dao.repository

import com.example.chinaApp.dao.entity.WordEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.util.*

interface WordRepository : JpaRepository<WordEntity?, UUID?> {

    @Query("""SELECT * FROM word
                ORDER BY RANDOM()
                LIMIT 1""")
    fun findRandomWord() : WordEntity
}
