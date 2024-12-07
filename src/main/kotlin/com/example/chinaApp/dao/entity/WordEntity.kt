package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(schema = "public", name = "word")
@EntityListeners(
    AuditingEntityListener::class
)
data class WordEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "word_ch")
    val wordCh: String? = null,

    @Column(name = "word_ru")
    val wordRu: String? = null,

    @Column(name = "creation_date")
    @CreatedDate
    val creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    val lastUpdateDate: OffsetDateTime? = null
)
