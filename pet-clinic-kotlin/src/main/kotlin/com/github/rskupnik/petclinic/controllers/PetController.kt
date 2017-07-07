package com.github.rskupnik.petclinic.controllers

import com.github.rskupnik.petclinic.model.Pet
import com.github.rskupnik.petclinic.repositories.PetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pets")
class PetController {

    // When using Autowired like this we need to make the variable lateinit
    @Autowired
    lateinit var petRepository: PetRepository

    @RequestMapping(
            method = arrayOf(RequestMethod.GET),
            produces = arrayOf("application/json")
    )
    fun getAllPets() = petRepository.findAll()

    @RequestMapping(
            method = arrayOf(RequestMethod.POST),
            produces = arrayOf("application/json"),
            consumes = arrayOf("application/json")
    )
    fun addPet(@RequestBody pet: Pet): Pet? = petRepository.save(pet)
}