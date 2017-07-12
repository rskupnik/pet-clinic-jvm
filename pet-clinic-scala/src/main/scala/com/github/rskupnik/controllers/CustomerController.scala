package com.github.rskupnik.controllers

import java.{lang, util}

import scala.collection.JavaConverters._

import com.github.rskupnik.model.Customer
import com.github.rskupnik.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

// This controller uses constructor injection

@RestController
@RequestMapping(Array("/customers"))
class CustomerController (
  private val customerRepository: CustomerRepository
) {

  // Have to use arrays in annotations, which is a pain

  @RequestMapping(
    value = Array("/{id}"),
    method = Array(RequestMethod.GET),
    produces = Array("application/json")
  )
  def getCustomer(@PathVariable("id") id: Long) = customerRepository.findOne(id)

  @RequestMapping(
    method = Array(RequestMethod.GET),
    produces = Array("application/json")
  )
  def getAllCustomers() = customerRepository.findAll()

  @RequestMapping(
    value = Array("/formatted"),
    method = Array(RequestMethod.GET),
    produces = Array("application/json")
  )
  def getAllCustomersFormatted() = {
    // Use JavaConverters to move between Scala and Java collections.
    customerRepository
      .findAll()
      .asScala
      .map(_.toString())
      .asJava
  }

  @RequestMapping(
    method = Array(RequestMethod.POST),
    consumes = Array("application/json"),
    produces = Array("application/json")
  )
  def addCustomer(@RequestBody customer: Customer) = customerRepository.save(customer)
}
