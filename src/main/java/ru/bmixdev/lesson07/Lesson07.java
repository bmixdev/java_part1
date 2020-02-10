package ru.bmixdev.lesson07;

import ru.bmixdev.Utils;
import ru.bmixdev.model.Animal;

import java.util.ArrayList;
import java.util.Random;

public class Lesson07 {
        public static void main(String[] args) {

            String[] catsName = new String[]{"Лаки", "Лиза", "Люся", "Лилу", "Ляля", "Линда", "Лекси", "Люська", "Ласка", "Луна", "Лапка", "Ли-Ли", "Лана", "Лиса", "Лола", "Леся", "Лекса", "Люси", "Лили", "Лапуся", "Лея", "Лила", "Лисса", "Лаура", "Лизка", "Леля", "Лика", "Лапочка", "Лада", "Леста", "Лина", "Леди", "Лия", "Лайза", "Лора", "Лилия", "Лиля", "Луша", "Локки", "Лу-лу", "Лялька", "Лайли", "Лапа", "Лиска", "Листвичка", "Лоя", "Лулу", "Лэсси", "Лаванда", "Лизи", "Лира", "Ланочка", "Лилит", "Люсия", "Люсьена", "Лютик", "Лайма", "Ланесса", "Лара", "Лила", "Лакомка", "Луиза", "Лило", "Ля Мур", "Лайла", "Лики", "Лисенок", "Лесси", "Лэйси", "Лапуля", "Ларси", "Лиана", "Люсик", "Латифа", "Леська", "Лизетта", "Лисси", "Лэйла", "Люсиль", "Лакоста", "Лейси", "Лети", "Лизавета", "Линси", "Лисичка", "Легенда", "Лиара", "Лилька", "Люсинда", "Люцифия", "Латина", "Лейла", "Лемура", "Леонсия", "Львёна", "Лапуша", "Лапушка", "Леа", "Леди Блэйк", "Лека", "Леонора", "Лима", "Лимка", "Лимонка", "Лакиша", "Ланда", "Латоя"};
            ArrayList<Cat> cats = new ArrayList<Cat>();
            ArrayList<Plate> plats = new ArrayList<Plate>();
            System.out.println();
            System.out.println("### Cоздадим 5 котов и 5 тарелок:");
            System.out.println();
            for (int i = 0; i < 6; i++) {
                cats.add(new Cat(catsName[Utils.getRandomInt(0, catsName.length - 1)], Utils.getRandomInt(0, 110)));
                plats.add(new Plate(Utils.getRandomInt(0, 100)));
            }
            System.out.println();
            System.out.println("### Покормим котов в случайном порядке:");
            System.out.println();
            for (Cat cat: cats) {
                System.out.printf("Кормлю котика %s\n\t", cat.getName() +  "( " + cat + " )");
                cat.eat(plats.get(Utils.getRandomInt(0, plats.size() - 1)));
            }
            System.out.println();
            System.out.println("### Посмотрим сколько осталось еды в тарелках и добавим еды:");
            System.out.println();
            for (Plate plate: plats) {
                plate.info();
                plate.addFood(Utils.getRandomInt(1, 50));
            }

            System.out.println();
            System.out.println("### Покормим котов еще раз в случайном порядке:");
            System.out.println();
            for (Cat cat: cats) {
                System.out.printf("Кормлю котика %s\n\t", cat.getName() +  "( " + cat + " )");
                cat.eat(plats.get(Utils.getRandomInt(0, plats.size() - 1)));
            }

        }
}
