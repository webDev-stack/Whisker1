package com.jdbc.demo;

import java.util.List;

interface IPetDAO {
    void addPet(Pet pet);
    void updatePet(Pet pet);
    void deletePet(int petId);
    Pet getPetById(int petId);
    List<Pet> getAllPets();
}
