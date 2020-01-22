package ru.bmixdev;

import java.util.Scanner;

public class Lesson03 {

    private static void guessNumber() {

        Scanner scanner = new Scanner(System.in);
        boolean retry = true;

        while (retry) {

            int cntTry = 3;
            int curTry = 0;
            int number = Utils.getRandomInt(0, 9);
            boolean isWon = false;

            do {
                curTry++;
                System.out.print("Введите число от 0 до 9: ");
                int userInput = scanner.nextInt();
                if (number == userInput) {
                    System.out.println("Вы угадали с " + curTry + "ой(ей) попытки");
                    isWon = true;
                    break;
                }
                else {
                    System.out.printf("Вы ввели число %s чем загаданное компьютером\n", userInput > number ? "большее" : "меньшее");
                }
            } while (cntTry > curTry);

            if (!isWon) System.out.println("Вы проиграли. Загаданное число: " + number);

            while (true) {
                System.out.print("Повторить игру еще раз?(Д/Н)");
                String userInput = scanner.next().toUpperCase();
                if (userInput != null && (userInput.equals("Д") || userInput.equals("L") || userInput.equals("Н")|| userInput.equals("Y"))) {
                    retry = userInput.equals("Д")||userInput.equals("L");
                    break;
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Задание 3.1");
        guessNumber();
    }
}
