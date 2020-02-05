package ru.bmixdev.lesson07;

public class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public boolean decreaseFood(int n) {
        if ((food - n) < 0) {
            System.out.println("В тарелке не достаточно еды!");
            return false;
        }
        else {
            food -= n;
            return true;
        }
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}