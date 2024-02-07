package ru.bikbaev.model;

import ru.bikbaev.userInterface.View;

import java.time.LocalDate;

public class CreatPet {

    public Pet creatNewPet(TypePet typePet, String name, LocalDate date) {
        switch (typePet) {
            case Cat -> {
                return new Cat(typePet,name, date);

            }
            case Dog -> {
                return new Dog(typePet,name, date);

            }
            case Hamster -> {
                return new Hamster(typePet,name, date);

            }
            default -> {
                return null;
            }
        }
    }
}
