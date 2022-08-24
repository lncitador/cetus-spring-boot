package com.pyxlab.cetus.modules.vendor.models

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "VendorDocuments")
@Table(name = "vendor_documents")
data class Document (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    var id: UUID,

    val cs: String, // Contrato Social

    val im: String, // Inscrição Municipal

    val ie: String, // Inscrição Estadual

    val dre: String,

    val tgc: String, // Termos Gerais de Compra

    val certified: String,

    val nda: String,

    val balance: String, // Balanço

    @OneToOne
    @JoinColumn(name = "vendor_id")
    val vendor: Vendor,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
)