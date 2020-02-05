package ru.bmixdev.lesson07;

public class Lesson07 {
        public static void main(String[] args) {
            Cat cat = new Cat("Barsik", 105, 200);
            Plate plate = new Plate(100);
            plate.info();
            cat.eat(plate);
            plate.info();
        }
}
