package com.github.rskupnik.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.beans.BeanProperty

@Entity
class Customer {

  // Need to specify a parameterized constructor explicitly
  def this(firstName: String, lastName: String) {
    this()
    this.firstName = firstName
    this.lastName = lastName
  }

  // BeanProperty needed to generate getters and setters

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var firstName: String = _

  @BeanProperty
  var lastName: String = _

  @JsonIgnore
  @OneToMany(mappedBy = "owner")
  @BeanProperty
  var pets: java.util.List[Pet] = _

  override def toString(): String = s"$firstName $lastName"
}
