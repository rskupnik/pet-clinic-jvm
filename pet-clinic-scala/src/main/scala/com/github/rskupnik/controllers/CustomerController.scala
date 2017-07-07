package com.github.rskupnik.controllers

import java.{lang, util}

import com.github.rskupnik.model.Customer
import com.github.rskupnik.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation._

// This controller uses constructor injection

@RestController
@RequestMapping(Array("/customers"))
class CustomerController @Autowired() (private val customerRepository: CustomerRepository) {

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
    // This can probably be done much better, blame my low Scala skills
    val output: java.util.List[String] = new util.ArrayList[String]()
    val customers: java.util.Iterator[Customer] = customerRepository.findAll().iterator()
    while (customers.hasNext) {
      output.add(customers.next().toString())
    }
    output
  }

  @RequestMapping(
    method = Array(RequestMethod.POST),
    consumes = Array("application/json"),
    produces = Array("application/json")
  )
  def addCustomer(@RequestBody customer: Customer) = customerRepository.save(customer)
}
