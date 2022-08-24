package com.pyxlab.cetus.modules.address.models

import com.pyxlab.cetus.modules.company.models.Company
import com.pyxlab.cetus.modules.vendor.models.Vendor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "address")
data class Address (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: UUID,

    val cep: String,

    val state: String,

    val city: String,

    val neighborhood: String,

    val street: String,

    val number: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "company_id")
    var company: Company? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "vendor_id")
    var vendor: Vendor? = null,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
    )