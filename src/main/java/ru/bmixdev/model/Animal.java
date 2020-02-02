package ru.bmixdev.model;

public class Animal {

    public Animal() {

    }

    public void run(double length) {
        System.out.printf("пробежало %.2f метров\n", length);
    }

    public void swim(double length) {
        System.out.printf("проплыло %.2f метров\n", length);
    }

    public void jump(double height) {
        System.out.printf("прыгнуло на %.2f метров\n", height);
    }

    public void info() {
        System.out.println("Просто неизвестное животное");
    }

}
