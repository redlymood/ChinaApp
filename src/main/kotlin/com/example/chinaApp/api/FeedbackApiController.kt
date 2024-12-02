package com.example.chinaApp.api

import com.example.chinaApp.dto.Feedback
import com.example.chinaApp.service.FeedbackService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FeedbackApiController(
    private val feedbackService: FeedbackService
) {

    @PostMapping("/feedback")
    fun addFeedback(@RequestBody feedback: Feedback): ResponseEntity<Void> {
        feedbackService.addFeedback(feedback)
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
