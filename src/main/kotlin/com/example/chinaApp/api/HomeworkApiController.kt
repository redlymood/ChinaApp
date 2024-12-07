package com.example.chinaApp.api

import com.example.chinaApp.dto.Answer
import com.example.chinaApp.dto.Lesson
import com.example.chinaApp.dto.Question
import com.example.chinaApp.service.HomeworkService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class HomeworkApiController (
    private val homeworkService: HomeworkService
) {

    @GetMapping("/lessons")
    fun getLessons(): ResponseEntity<List<Lesson>> {
        return ResponseEntity.ok().body(homeworkService.getLessons())
    }

    @GetMapping("/lesson/{lesson_id}/questions")
    fun getQuestionsByLessonId(@PathVariable("lesson_id") lessonId: UUID): ResponseEntity<List<Question>> {
        return ResponseEntity.ok().body(homeworkService.getQuestionsByLessonId(lessonId))
    }

    @GetMapping("/question/{question_id}/answers")
    fun answersByQuestionId(@PathVariable("question_id") questionId: UUID): ResponseEntity<List<Answer>> {
        return ResponseEntity.ok().body(homeworkService.getAnswerByQuestionId(questionId))
    }

    @PostMapping("/lesson/{lesson_id}/finish")
    fun finishLesson(@PathVariable("lesson_id") lessonId: UUID): ResponseEntity<Void> {
        homeworkService.finishLesson(lessonId)
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/lesson/{lesson_id}/start")
    fun startLesson(@PathVariable("lesson_id") lessonId: UUID): ResponseEntity<Void> {
        homeworkService.startLesson(lessonId)
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}