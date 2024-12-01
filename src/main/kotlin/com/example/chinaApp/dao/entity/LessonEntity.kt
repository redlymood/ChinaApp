package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(schema = "public", name = "lesson")
@EntityListeners(
    AuditingEntityListener::class
)
data class LessonEntity (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "lesson_number")
    val lessonNumber: String? = null,

    @Column(name = "name_rus")
    val nameRus: String? = null,

    @Column(name = "name_ch")
    val nameCh: String? = null,

    @Column(name = "threshold")
    val threshold: Int? = null,

    @Column(name = "description")
    val description: String? = null,

    @OneToMany(mappedBy = "lesson", cascade = [CascadeType.ALL], orphanRemoval = true)
    val feedbacks: List<FeedbackEntity>? = null,

    @ManyToMany
    @JoinTable(
        name = "lesson_question",
        joinColumns = [JoinColumn(name = "lesson_id")],
        inverseJoinColumns = [JoinColumn(name = "question_id")]
    )
    val questions: List<QuestionEntity>? = null,

    @Column(name = "creation_date")
    @CreatedDate
    var creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    var lastUpdateDate: OffsetDateTime? = null
)
