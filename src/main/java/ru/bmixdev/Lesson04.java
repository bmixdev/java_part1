package ru.bmixdev;

import java.io.IOException;
import java.util.Scanner;

public class Lesson04 {

    private static int[][] arrProgress;
    private static int sizeArea = 3;
    private static Scanner scanner;
    private static StringBuilder sb;

    public static void initGame() {
        scanner = new Scanner(System.in);
        sb = new StringBuilder();
        System.out.print("Введите размер игрового поля:");
        sizeArea = scanner.nextInt();
        arrProgress = new int[sizeArea][sizeArea];
        printArea();
    }

    public static void printSeparator() {
        sb.append("+");
        for (int i = 0; i < sizeArea; i++)
            sb.append("---+");
        sb.append("\n");
    }

    private static char printSymbol(int value) {
        return value == 0 ? ' ' : (value == 1 ? 'X' : '0');
    }

    public static void printAscii() {
        for (int i = 2500; i < 2600; i++) {
            if (i % 20 == 0) System.out.println();
            System.out.format(" %4s: %s", i, String.valueOf((char)i));
        }
    }

    public static void printArea() {

       // aat.setBorderCharacters("┏━┯┓┃┠─┬┨┿┣┫│┗┷┛┼");

        sb.setLength(0);
        for (int row = 0; row < arrProgress.length; row++) {
            printSeparator();
            sb.append("|");
            for (int col = 0; col < arrProgress[row].length; col++) {
                sb.append(String.format(" %s |", printSymbol(arrProgress[row][col])));
            }
            sb.append("\n");
        }
        printSeparator();
        System.out.println(sb);
    }

    private static void movePlayer() {
        System.out.print("Введите номер строки: "); int row = scanner.nextInt();
        System.out.print("Введите номер столбца: "); int col = scanner.nextInt();
        arrProgress[row-1][col-1] = 1;
    }


    public static void main(String[] args) {
        initGame();
      //  printAscii();
        movePlayer();

        printArea();

    }
}
