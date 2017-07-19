package com.github.rskupnik.model

import javax.persistence._

import com.fasterxml.jackson.annotation.JsonIgnore

import scala.annotation.meta.field
import scala.beans.BeanProperty

// BeanProperty needed to generate getters and setters

@Entity
case class Customer(
                     @(Id@field)
                     @(GeneratedValue@field)
                     @BeanProperty
                     var id: Long,
                     @BeanProperty
                     var firstName: String,
                     @BeanProperty
                     var lastName: String) {

  // Need to specify an empty constructor
  def this() {
    this(0, "", "")
  }

  @JsonIgnore
  @OneToMany(mappedBy = "owner")
  @BeanProperty
  var pets: java.util.List[Pet] = _

  override def toString: String = s"$firstName $lastName"

}
