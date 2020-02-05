package ru.bmixdev.lesson07;

public class Cat {
    private String name;
    private int appetite;
    private final int sizeFull = 100;
    private int prcFulled;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.prcFulled = 0;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", appetite=" + appetite +
                ", sizeFull=" + sizeFull +
                ", prcFulled=" + prcFulled +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            // если еды достаточно
            if (sizeFull <= (prcFulled + appetite)) {
                prcFulled = sizeFull;
                System.out.println(this.name + " полностью сытый. Больше кушать не хочет!");
            } else {
                prcFulled += appetite;
                System.out.println(this.name + " сытый на " + prcFulled + "%");
            }
        }
    }

    public boolean isFulled() {
        return prcFulled >= sizeFull;
    }
}