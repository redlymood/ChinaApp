package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(schema = "public", name = "feedback")
@EntityListeners(
    AuditingEntityListener::class
)
data class FeedbackEntity (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "feedback_text")
    val feedbackText: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    val user: UserEntity? = null,

    @ManyToOne
    @JoinColumn(name = "lesson_id", referencedColumnName = "id")
    val lesson: LessonEntity? = null,

    @Column(name = "creation_date")
    @CreatedDate
    val creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    val lastUpdateDate: OffsetDateTime? = null
)
