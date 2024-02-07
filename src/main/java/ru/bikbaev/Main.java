package ru.bikbaev;


import ru.bikbaev.controller.PetController;
import ru.bikbaev.model.Cat;
import ru.bikbaev.userInterface.InterfaceMenu;
import ru.bikbaev.userInterface.InterfaceView;


import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        PetController petController = new PetController();
        InterfaceView interfaceView = new InterfaceView();
        InterfaceMenu interfaceMenu = new InterfaceMenu(petController,interfaceView);
        interfaceMenu.start();


    }
}