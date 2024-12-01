package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(schema = "public", name = "answer")
@EntityListeners(
    AuditingEntityListener::class
)
data class AnswerEntity (

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "answer_text")
    val answerText: String? = null,

    @Column(name = "is_correct")
    val isCorrect: Boolean? = null,

    @ManyToMany
    @JoinTable(
        name = "answer_user",
        joinColumns = [JoinColumn(name = "answer_id")],
        inverseJoinColumns = [JoinColumn(name = "user_id")]
    )
    val users: List<UserEntity>? = null,

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")
    val question: QuestionEntity? = null,

    @Column(name = "creation_date")
    @CreatedDate
    val creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    val lastUpdateDate: OffsetDateTime? = null
)
