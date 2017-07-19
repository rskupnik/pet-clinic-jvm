package com.github.rskupnik.petclinic.model

import javax.persistence.*

// Implementation using a regular class, mimicking regular Java

@Entity
class Pet {

    // We need to specify the default constructor and the parameterized constructor explicitly
    constructor() {

    }

    constructor(name: String) {
        this.name = name
    }

    @Id
    @GeneratedValue
    var id: Long = 0

    var name: String = ""

    @ManyToOne
    @JoinColumn(name = "ownerId", nullable = false)
    var owner: Customer? = null

    override fun toString(): String = "$name"
}