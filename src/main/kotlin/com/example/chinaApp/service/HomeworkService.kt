package com.example.chinaApp.service

import com.example.chinaApp.dao.entity.ProgressEntity
import com.example.chinaApp.dao.service.*
import com.example.chinaApp.dto.Answer
import com.example.chinaApp.dto.Lesson
import com.example.chinaApp.dto.Progress
import com.example.chinaApp.dto.Question
import com.example.chinaApp.exceptions.LessonNotFoundException
import com.example.chinaApp.exceptions.ProgressIsAlreadyExistException
import com.example.chinaApp.exceptions.ProgressNotFoundException
import com.example.chinaApp.exceptions.UserNotFoundException
import com.example.chinaApp.util.ConverterService
import org.apache.commons.lang3.ObjectUtils
import org.springframework.stereotype.Service
import java.util.*

@Service
class HomeworkService (private val questionDaoService: QuestionDaoService,
                       private val answerDaoService: AnswerDaoService,
                       private val objectConverter: ConverterService,
                       private val systemUserService: SystemUserService,
                       private val userDaoService: UserDaoService,
                       private val progressDaoService: ProgressDaoService,
                       private val lessonDaoService: LessonDaoService
){

    fun getLessons(): List<Lesson> {
        val email = systemUserService.getCurrentUser()
        if (ObjectUtils.isEmpty(email)) {
            throw UserNotFoundException("Не удалось получить уроки: пользователь не наден")
        }
        val user = userDaoService.findByEmail(email)
        if (ObjectUtils.isEmpty(user)) {
            throw UserNotFoundException("Не удалось получить уроки: пользователь не наден")
        }
        val progressMap: Map<UUID, Progress> = progressDaoService.findByUserId(user?.id )
            .map { objectConverter.convert(it) }
            .associateBy { it.lessonId!! }

        val lessonEntities = lessonDaoService.findAll()
        val lessons = mutableListOf<Lesson>()
        for (entity in lessonEntities) {
            val progress = progressMap[entity.id]
            val lesson = if (!ObjectUtils.isEmpty(progress) && "completed" == progress?.status) {
                objectConverter.convert(entity, true)
            } else {
                objectConverter.convert(entity, false)
            }
            if (!ObjectUtils.isEmpty(lesson)) {
                lessons.add(lesson)
            }
        }
        return lessons
    }

    fun getQuestionsByLessonId(lessonId: UUID): List<Question> {
        val questions = questionDaoService.findByLessonId(lessonId)
        return questions.map { entity -> objectConverter.convert(entity) }
    }

    fun getAnswerByQuestionId(questionId: UUID): List<Answer> {
        val answers = answerDaoService.findAnswersByQuestionId(questionId)
        return answers.map { entity -> objectConverter.convert(entity) }
    }

    fun startLesson(lessonId: UUID) {
        val email = systemUserService.getCurrentUser()
        if (ObjectUtils.isEmpty(email)) {
            throw UserNotFoundException("Не удалось начать урок: пользователь не найден")
        }
        val user = userDaoService.findByEmail(email)
        if (ObjectUtils.isEmpty(user)) {
            throw UserNotFoundException("Не удалось начать урок: пользователь не наден")
        }
        val lesson = lessonDaoService.findById(lessonId)
        if (lesson.isEmpty) {
            throw LessonNotFoundException("Не удалось начать урок: урок не наден")
        }
        val progressEntity = user?.id?.let { progressDaoService.findByUserIdAndLessonId(it, lessonId) }
        if (progressEntity != null) {
            throw ProgressIsAlreadyExistException("Не удалось начть урок, так как он уже был начат")
        }
        val newProgressEntity = ProgressEntity(lesson = lesson.get(), user = user, status = "processing")
        progressDaoService.save(newProgressEntity)
    }

    fun finishLesson(lessonId: UUID) {
        val email = systemUserService.getCurrentUser()
        if (ObjectUtils.isEmpty(email)) {
            throw UserNotFoundException("Не удалось завершить урок: пользователь не найден")
        }
        val user = userDaoService.findByEmail(email)
        if (ObjectUtils.isEmpty(user)) {
            throw UserNotFoundException("Не удалось завершить урок: пользователь не наден")
        }
        val lesson = lessonDaoService.findById(lessonId)
        if (lesson.isEmpty) {
            throw LessonNotFoundException("Не удалось завершить урок: урок не наден")
        }
        val progressEntity = user?.id?.let { progressDaoService.findByUserIdAndLessonId(it, lessonId) }
        if (progressEntity == null) {
            throw ProgressNotFoundException("Не удалось завершить урок, так как он еще не был начат")
        }
        val newProgressEntity = ProgressEntity(id = progressEntity.get().id,
            lesson = progressEntity.get().lesson,
            user = progressEntity.get().user,
            status = "completed")
        progressDaoService.save(newProgressEntity)
    }
}
