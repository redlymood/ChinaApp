package com.example.chinaApp.util

import com.example.chinaApp.dao.entity.*
import com.example.chinaApp.dto.*
import lombok.experimental.UtilityClass

@UtilityClass
class ConverterService {

    fun convert(entity: KnowledgeBaseEntity): KnowledgeBase {
        return KnowledgeBase(id = entity.id,
            category = entity.category,
            subcategory = entity.subcategory,
            content = entity.content)
    }

    fun convert(entity: WordEntity): Word {
        return Word(id = entity.id,
            wordCh = entity.wordCh,
            wordRu = entity.wordRu)
    }

    fun convert(entity: QuestionEntity): Question {
        return Question(id = entity.id,
            questionRus = entity.questionRus,
            questionCh = entity.questionCh)
    }

    fun convert(entity: AnswerEntity): Answer {
        return Answer(id = entity.id,
            answerText = entity.answerText,
            isCorrect = entity.isCorrect,
            questionId = entity.question?.id)
    }

    fun convert(entity: LessonEntity, isFinished: Boolean): Lesson {
        return Lesson(id = entity.id,
            lessonNumber = entity.lessonNumber,
            nameRus = entity.nameRus,
            nameCh = entity.nameCh,
            threshold = entity.threshold,
            description = entity.description,
            isFinished = isFinished)
    }

    fun convert(entity: FeedbackEntity): Feedback {
        val userId = entity.user?.id
        val lessonId = entity.lesson?.id

        return Feedback(
            id = entity.id,
            feedbackText = entity.feedbackText,
            userId = userId,
            lessonId = lessonId
        )

    }

    fun convert(entity: ProgressEntity): Progress {
        return Progress(id = entity.id,
            status = entity.status,
            userId = entity.user?.id,
            lessonId = entity.lesson?.id)
    }

    fun convert(entity: UserEntity): User {
        return User(id = entity.id,
            email = entity.email,
            name = entity.name,
            password = entity.password,
            role = entity.role)
    }
}