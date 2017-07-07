package com.github.rskupnik.petclinic.model

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

// Implementation using a data class (preferred)

// 1. If you specify as data class, you get a toString, otherwise - if as a regular class, you need to add the toString yourself
// 2. Entity classes need a default constructor - one is provided here by giving all the arguments a default value
@Entity
data class Customer(
        @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Long = 0,
        var firstName: String = "",
        var lastName: String = "",
        // Use JsonIgnore to avoid circular mapping
        @JsonIgnore @OneToMany(mappedBy = "owner") var pets: List<Pet>? = null
) {
    // Can ommit this if you specify class as data class and the default toString it provides suits you
    override fun toString(): String = "$firstName $lastName"
}