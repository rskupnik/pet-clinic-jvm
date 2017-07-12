package com.github.rskupnik.petclinic.controllers

import com.github.rskupnik.petclinic.model.Customer
import com.github.rskupnik.petclinic.repositories.CustomerRepository
import org.springframework.web.bind.annotation.*

// Constructor injection, as presented here, is the preferred way, especially with Kotlin
@RestController
@RequestMapping("/customers")
class CustomerController(val customerRepository: CustomerRepository) {

    // The need to use arrayOf() in annotations is annoying, but at least we can ommit it in default value

    @RequestMapping(
            value = "/{id}",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    fun getCustomer(@PathVariable("id") id: Long): Customer? =
            customerRepository.findOne(id)

    @RequestMapping(
            value = "/formatted",
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    fun getAllCustomersFormatted() =
            customerRepository.findAll().map { it.toString() }

    @RequestMapping(
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    fun getAllCustomers() = customerRepository.findAll()

    @RequestMapping(
            method = arrayOf(RequestMethod.POST),
            produces = arrayOf("application/json"),
            consumes = arrayOf("application/json")
    )
    fun addCustomer(@RequestBody customer: Customer): Customer? =
            customerRepository.save(customer)
}