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
@Table(name = "feedback")
@EntityListeners(
    AuditingEntityListener::class
)
@AllArgsConstructor
@NoArgsConstructor
@Builder
class FeedbackEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private var id: UUID? = null

    @Column(name = "feedback_text")
    private var feedbackText: String? = null

    @Column(name = "creation_date")
    @CreatedDate
    private var creationDate: OffsetDateTime? = null

    @Column(name = "last_update_date")
    @LastModifiedDate
    private var lastUpdateDate: OffsetDateTime? = null

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private var user: UserEntity? = null
}
