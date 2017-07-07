package com.github.rskupnik.model

import javax.persistence._

import scala.beans.BeanProperty

@Entity
class Pet {

  def this(name: String, owner: Customer) {
    this()
    this.name = name
    this.owner = owner
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  @ManyToOne
  @JoinColumn(name = "ownerId", nullable = false)
  @BeanProperty
  var owner: Customer = _
}
