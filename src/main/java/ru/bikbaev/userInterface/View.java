package ru.bikbaev.userInterface;

import ru.bikbaev.model.Pet;


import java.util.AbstractList;

public interface View {

    String setName();

    String setBirthday();

    void printAll(AbstractList<Pet> pets);

    String trainCommand();


}
