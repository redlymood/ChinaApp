package com.example.chinaApp.dao.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.OffsetDateTime
import java.util.*

@Entity
@Table(schema = "public", name = "knowledge_base")
@EntityListeners(
    AuditingEntityListener::class
)
data class KnowledgeBaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    val id: UUID? = null,

    @Column(name = "category")
    val category: String? = null,

    @Column(name = "subcategory")
    val subcategory: String? = null,

    @Column(name = "content")
    val content: String? = null,

    @Column(name = "creation_date")
    @CreatedDate
    val creationDate: OffsetDateTime? = null,

    @Column(name = "last_update_date")
    @LastModifiedDate
    val lastUpdateDate: OffsetDateTime? = null

)
