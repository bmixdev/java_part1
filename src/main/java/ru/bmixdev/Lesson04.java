package ru.bmixdev;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Lesson04 {

    private static int[][] arrProgress;
    private static int sizeArea = 3;
    private static Scanner scanner;
    private static StringBuilder sb;
    private static boolean showDebug = false;
    private static int scoreToWin;

    public static void d(String message) {
        if (showDebug)
            System.out.println(message);
    }

    public static void initGame() {
        scanner = new Scanner(System.in);
        sb = new StringBuilder();
        System.out.print("Введите размер игрового поля:");
        sizeArea = scanner.nextInt();
        arrProgress = new int[sizeArea][sizeArea];
        scoreToWin = sizeArea < 5 ? sizeArea : 4;
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

    private static boolean checkDirection(char axis, int x, int y) {
        d(String.format("checkDirection(%c,%d,%d)\n",axis,x,y));
        boolean res = false;
        boolean storeScore = true;
        int curX = x; int curY = y; int score = 0; int direct = 1;
        int scoreTotal = 0;
        int curValue;
            switch (axis) {
                case ('X'): {
                    curY = 0;
                    while (true) {
                        if ((curY < 0) || (curY == arrProgress[curX].length)) break;
                        curValue = arrProgress[curX][curY];
                        if (curValue == 0) {
                        //    storeScore = false;
                            score = 0;
                        }
                       //if (storeScore)
                        score += curValue;
                        scoreTotal += curValue;
                        curY += direct;
                        if (score == scoreToWin) return true;
                    }
                    break;
                }
                case ('Y'): {
                    curX = 0;
                    while (true) {
                        if ((curX < 0) || (curX == arrProgress.length)) break;
                        curValue = arrProgress[curX][curY];
                        if (curValue == 0) {
                           // storeScore = false;
                            score = 0;
                        }
                        //if (storeScore)
                        score += curValue;
                        scoreTotal += curValue;
                        curX += direct;
                        if (score == scoreToWin) return true;
                    }
                    break;
                }
                case ('D'): {
                    // проверка диагонали слева направо
                    curX = x; curY = y;
                    while (curX > 0  && curY > 0) {
                        curX--; curY--;
                    }
                    while ((curX != arrProgress.length) && (curY != arrProgress[curX].length)) {
                        curValue = arrProgress[curX][curY];
                        if (curValue == 0) score = 0;
                        score += curValue;
                        scoreTotal += curValue;
                        if (score == scoreToWin) return true;
                        curX++; curY++;
                    }
                    // проверка диагонали справа налево
                    curX = x; curY = y;
                    while (curX > 0 && curY < arrProgress[curX].length - 1) {
                        curX--; curY++ ;
                    }
                    while ((curX != arrProgress.length) && (curY != 0)) {
                        curValue = arrProgress[curX][curY];
                        if (curValue == 0) score = 0;
                        score += curValue;
                        scoreTotal += curValue;
                        if (score == scoreToWin) return true;
                        curX++; curY--;
                    }
                    break;
                }
            }
        d(String.format("score: %d scoreTotal: %d\n", score,  scoreTotal));
        return false;
    }

    private static boolean checkWin(int player, int x, int y) {
        boolean winToX = checkDirection('X', x, y);
        boolean winToY = checkDirection('Y', x, y);
        boolean winToD = checkDirection('D', x, y);

        if (winToX || winToY || winToD) {
            System.out.printf("Игра окончена. Победил: %s\n", player == 1 ? "Игрок" : "Компьютер" );
            return true;
        }
        return false;
    }

    private static int[] moveComputer() {
        int row = Utils.getRandomInt(0, arrProgress.length - 1);
        ArrayList cols = new ArrayList();
        for (int col = 0; col < arrProgress[row].length ; col++) {
              if (arrProgress[row][col] == 0) cols.add(col);
        }
        int col = (int) cols.get(Utils.getRandomInt(1, cols.size()));
        arrProgress[row][col] = -1;
        return new int[] {row, col};
    }

    private static int[] movePlayer() {
        int row;
        while (true) {
            System.out.print("Введите номер строки: ");
            row = scanner.nextInt()-1;
            if (row < arrProgress.length) break;
        }
        int col;
        while (true) {
            System.out.print("Введите номер столбца: ");
            col = scanner.nextInt() - 1;
            if (col < arrProgress[row].length) break;
        }
        arrProgress[row][col] = 1;
        return new int[] {row, col};
    }

    private static void loopGame() {
        initGame();
        while (true) {
            // ход игрока
            int[] movePointPlayer = movePlayer();
            printArea();
            if (checkWin(1, movePointPlayer[0], movePointPlayer[1])) break;
            // ход компьютера
            int[] movePointComputer = moveComputer();
            printArea();
            if (checkWin(-1, movePointComputer[0], movePointComputer[1])) break;
        }
    }

    public static void main(String[] args) {
        /*
        int[][] ints = new int[5][5];
        for (int i = 0; i < ints.length; i++)
            for (int j = 0; j < ints[i].length; j ++) {
                if (i == j) {
                    ints[i][j] = 1;
                    ints[ints.length-i-1][j] = 1;
                }
            }
        Utils.printArray(ints);
            */
        while (true) {
            loopGame();
            System.out.print("Повторить (0-нет/1-да)? ");
            int retry = scanner.nextInt();
            if (retry == 0) break;
        }
    }
}
