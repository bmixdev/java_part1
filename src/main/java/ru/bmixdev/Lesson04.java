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

    private static int checkDirection(char axis, int x, int y) {
        System.out.format("checkDirection(%c,%d,%d)\n",axis,x,y);
        boolean res = false;
        int curX = x; int curY = y; int score = 0; int direct;
        int scoreTotal = 0;
        int curValue;
        //for (int i = 0; i < 2; i++) {
          //  curX = x;
           // curY = y;
           // direct = i == 0 ? -1 : 1;
            switch (axis) {
                case ('X'): {
                    direct = 1;
                    curY = 0;
                    while (true) {
                        curY += direct;
                        if ((curY < 0) || (curY == arrProgress[curX].length)) break;
                        curValue = arrProgress[curX][curY];
                      //  if (curValue == 0) score = 0;
                      //  else score += curValue;
                        scoreTotal += curValue;
                    }
                    break;
                }
                case ('Y'): {
                    direct = 1;
                    curX = 0;
                    while (true) {
                        curX += direct;
                        if ((curX < 0) || (curX == arrProgress.length)) break;
                        curValue = arrProgress[curX][curY];
                        //if (curValue == 0) score = 0;
                        //else if (score != 0) score += curValue;
                        scoreTotal += curValue;
                    }
                    break;
                }
            }
    //    }
        System.out.printf("scoreTotal: %d\n", scoreTotal);
        return score;
    }

    private static boolean checkWin(int player, int x, int y) {
        int scoreX = checkDirection('X', x, y);
        int scoreY = checkDirection('Y', x, y);
        int scoreToWin = sizeArea < 5 ? sizeArea : 4;
        if (Math.abs(scoreX) == scoreToWin
                || Math.abs(scoreY) == scoreToWin) {
            System.out.printf("Игра окончена. Победил: %s\n", player == 1 ? "Игрок" : "Компьютер" );
            return true;
        }
        return false;
    }

    private static int[] movePlayer() {
        int row;
        while (true) {
            System.out.print("Введите номер строки: ");
            row = scanner.nextInt();
            if (row < arrProgress.length) break;
        }
        int col;
        while (true) {
            System.out.print("Введите номер столбца: ");
            col = scanner.nextInt();
            if (row < arrProgress[row].length) break;
        }
        arrProgress[row-1][col-1] = 1;
        return new int[] {row - 1, col -1};
    }

    private static void loopGame() {
        initGame();
        while (true) {
            int[] movePoint = movePlayer();
            printArea();
            if (checkWin(1, movePoint[0], movePoint[1])) break;
        }
    }

    public static void main(String[] args) {
       loopGame();
    }
}
