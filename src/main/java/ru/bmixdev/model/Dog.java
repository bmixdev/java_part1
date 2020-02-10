package ru.bmixdev.model;

public class Dog extends Mammal {

    private final static String ANIMAL_TYPE = "Собака";

    public Dog(String name, double maxRun, double maxJump, double maxSwim) {
        super(ANIMAL_TYPE, name, maxRun, maxJump, maxSwim);
    }

    public Dog(String name) {
        super(ANIMAL_TYPE, name);
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
