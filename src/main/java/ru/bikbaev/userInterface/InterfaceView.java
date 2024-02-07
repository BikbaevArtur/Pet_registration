package ru.bikbaev.userInterface;

import ru.bikbaev.model.Pet;

import java.time.LocalDate;
import java.util.AbstractList;
import java.util.Scanner;


public class InterfaceView implements View {

    Scanner in;

    public InterfaceView() {
        this.in = new Scanner(System.in);
    }

    @Override
    public String setName() {

        System.out.println("Введите имя питомц: ");

        return in.nextLine();

    }

    @Override
    public String setBirthday() {

        System.out.println("Введите дату рождения питомца: ");
        return in.nextLine();
    }


    @Override
    public void printAll(AbstractList<Pet> pets) {

        System.out.println(pets);

    }

    @Override
    public String trainCommand() {
        System.out.println("Введите команду для обучения: ");
        return in.nextLine();
    }
}

