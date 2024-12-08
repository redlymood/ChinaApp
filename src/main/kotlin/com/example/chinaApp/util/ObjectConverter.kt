package com.example.chinaApp.util

import com.example.chinaApp.dao.entity.*
import com.example.chinaApp.dto.*

class ObjectConverter {

    fun KnowledgeBaseEntity.toDTO(): KnowledgeBase {
        return KnowledgeBase(id = this.id,
            category = this.category,
            subcategory = this.subcategory,
            content = this.content)
    }

    fun KnowledgeBase.toEntity(): KnowledgeBaseEntity {
        return KnowledgeBaseEntity(id = this.id,
            category = this.category,
            subcategory = this.subcategory,
            content = this.content)
    }

    fun WordEntity.toDTO(): Word {
        return Word(id = this.id,
            wordCh = this.wordCh,
            wordRu = this.wordRu)
    }

    fun Word.toEntity(): WordEntity {
        return WordEntity(id = this.id,
            wordCh = this.wordCh,
            wordRu = this.wordRu)
    }

    fun QuestionEntity.toDTO(): Question {
        return Question(id = this.id,
            questionRus = this.questionRus,
            questionCh = this.questionCh)
    }

    fun LessonEntity.toDTO(): Lesson {
        return Lesson(
            id = this.id,
            lessonNumber = this.lessonNumber,
            nameRus = this.nameRus,
            nameCh = this.nameCh,
            threshold = this.threshold,
            description = this.description,
            feedbacks = this.feedbacks?.map { it.toDTO() },
            questions = this.questions?.map { it.toDTO() },
            isFinished = false,
        )
    }

    fun ProgressEntity.toDTO(): Progress {
        return Progress()
    }

    fun UserEntity.toDTO(): User {
        return User()
    }

    fun FeedbackEntity.toDTO(): Feedback {
        return Feedback()
    }
}