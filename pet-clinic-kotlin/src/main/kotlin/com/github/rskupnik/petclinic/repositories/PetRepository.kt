package com.github.rskupnik.petclinic.repositories

import com.github.rskupnik.petclinic.model.Pet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PetRepository : CrudRepository<Pet, Long> {

}