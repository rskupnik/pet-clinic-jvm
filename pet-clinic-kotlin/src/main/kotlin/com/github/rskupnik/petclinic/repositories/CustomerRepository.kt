package com.github.rskupnik.petclinic.repositories

import com.github.rskupnik.petclinic.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : CrudRepository<Customer, Long> {
    fun findByLastName(name: String): List<Customer>    // Not actually used in the controller
}