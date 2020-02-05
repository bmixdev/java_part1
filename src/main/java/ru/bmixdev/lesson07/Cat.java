package ru.bmixdev.lesson07;

public class Cat {
    private String name;
    private int appetite;
    private int full;

    public Cat(String name, int appetite, int full) {
        this.name = name;
        this.appetite = appetite;
        this.full = full;
    }

    public void eat(Plate p) {
        p.decreaseFood(appetite);
        if ( (full -appetite) < 0) {
            full = 0;
            System.out.println(this.name + " полностью сытый. Больше кушать не хочет!");
        }
        else {
            full -= appetite;
            System.out.println(this.name + " сытый на " + full + "%");
        }
    }

    public boolean isFulled() {
        return full <= 0;
    }
}