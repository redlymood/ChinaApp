package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(schema = "public", name = "user")
@EntityListeners(
    AuditingEntityListener::class
)
data class UserEntity (
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    @Column(name = "email")
    val email: String? = null,

    @Column(name = "name")
    val name: String? = null,

    @Column(name = "password")
    val password: String? = null,

    @Column(name = "role")
    val role: String? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val progresses: List<ProgressEntity>? = null,

    @ManyToMany(mappedBy = "users")
    val answers: List<AnswerEntity>? = null,

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val feedbacks: List<FeedbackEntity>? = null,

    @Column(name = "creation_date")
    @CreatedDate
    val creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    val lastUpdateDate: OffsetDateTime? = null
)
