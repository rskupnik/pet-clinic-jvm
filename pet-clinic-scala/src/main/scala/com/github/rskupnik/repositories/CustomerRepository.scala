package com.github.rskupnik.repositories

import com.github.rskupnik.model.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// Need to specify java.lang.Long instead of Scala's Long

@Repository
trait CustomerRepository extends CrudRepository[Customer, java.lang.Long] {
  def findByLastName(lastName: String): List[Customer]
}
