package ru.bmixdev;

import ru.bmixdev.model.Animal;
import ru.bmixdev.model.Cat;
import ru.bmixdev.model.Dog;

import java.util.*;

public class Lesson06 {

    private final static int maxRun = 1000;
    private final static int maxJump = 3;
    private final static int maxSwim = 20;

    private final static int cntAnimals = 10;

    public static void main(String[] args) {

        String[] animalNames = new String[]{"Лаки", "Лиза", "Люся", "Лилу", "Ляля", "Линда", "Лекси", "Люська", "Ласка", "Луна", "Лапка", "Ли-Ли", "Лана", "Лиса", "Лола", "Леся", "Лекса", "Люси", "Лили", "Лапуся", "Лея", "Лила", "Лисса", "Лаура", "Лизка", "Леля", "Лика", "Лапочка", "Лада", "Леста", "Лина", "Леди", "Лия", "Лайза", "Лора", "Лилия", "Лиля", "Луша", "Локки", "Лу-лу", "Лялька", "Лайли", "Лапа", "Лиска", "Листвичка", "Лоя", "Лулу", "Лэсси", "Лаванда", "Лизи", "Лира", "Ланочка", "Лилит", "Люсия", "Люсьена", "Лютик", "Лайма", "Ланесса", "Лара", "Лила", "Лакомка", "Луиза", "Лило", "Ля Мур", "Лайла", "Лики", "Лисенок", "Лесси", "Лэйси", "Лапуля", "Ларси", "Лиана", "Люсик", "Латифа", "Леська", "Лизетта", "Лисси", "Лэйла", "Люсиль", "Лакоста", "Лейси", "Лети", "Лизавета", "Линси", "Лисичка", "Легенда", "Лиара", "Лилька", "Люсинда", "Люцифия", "Латина", "Лейла", "Лемура", "Леонсия", "Львёна", "Лапуша", "Лапушка", "Леа", "Леди Блэйк", "Лека", "Леонора", "Лима", "Лимка", "Лимонка", "Лакиша", "Ланда", "Латоя"};

        ArrayList<Animal> animals = new ArrayList<>();
        for (int i = 0; i < cntAnimals; i++) {
            if (i%2 == 0)
                animals.add(new Cat(animalNames[Utils.getRandomInt(0, animalNames.length - 1)]));
            else
                animals.add(new Dog(animalNames[Utils.getRandomInt(0, animalNames.length - 1)]));
        }

        for (Animal a: animals) {
            System.out.println("*************************************");
            a.info();
            a.jump(Utils.getRandom(0, maxJump));
            a.run(Utils.getRandom(0, maxJump));
            a.swim(Utils.getRandom(0, maxJump));
            System.out.println("*************************************");
        }
    }
}
