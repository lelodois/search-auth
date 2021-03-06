package br.com.lelo.domain

import javax.persistence.*
import javax.validation.constraints.Size

@Entity
@Table(name = "AUTHUSER")
class AuthUser {

    @Id
    @Column(updatable = false, nullable = false)
    var username: String? = null

    @Size(min = 0, max = 500)
    var password: String? = null

    var activated: Boolean = false

    @Size(min = 0, max = 100)
    @Column(name = "activationkey")
    var activationKey: String? = null

    @Size(min = 0, max = 100)
    @Column(name = "resetpasswordkey")
    var resetPasswordKey: String? = null

    @ManyToMany
    @JoinTable(
            name = "USER_AUTHORITY",
            joinColumns = [JoinColumn(name = "username")],
            inverseJoinColumns = [JoinColumn(name = "authority")]
    )
    var authorities: Set<Authority>? = null

}