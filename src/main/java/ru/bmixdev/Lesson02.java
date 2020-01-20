package ru.bmixdev;

import java.util.Scanner;

public class Lesson02 {

    private static void printArray(int[] ints) {
        System.out.print("\t[");
        for (int i =0; i <= ints.length-1; i++) System.out.print(ints[i] + (i < ints.length - 1 ? "," : "") );
        System.out.print("]\n");
    }

    private static void printArray(int[] ints,  int markIndex) {
        System.out.print("\t[");
        for (int i =0; i <= ints.length-1; i++) System.out.print((i == markIndex ? "||" : "") + ints[i] + (i < ints.length - 1 ? "," : "") );
        System.out.print("]\n");
    }

    private static void printArray(int[][] ints) {

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                if (j == 0) System.out.print("\t[");
                System.out.print(ints[i][j] + (j < ints[i].length - 1 ? ", " : ""));
            }
            System.out.print("]\n");
        }
    }


    private static int[] inputArray() {
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

    private static int getRandomInt(int min, int max) {
        return (int)(Math.random()*((max-min)+1))+min;
    }

    private static int[] generateArray(int size) {
        int[] ints = new int[size];
        for (int i = 0; i < ints.length; i++)
            ints[i] = getRandomInt(-100, 100);
        return ints;
    }

    public static void example21Inver() {
        int[] ints = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i =0; i <= ints.length-1; i++) ints[i] = ints[i] == 1 ? 0 : 1;
        printArray(ints);
    }

    public static void example22Array8() {
        int[] ints = new int[8];
        for (int i = 0; i < ints.length ; i++) ints[i] = i*3;
        printArray(ints);
    }

    public static void example22ArrayMulti6() {
        int[] ints = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("\tисходный массив");
        printArray(ints);
        for (int i = 0; i < ints.length ; i++) {
            if (ints[i] < 6) ints[i] = ints[i]*2;
        }
        System.out.println("\tрезультирующий массив");
        printArray(ints);
    }

    private static void example24() {
        int[][] ints = new int [5][5];
        for (int i = 0; i < ints.length; i++)
            for (int j = 0; j < ints[i].length; j ++)
                ints[i][j] = i == j ? 1 : 0;
        printArray(ints);
    }

    private static void example25() {
        int[] arr = generateArray(10);
        printArray(arr);
        int min = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        System.out.printf("\tМинимальное значение: %s\n", min);
        System.out.printf("\tМаксимальное значение: %s\n", max);
    }

    private static boolean checkBalance(int[] srcArray, int indCenter) {
        int sum = 0;
        for (int i = 0; i < srcArray.length; i++)
            sum += (i < indCenter ? 1 : -1) * srcArray[i];
        return sum == 0;
    }

    private static void example26() {
        System.out.println("\tМассив случайных чисел:");
        int[] arr = generateArray(10);
        int centerIndex = 8;
        printArray(arr, centerIndex);
        System.out.printf("\tcheckBalance: %s\n", checkBalance(arr, centerIndex));

        System.out.println("Массив введенный пользователем:");
        arr = inputArray();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс середины массива:");
        centerIndex = scanner.nextInt() - 1;
        printArray(arr, centerIndex);
        System.out.printf("\tcheckBalance: %s\n", checkBalance(arr, centerIndex));
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

    private static void example27() {
        boolean retry = true;
        while (retry) {
            int[] ints = generateArray(getRandomInt(3, 5));
            System.out.println("Исходный массив: ");
            printArray(ints);
            System.out.print("Введите значение сдвига: ");
            Scanner scanner = new Scanner(System.in);
            int shift = scanner.nextInt();
            int[] newInts = shiftArray(ints, shift);
            System.out.println("Результирующий массив: ");
            printArray(newInts);
            while (true) {
                System.out.print("Выполнить еще раз?(y/n): ");
                String userInput = scanner.next().toUpperCase();
                if (userInput != null && (userInput.equals("Y") || userInput.equals("N"))){
                    retry = userInput.equals("Y");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
        1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
         */
        System.out.println("задание 2.1");
        example21Inver();
        /*
        2. Задать пустой целочисленный массив размером 8.
        С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
         */
        System.out.println("задание 2.2");
        example22Array8();
        /*
        3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
         */
        System.out.println("задание 2.3");
        example22ArrayMulti6();
        /*
        4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
         и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
         */
        System.out.println("задание 2.4");
        example24();
        /*
        5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
         */
        System.out.println("задание 2.5");
        example25();
        /*
        6. ** Написать метод, в который передается не пустой одномерный целочисленный массив,
         метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
          Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true,
           checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
         */
        System.out.println("задание 2.6");
        example26();
        /*
        7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
         при этом метод должен сместить все элементымассива на n позиций.
          Для усложнения задачи нельзя пользоваться вспомогательными массивами.
         */
        System.out.println("задание 2.7");
        example27();
    }
}
