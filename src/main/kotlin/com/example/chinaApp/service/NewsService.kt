package com.example.chinaApp.service

import com.example.chinaApp.dao.entity.QuestionEntity
import com.example.chinaApp.dao.entity.WordEntity
import com.example.chinaApp.dao.service.QuestionDaoService
import com.example.chinaApp.dao.service.WordDaoService
import com.example.chinaApp.dto.Question
import com.example.chinaApp.dto.Word
import com.example.chinaApp.util.ConverterService
import org.springframework.stereotype.Service

@Service
class NewsService (private val objectConverter: ConverterService,
                   private val wordDaoService: WordDaoService,
                   private val questionDaoService: QuestionDaoService
    ) {

    fun getDailyWord(): Word {
        val wordEntity: WordEntity = wordDaoService.findRandomWord()
        return objectConverter.convert(wordEntity)
    }

    fun getDailyQuestion(): Question {
        val questionEntity: QuestionEntity = questionDaoService.findRandomQuestion()
        return objectConverter.convert(questionEntity)
    }
}