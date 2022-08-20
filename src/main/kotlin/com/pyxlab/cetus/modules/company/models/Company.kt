package com.pyxlab.cetus.modules.company.models

import com.pyxlab.cetus.modules.address.Address
import com.pyxlab.cetus.modules.company.enums.Status
import com.pyxlab.cetus.modules.user.models.User
import com.pyxlab.cetus.modules.provider.enums.Status as ProviderStatus
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull

@Entity(name = "companies")
data class Company(
    @Id
    @Column(length = 16)
    val id: UUID = UUID.randomUUID(),

    @NotNull
    @Column(unique = true, length = 14)
    val cnpj: String,

    @Column(name = "social_name")
    val socialName: String,

    @Column(name = "fantasy_name")
    val fantasyName: String,

    @Column(columnDefinition = "json")
    val address: Address,

    val status: Status,

    @Column(name = "cost_center")
    val costCenter: String,

    val segment: String,

    @Column(name = "supplier_type")
    val supplierType: com.pyxlab.cetus.shared.enums.Status,

    val phone: String,

    @Email
    val email: String,

    val provider: ProviderStatus,

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "company")
    val document: Document,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    val providers: List<User>,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
)
