package com.github.rskupnik.petclinic.controllers;

import com.github.rskupnik.petclinic.model.Pet;
import com.github.rskupnik.petclinic.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = "application/json"
    )
    public Pet addPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }
}
