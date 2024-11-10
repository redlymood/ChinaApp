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
@Table(name = "user")
@EntityListeners(
    AuditingEntityListener::class
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private var id: UUID? = null

    @Column(name = "email")
    private var email: String? = null

    @Column(name = "name")
    private var name: String? = null

    @Column(name = "password")
    private var password: String? = null

    @Column(name = "role")
    private var role: String? = null

    @Column(name = "creation_date")
    @CreatedDate
    private var creationDate: OffsetDateTime? = null

    @Column(name = "last_update_date")
    @LastModifiedDate
    private var lastUpdateDate: OffsetDateTime? = null
}
