package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import lombok.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Getter
@Setter
@Table(schema = "public", name = "question")
@EntityListeners(
    AuditingEntityListener::class
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
data class QuestionEntity (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID? = null,

    @Column(name = "question_rus")
    val questionRus: String? = null,

    @Column(name = "question_ch")
    val questionCh: String? = null,

    @ManyToMany(mappedBy = "questions")
    val lessons: List<LessonEntity>? = null,

    @OneToMany(mappedBy = "question", cascade = [CascadeType.ALL], orphanRemoval = true)
    val answers: List<AnswerEntity>? = null,

    @Column(name = "creation_date")
    @CreatedDate
    val creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    val lastUpdateDate: OffsetDateTime? = null
)
