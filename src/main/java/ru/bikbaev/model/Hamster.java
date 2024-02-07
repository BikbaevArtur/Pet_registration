package ru.bikbaev.model;

import lombok.Getter;

import java.time.LocalDate;
import java.util.LinkedList;
@Getter
public class Hamster extends Pet {
   protected LinkedList<String> commands = new LinkedList<>();
   protected TypePet typePet;

    protected Hamster(TypePet typePet,String name, LocalDate birthday) {
        super(typePet,name, birthday);
        this.typePet = TypePet.Hamster;
        this.commands.add("бежать");
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public String toString() {
        return "Hamster{" +
                "commands=" + commands +
                ", typePet=" + typePet +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
