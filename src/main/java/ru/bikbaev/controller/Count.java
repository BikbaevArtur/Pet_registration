package ru.bikbaev.controller;

import lombok.Getter;

@Getter
public class Count {
    static int count = 0;

    protected static void add() {
        count++;
    }

    protected static void remove() {
        count--;
    }
}
