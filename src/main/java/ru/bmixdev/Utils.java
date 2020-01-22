package ru.bmixdev;

import java.util.Scanner;

public class Utils {

    public static int getRandomInt(int min, int max) {
        return (int)(Math.random()*((max-min)+1))+min;
    }

    public static int[] generateArray(int size) {
        int[] ints = new int[size];
        for (int i = 0; i < ints.length; i++)
            ints[i] = getRandomInt(-100, 100);
        return ints;
    }

    public static void printArray(int[] ints) {
        System.out.print("\t[");
        for (int i =0; i <= ints.length-1; i++) System.out.print(ints[i] + (i < ints.length - 1 ? "," : "") );
        System.out.print("]\n");
    }

    public static void printArray(int[] ints,  int markIndex) {
        System.out.print("\t[");
        for (int i =0; i <= ints.length-1; i++) System.out.print((i == markIndex ? "||" : "") + ints[i] + (i < ints.length - 1 ? "," : "") );
        System.out.print("]\n");
    }

    public static void printArray(int[][] ints) {

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (j == 0) System.out.print("\t[");
                System.out.print(ints[i][j] + (j < ints[i].length - 1 ? ", " : ""));
            }
            System.out.print("]\n");
        }
    }

    public static int[] inputArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размерность массива: ");
        int n = scanner.nextInt();
        int[] resArray = new int[n];
        for (int i = 0; i < resArray.length; i++) {
            System.out.println("Введите число:");
            resArray[i] = scanner.nextInt();
        }
        return resArray;
    }

    // Сдвинуть массив, новые позиции добиваются нулями
    public static int[] shiftArray(int[] srcArray, int shift) {
        int absShift = Math.abs(shift);
        int[] newInts = new int[srcArray.length + absShift];
        int cnt = newInts.length;
        while (--cnt >= 0) {
            if (shift >= 0)
                if (cnt >= absShift) newInts[cnt] = srcArray[cnt - absShift];
                else newInts[cnt] = 0;
            else
            if (cnt >= srcArray.length) newInts[cnt] = 0;
            else newInts[cnt] = srcArray[cnt];
        }
        return newInts;
    }

}
