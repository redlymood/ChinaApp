package com.example.chinaApp.api

import com.example.chinaApp.dto.Question
import com.example.chinaApp.dto.Word
import com.example.chinaApp.service.NewsService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class NewsApiController {

    private val newsService: NewsService? = null

    @GetMapping("/daily/word")
    fun getDailyWord() : Word {
        return newsService!!.getDailyWord()
    }

    @GetMapping("/daily/question")
    fun getDailyQuestion() : Question {
        return newsService!!.getDailyQuestion()
    }
}
