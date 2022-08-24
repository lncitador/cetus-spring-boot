package com.pyxlab.cetus.modules.vendor.models

import com.pyxlab.cetus.modules.address.models.Address
import com.pyxlab.cetus.modules.contact.Contact
import com.pyxlab.cetus.modules.user.models.User
import com.pyxlab.cetus.modules.vendor.enums.Status
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "vendors")
data class Vendor(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: UUID,

    @NotNull
    @Column(unique = true, length = 14)
    val cnpj: String,

    @Column(name = "social_name")
    val socialName: String,

    @Column(name = "fantasy_name")
    val fantasyName: String,

    val status: Status,

    @OneToOne(mappedBy = "vendor", cascade = [CascadeType.ALL])
    var documents: Document,

    @OneToOne
    @JoinColumn(name = "user_id")
    val user: User,

    @OneToMany(mappedBy = "vendor")
    val contact: List<Contact>,

    @OneToMany(mappedBy = "vendor")
    val address: List<Address>,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
)