package com.example.chinaApp.service

import com.example.chinaApp.dao.entity.QuestionEntity
import com.example.chinaApp.dao.entity.WordEntity
import com.example.chinaApp.dao.service.QuestionDaoService
import com.example.chinaApp.dao.service.WordDaoService
import com.example.chinaApp.dto.Question
import com.example.chinaApp.dto.Word
import com.example.chinaApp.util.ObjectConverter

class NewsService (private val objectConverter: ObjectConverter) {

    private val wordDaoService: WordDaoService? = null
    private val questionDaoService: QuestionDaoService? = null

    fun getDailyWord(): Word {
        val wordEntity: WordEntity = wordDaoService!!.findRandomWord()
        return objectConverter.run { wordEntity.toDTO() }
    }

    fun getDailyQuestion(): Question {
        val questionEntity: QuestionEntity = questionDaoService!!.findRandomQuestion()
        return objectConverter.run { questionEntity.toDTO() }
    }
}