package com.pyxlab.cetus.modules.company.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "company_user")
data class Users(
    @Id
    @Column(length = 16)
    val id: UUID = UUID.randomUUID(),

    val user_id: UUID,

    val company_id: UUID,
)
