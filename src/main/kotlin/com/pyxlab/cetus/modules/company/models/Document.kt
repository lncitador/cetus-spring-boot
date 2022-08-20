package com.pyxlab.cetus.modules.company.models

import com.pyxlab.cetus.modules.company.models.Company
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "company_document")
data class Document(
    @Id
    @Column(length = 16)
    val id: UUID = UUID.randomUUID(),

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false, unique = true)
    val company: Company,

    val cs: String,

    val im: String,

    val ie: String,

    val dre: String,

    val cps: String,

    val balance: String,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
)