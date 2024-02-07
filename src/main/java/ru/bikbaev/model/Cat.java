package ru.bikbaev.model;


import lombok.Getter;

import java.time.LocalDate;
import java.util.LinkedList;


@Getter
public class Cat extends Pet {

    protected LinkedList<String> commands = new LinkedList<>();
    protected TypePet typePet;


    protected Cat(TypePet typePet, String name, LocalDate birthday) {
        super(typePet, name, birthday);

        this.commands.add("тыгыдыкгать");
    }


    public void addCommand(String command) {
        commands.add(command);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Команды: " + commands +
                ", Тип питомца=" + typePet +
                ", id=" + id +
                ", Имя='" + name + '\'' +
                ", Дата рождения =" + birthday +
                '}';


    }
}
