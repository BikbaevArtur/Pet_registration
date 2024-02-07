package ru.bikbaev.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.LinkedList;
@Getter
public class Dog extends Pet {
   protected  LinkedList<String> commands = new LinkedList<>();
   protected TypePet typePet;

    protected Dog(TypePet typePet,String name, LocalDate birthday) {
        super(typePet,name, birthday);
        this.commands.add("Кушать");
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "commands=" + commands +
                ", typePet=" + typePet +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
