package com.pyxlab.cetus.modules.user.models

import com.pyxlab.cetus.modules.provider.enums.Status
import com.pyxlab.cetus.modules.user.enums.Assigning
import java.util.*
import javax.persistence.*

@Entity(name = "users")
data class User(
    @Id
    @Column(length = 16)
    val id: UUID = UUID.randomUUID(),

    @Column(name = "full_name")
    val fullName: String,

    val email: String,

    val password: String,

    // @hasOne(() => Profile)
    // public profile: HasOne<typeof Profile>

    val role: Status = Status.functionary,

    val assigning: Assigning = Assigning.keyuser

    // @hasOne(() => CompaniesUser)
    // public company: HasOne<typeof CompaniesUser>

    // @hasOne(() => VendorsUser)
    // public vendor: HasOne<typeof VendorsUser>
)
