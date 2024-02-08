package ru.bikbaev.userInterface;

import ru.bikbaev.controller.PetController;
import ru.bikbaev.model.TypePet;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceMenu {

    private final PetController petController;
    private final InterfaceView interfaceView;

    private final Scanner scanner;

    public InterfaceMenu(PetController petController, InterfaceView interfaceView) {
        this.interfaceView = interfaceView;
        this.petController = petController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean flag = true;
        while (flag) {

            try {

                System.out.println("Выберите пункты меню:");
                System.out.println("0 Выход");
                System.out.println("1 Добавить нового  питомца");
                System.out.println("2 Удалить питомца");
                System.out.println("3 Выбрать питомца");
                System.out.println("4 Вывести на экран всех питомцев");


                int button = scanner.nextInt();


                switch (button) {
                    case 0:
                        flag = false;
                        break;
                    case 1:
                        addMenu();
                        break;
                    case 2:
                        petController.deletePet(petController.getPetIndex(interfaceView.setName()));
                        break;
                    case 3:
                        petMenu();
                        break;
                    case 4:
                        interfaceView.printAll(petController.getPets());
                        break;
                    default:
                        System.out.println("\nВыберите корректный пункт меню:");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("\u001B[31m"+"Ошибка: Некорректный ввод"+ "\u001B[0m");
                System.out.println("\u001B[32m"+"Введите числовой номер меню:" + "\u001B[0m");
                scanner.next();
            }
        }

    }

    private void addMenu() {


        boolean flag = true;

        while (flag) {
            try {

                System.out.println("0 Назад");
                System.out.println("1 Добавить Кота");
                System.out.println("2 Добавить Собаку");
                System.out.println("3 Добавить хомяка");
                int button = scanner.nextInt();
                if (button < 0 || button > 3) {
                    System.out.println("Выберите корректный пункт в меню");
                }
                switch (button) {
                    case 0:
                        flag = false;
                        start();
                        break;
                    case 1:
                        petController.creatPet(TypePet.Cat);
                        break;
                    case 2:
                        petController.creatPet(TypePet.Dog);
                        break;
                    case 3:
                        petController.creatPet(TypePet.Hamster);
                        break;
                    default:
                        System.out.println("\nВыберите корректный пункт меню:");
                }
            }
            catch (InputMismatchException ex){
                System.out.println("\u001B[31m"+"Ошибка: Некорректный ввод"+ "\u001B[0m");
                System.out.println("\u001B[32m"+"Введите числовой номер меню:" + "\u001B[0m");
                scanner.next();
            }
        }

    }

    private void petMenu() {

        boolean flag = true;
        while (flag) {
            try {

                System.out.println("0 Назад");
                System.out.println("1 Найти питомца");
                System.out.println("2 Обучить питомца командам");
                int button = scanner.nextInt();

                switch (button) {
                    case 0:
                        flag = false;
                        start();
                        break;
                    case 1:
                        System.out.println(petController.getPet());
                        break;
                    case 2:
                        System.out.println("Выберите питомца: ");
                        petController.trainPet();
                    default:
                        System.out.println("\nВыберите корректный пункт меню:");
                }
            }
            catch (InputMismatchException ex ){
                System.out.println("\u001B[31m"+"Ошибка: Некорректный ввод"+ "\u001B[0m");
                System.out.println("\u001B[32m"+"Введите числовой номер меню:" + "\u001B[0m");
                scanner.next();
            }
        }
    }
}
