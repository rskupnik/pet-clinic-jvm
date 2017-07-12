package com.github.rskupnik.petclinic.controllers

import com.github.rskupnik.petclinic.model.Customer
import com.github.rskupnik.petclinic.repositories.CustomerRepository
import org.springframework.web.bind.annotation.*

// Constructor injection, as presented here, is the preferred way, especially with Kotlin
@RestController
@RequestMapping("/customers")
class CustomerController(val customerRepository: CustomerRepository) {

    // The need to use arrayOf() in annotations is annoying, but at least we can ommit it in default value

    @GetMapping(value = "/{id}", produces = arrayOf("application/json"))
    fun getCustomer(@PathVariable("id") id: Long): Customer? =
            customerRepository.findOne(id)

    @GetMapping(value = "/formatted", produces = arrayOf("application/json"))
    fun getAllCustomersFormatted() =
            customerRepository.findAll().map { it.toString() }

    @GetMapping(produces = arrayOf("application/json"))
    fun getAllCustomers() = customerRepository.findAll()

    @PostMapping(produces = arrayOf("application/json"), consumes = arrayOf("application/json"))
    fun addCustomer(@RequestBody customer: Customer): Customer? =
            customerRepository.save(customer)
}