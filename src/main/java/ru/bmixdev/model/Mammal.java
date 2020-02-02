package ru.bmixdev.model;

import ru.bmixdev.Utils;

public class Mammal extends Animal {

    protected double restrictionOnRun;
    protected double restrictionOnJump;
    protected double restrictionOnSwim;
    protected String name;
    protected String type;

    public Mammal() {
        this.type = "";
    }

    public Mammal(String type, String name, double maxRun, double maxJump, double maxSwim) {
        this.name = name;
        this.type = type;
        this.restrictionOnRun = maxRun;
        this.restrictionOnJump = maxJump;
        this.restrictionOnSwim = maxSwim;
    }

    public Mammal(String type, String name) {
        this.name = name;
        this.type = type;
        this.restrictionOnRun = Utils.getRandom(1, 1000);
        this.restrictionOnJump = Utils.getRandom(1, 3);
        this.restrictionOnSwim = Utils.getRandom(1, 20);
    }

    @Override
    public void jump(double height) {
        if (restrictionOnJump < height) {
            System.out.printf("%s %s не может прыгнуть выше чем %.2f метров\n", this.type, this.name, restrictionOnJump);
        }
        else {
            System.out.printf("%s %s:", this.type, this.name);
            super.jump(height);
        }
    }

    @Override
    public void swim(double length) {
        if (restrictionOnJump < length) {
            System.out.printf("%s %s не может проплыть выше чем %.2f метров\n", this.type, this.name, restrictionOnJump);
        }
        else {
            System.out.printf("%s %s:", this.type, this.name);
            super.swim(length);
        }
        //System.out.printf("Кот %s не умеет плавать\n", this.name);
    }

    @Override
    public void run(double length) {
        if (restrictionOnRun< length) {
            System.out.printf("%s %s не может пробежать больше %.2f метров\n", this.type, this.name, restrictionOnRun);
        }
        else {
            System.out.printf("%s %s:", this.type, this.name);
            super.run(length);
        }
    }

    @Override
    public String toString() {
        return "Mammal{" +
                "restrictionOnRun=" + restrictionOnRun +
                ", restrictionOnJump=" + restrictionOnJump +
                ", restrictionOnSwim=" + restrictionOnSwim +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
