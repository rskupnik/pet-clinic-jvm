package com.github.rskupnik.controllers

import com.github.rskupnik.model.Pet
import com.github.rskupnik.repositories.PetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

// This controller uses field injection

@RestController
@RequestMapping(Array("/pets"))
class PetController {

  @Autowired
  var petRepository: PetRepository = null

  @GetMapping(produces = Array("application/json"))
  def getAllPets = petRepository.findAll()

  @PostMapping(produces = Array("application/json"), consumes = Array("application/json"))
  def addPet(@RequestBody pet: Pet) = petRepository.save(pet)

}
