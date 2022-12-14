package com.pyxlab.cetus.modules.company.models

import com.pyxlab.cetus.modules.address.models.Address
import com.pyxlab.cetus.modules.company.enums.Status
import com.pyxlab.cetus.modules.contact.Contact
import com.pyxlab.cetus.modules.user.models.User
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.*

@Entity
@Table(name = "companies")
data class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: UUID = UUID.randomUUID(),

    @NotNull
    @Column(unique = true, length = 14)
    val cnpj: String,

    @Column(name = "social_name")
    val socialName: String,

    @Column(name = "fantasy_name")
    val fantasyName: String,

    @OneToMany(mappedBy = "company")
    val address: List<Address>,

    val status: Status = Status.NEW,

    @Column(name = "cost_center")
    val costCenter: String,

    val segment: String,

    @Column(name = "supplier_type")
    val supplierType: com.pyxlab.cetus.shared.enums.Status,

    @OneToMany(mappedBy = "company")
    val contacts: List<Contact>,

    @OneToOne(mappedBy = "company")
    val document: Document,

    @OneToMany(mappedBy = "company")
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
