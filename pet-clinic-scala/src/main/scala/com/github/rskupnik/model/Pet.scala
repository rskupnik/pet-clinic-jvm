package com.github.rskupnik.model

import javax.persistence._

import scala.annotation.meta.field
import scala.beans.BeanProperty

@Entity
case class Pet(
                @(Id@field)
                @(GeneratedValue@field)
                @BeanProperty
                var id: Long,
                @BeanProperty
                var name: String) {

  // Need to specify an empty constructor
  def this() {
    this(0, "")
  }

  @ManyToOne
  @JoinColumn(name = "ownerId", nullable = false)
  @BeanProperty
  var owner: Customer = _

  override def toString: String = name

}
