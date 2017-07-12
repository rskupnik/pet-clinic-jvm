package com.github.rskupnik.petclinic.controllers;

import com.github.rskupnik.petclinic.model.Pet;
import com.github.rskupnik.petclinic.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @GetMapping(produces = "application/json")
    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }

    @PostMapping(produces = "application/json", consumes = "application/json")
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }
}
