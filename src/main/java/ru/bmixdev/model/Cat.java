package ru.bmixdev.model;

public class Cat extends Mammal {

    private final static String ANIMAL_TYPE = "Кот";

    public Cat(String name, double maxRun, double maxJump, double maxSwim) {
        super(ANIMAL_TYPE, name, maxRun, maxJump, 0);
    }

    public Cat(String name) {
        super(ANIMAL_TYPE, name);
        this.restrictionOnSwim = 0;
    }

    @Override
    public void swim(double length) {
        System.out.printf("%s %s не умеет плавать!\n", ANIMAL_TYPE, this.name);
    }

    @Override
    public String toString() {
        return "Dog{"+super.toString()+"}";
    }

    @Override
    public void info() {
        System.out.printf("%s %s\n", ANIMAL_TYPE, this.name);
    }
}
