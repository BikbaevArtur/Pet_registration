package ru.bikbaev.controller;

import lombok.Getter;
import ru.bikbaev.model.Cat;
import ru.bikbaev.model.CreatPet;
import ru.bikbaev.model.Pet;
import ru.bikbaev.model.TypePet;
import ru.bikbaev.userInterface.InterfaceView;
import ru.bikbaev.userInterface.View;


import java.net.Proxy;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
public class PetController {
    private final ArrayList<Pet> pets = new ArrayList<>();
    private final CreatPet creatPet;
    private final Validation validation;
    private final View view;


    public PetController() {
        this.creatPet = new CreatPet();
        this.validation = new Validation();
        this.view = new InterfaceView();
    }

    public void creatPet(TypePet typePet) {
        String name = view.setName();
        LocalDate birthday = validation.localDate(view.setBirthday());
        pets.add(creatPet.creatNewPet(typePet, name, birthday));
        Count.add();
    }

    public int getPetIndex(String name) {
        for (int i = 0; i < pets.size(); i++) {
            if (name.equals(pets.get(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public Pet getPet() {
        return pets.get(getPetIndex(view.setName()));
    }

    public void trainPet(){
        Pet pet =  getPet();
        pet.addCommand(view.trainCommand());

    }


    public void deletePet(int index) {

        pets.remove(index);
        Count.remove();
    }

}
