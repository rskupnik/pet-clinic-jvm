package com.github.rskupnik.repositories

import com.github.rskupnik.model.Pet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

// Need to specify java.lang.Long instead of Scala's Long

@Repository
trait PetRepository extends CrudRepository[Pet, java.lang.Long]
