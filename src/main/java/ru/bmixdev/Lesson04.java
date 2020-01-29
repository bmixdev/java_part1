package ru.bmixdev;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static ru.bmixdev.ConsoleColors.*;
import static ru.bmixdev.Utils.ANSI_RESET;

public class Lesson04 {

    private static int[][] arrProgress;
    private static int[][] winArray;
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
        winArray = new int[scoreToWin][2];
        printArea(false);
    }

    public static void printSeparator() {
        sb.append("-----+");
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

    public static void printArea(boolean isWin) {
        sb.setLength(0);
        // Шапка
        sb.append(" y/x |");
        for (int row = 0; row < arrProgress.length; row++)
            sb.append(" ").append(PURPLE).append((row + 1)).append(RESET).append(" |");
        sb.append("\n");

        for (int row = 0; row < arrProgress.length; row++) {
            printSeparator();
            sb.append("  " + PURPLE + (row+1) + RESET + "  |");
            for (int col = 0; col < arrProgress[row].length; col++) {
                if (isWin) {
                    boolean printed = false;
                    for (int i = 0; i < winArray.length; i++) {
                        if (winArray[i][0] != -1 && winArray[i][1] != -1 && winArray[i][0] == row && winArray[i][1] == col) {
                            sb.append(" ").append(GREEN_BOLD).append(printSymbol(arrProgress[row][col])).append(RESET).append(" |");
                            printed = true;
                        }
                    }
                    if (!printed) sb.append(String.format(" %s |", printSymbol(arrProgress[row][col])));
                }
                else sb.append(String.format(" %s |", printSymbol(arrProgress[row][col])));
            }
            sb.append("\n");
        }
        printSeparator();
        System.out.println(sb);
    }

    private static void clearWinArray() {
        for (int i = 0; i < winArray.length; i++)
            for (int j = 0; j < winArray[i].length; j++) {
                winArray[i][j] = -1;

            }
    }

    private static void addToWin(int idx, int x, int y) {
        winArray[idx][0] = x;
        winArray[idx][1] = y;
    }

    private static boolean checkDirection(int player, char axis, int x, int y) {
        d(String.format("checkDirection(%c,%d,%d)\n",axis,x,y));
        boolean res = false;
        boolean storeScore = true;
        int curX = x; int curY = y; int score = 0; int direct = 1;
        int scoreTotal = 0;
        int curValue;
        clearWinArray();
        switch (axis) {
                case ('X'): {
                    curY = 0;
                    while (true) {
                        if ((curY < 0) || (curY == arrProgress[curX].length)) break;
                        curValue = arrProgress[curX][curY];
                        if (curValue != player ) {
                            score = 0;
                            clearWinArray();
                        }
                        addToWin(Math.abs(score), curX, curY);
                        score += curValue;
                        scoreTotal += curValue;
                        curY += direct;
                        if (Math.abs(score) == scoreToWin) return true;
                    }
                    break;
                }
                case ('Y'): {
                    curX = 0;
                    while (true) {
                        if ((curX < 0) || (curX == arrProgress.length)) break;
                        curValue = arrProgress[curX][curY];
                        if (curValue != player ) {
                            score = 0;
                            clearWinArray();
                        }
                        addToWin(Math.abs(score), curX, curY);
                        score += curValue;
                        scoreTotal += curValue;
                        curX += direct;
                        if (Math.abs(score) == scoreToWin) return true;
                    }
                    break;
                }
                case ('D'): {
                    // проверка диагонали слева направо
                    curX = x; curY = y; score = 0; scoreTotal = 0;
                    while (curX > 0  && curY > 0) {
                        curX--; curY--;
                    }
                    while ((curX != arrProgress.length) && (curY != arrProgress[curX].length)) {
                        curValue = arrProgress[curX][curY];
                        if (curValue != player ) {
                            score = 0;
                            clearWinArray();
                        }
                        addToWin(Math.abs(score), curX, curY);
                        score += curValue;
                        scoreTotal += curValue;
                        if (Math.abs(score) == scoreToWin) return true;
                        curX++; curY++;
                    }
                    // проверка диагонали справа налево
                    curX = x; curY = y; score = 0; scoreTotal = 0;
                    while (curX > 0 && curY < arrProgress[curX].length - 1) {
                        curX--; curY++ ;
                    }
                    while ((curX != arrProgress.length) && (curY != 0)) {
                        curValue = arrProgress[curX][curY];
                        if (curValue != player ) {
                            score = 0;
                            clearWinArray();
                        }
                        addToWin(Math.abs(score), curX, curY);
                        score += curValue;
                        scoreTotal += curValue;
                        if (Math.abs(score) == scoreToWin) return true;
                        curX++; curY--;
                    }
                    break;
                }
        }
        d(String.format("score: %d scoreTotal: %d\n", score,  scoreTotal));
        return false;
    }

    private static boolean checkWin(int player, int x, int y) {
        boolean winToX = false;  boolean winToY = false; boolean winToD = false;
        winToX = checkDirection(player, 'X', x, y);
        if (!winToX) {
            winToY = checkDirection(player, 'Y', x, y);
            if (!winToY)
                winToD = checkDirection(player,'D', x, y);
        }

        if (winToX || winToY || winToD) {
            System.out.printf("Игра окончена. Победил: %s\n" + RESET, player == 1 ? GREEN_UNDERLINED + "Игрок" : RED_UNDERLINED + "Компьютер" );
            printArea(true);
            return true;
        }
        return false;
    }

    private static int[] moveComputer() {
        int row;
        int col;
        do {
           row = Utils.getRandomInt(0, arrProgress.length - 1);
           col = Utils.getRandomInt(0, arrProgress.length - 1);
        } while ( arrProgress[row][col]  != 0 );
        arrProgress[row][col] = -1;
        return new int[] {row, col};
    }

    private static int[] movePlayer() {
        int row;
        int col;
        do {
            while (true) {
                System.out.print("Введите номер строки: ");
                row = scanner.nextInt()-1;
                if (row < arrProgress.length) break;
            }

            while (true) {
                System.out.print("Введите номер столбца: ");
                col = scanner.nextInt() - 1;
                if (col < arrProgress[row].length) break;
            }
        } while ( arrProgress[row][col]  != 0 );
        arrProgress[row][col] = 1;
        return new int[] {row, col};
    }

    //проверка на ничью
    public static boolean checkToDraw() {
        for (int i = 0; i < arrProgress.length; i++) {
            for (int j = 0; j < arrProgress[i].length; j++) {
                if (arrProgress[i][j] == 0) return false;
            }
        }
        return true;
    }

    private static void loopGame() {
        initGame();
        while (true) {
            // ход игрока
            int[] movePointPlayer = movePlayer();

            printArea(false);
            if (checkWin(1, movePointPlayer[0], movePointPlayer[1])) break;

            // ход компьютера
            int[] movePointComputer = moveComputer();
            printArea(false);
            if (checkWin(-1, movePointComputer[0], movePointComputer[1])) break;

            if (checkToDraw()) {
                System.out.println("Игра окончена - "+PURPLE_BOLD_BRIGHT+"Ничья"+RESET);
                break;
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            loopGame();
            System.out.print("Повторить (0-нет/1-да)? ");
            int retry = scanner.nextInt();
            if (retry == 0) break;
        }
    }
}
