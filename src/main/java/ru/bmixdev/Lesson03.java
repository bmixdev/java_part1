package ru.bmixdev;

import java.util.Scanner;

public class Lesson03 {
/*
1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
 */
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
/*
    2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli"
                                                , "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango"
                                                , "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
    сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано, компьютер показывает буквы которые стоят на своих местах.
        apple – загаданное
        apricot - ответ игрока
        ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
 */
    private static void guessWord() {
        String[] words = new String[] {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli"
                                    , "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango"
                                    , "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String guessWrd = words[Utils.getRandomInt(0, words.length - 1)];
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.setLength(0);
            String userInput = Utils.getUserConsoleInput("Введите слово"+"["+guessWrd+"]"+": ").toLowerCase();
            if (guessWrd.equals(userInput)) {
                System.out.println("Вы угадали!");
                break;
            } else System.out.println("Ответ не верный. Возможные совпадения:");
            for (int i = 0; i < guessWrd.length() - 1; i++) {
                if (i < userInput.length() && guessWrd.charAt(i) == userInput.charAt(i))
                    sb.append(userInput.charAt(i));
                else sb.append('#');
            }
            while (sb.length() < 15) sb.append("#");
            System.out.println(sb);
            System.out.println("Попробуйте еще раз");
        }
    }

    public static void main(String[] args) {
        System.out.println("Задание 3.1");
        guessNumber();
        System.out.println("Задание 3.2");
        guessWord();
    }
}
