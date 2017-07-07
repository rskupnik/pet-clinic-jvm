package com.github.rskupnik.petclinic

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class PetClinicApplication

fun main(args: Array<String>) {

    // The *args here is NOT a pointer dereference, it's a spread operator to pass contents
    // of an array to a method that accepts a variable number of arguments
    SpringApplication.run(PetClinicApplication::class.java, *args)
}

