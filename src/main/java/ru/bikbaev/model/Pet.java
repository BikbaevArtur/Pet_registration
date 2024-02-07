package ru.bikbaev.model;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedList;


@ToString
@Getter
public abstract class Pet {

    protected int id;
    private static int lastId = 0;
    protected String name;
    protected LocalDate birthday;
    protected TypePet typePet;

    LinkedList<String> commands = new LinkedList<>();

   protected  Pet(TypePet typePet, String name, LocalDate birthday) {
        this.typePet = typePet;
        this.name = name;
        this.birthday = birthday;
        this.id = ++lastId;
    }

    public void addCommand(String command) {
        commands.add(command);
    }


}
