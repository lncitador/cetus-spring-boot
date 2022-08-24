package com.pyxlab.cetus.modules.contact

import com.pyxlab.cetus.modules.company.models.Company
import com.pyxlab.cetus.modules.vendor.models.Vendor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

enum class ContactType {
    PHONE,
    EMAIL
}

@Entity
@Table(name = "contacts")
data class Contact(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: UUID,

    val type: ContactType,

    val value: String,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "vendor_id")
    var vendor: Vendor? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "company_id")
    var company: Company? = null,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
    )
