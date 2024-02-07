package ru.bikbaev.controller;

import ru.bikbaev.userInterface.InterfaceView;
import ru.bikbaev.userInterface.View;

import java.time.LocalDate;
import java.util.Locale;

public class Validation {

    View view;

    public Validation() {
        this.view = new InterfaceView();
    }

    public LocalDate localDate(String date) {
        String[] dates = date.split(",");
        int year = Integer.parseInt(dates[0]);
        int month = Integer.parseInt(dates[1]);
        int day = Integer.parseInt(dates[2]);
        return LocalDate.of(year, month, day);
    }
}
