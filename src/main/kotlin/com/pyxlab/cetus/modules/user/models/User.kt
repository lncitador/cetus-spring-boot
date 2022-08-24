package com.pyxlab.cetus.modules.user.models

import com.pyxlab.cetus.modules.company.models.Company
import com.pyxlab.cetus.modules.provider.enums.Status
import com.pyxlab.cetus.modules.user.enums.Assigning
import com.pyxlab.cetus.modules.vendor.models.Vendor
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    val id: UUID,

    @Column(name = "full_name")
    val fullName: String,

    val email: String,

    val password: String,

    // @hasOne(() => Profile)
    // public profile: HasOne<typeof Profile>

    val role: Status = Status.functionary,

    val assigning: Assigning = Assigning.KEY_USER,

    @ManyToOne
    @JoinTable(
        name = "company_users",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "company_id")],
    )
    val company: Company? = null,

    @OneToOne(
        mappedBy = "user",
        cascade = [CascadeType.ALL],
    )
    val vendor: Vendor? = null,

    @NotNull
    @CreatedDate
    @Column(name = "created_at", updatable = false)
    val createdAt: LocalDateTime,

    @NotNull
    @LastModifiedDate
    @Column(name = "updated_at")
    val updatedAt: LocalDateTime,
)
