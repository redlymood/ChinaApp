package com.example.chinaApp.api

import com.example.chinaApp.dto.Question
import com.example.chinaApp.dto.Word
import com.example.chinaApp.service.NewsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class NewsApiController(
    private val newsService: NewsService
) {

    @GetMapping("/daily/word")
    fun getDailyWord() : ResponseEntity<Word> {
        return ResponseEntity.ok().body(newsService.getDailyWord())
    }

    @GetMapping("/daily/question")
    fun getDailyQuestion() : ResponseEntity<Question> {
        return ResponseEntity.ok().body(newsService.getDailyQuestion())
    }
}
