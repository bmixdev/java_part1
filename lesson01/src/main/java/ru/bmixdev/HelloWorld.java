package ru.bmixdev;
//GIT отпочковал ветку lesson01

public class HelloWorld {

    private static int getValueABCD(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    private static boolean isSumIncludeRange1020(int a, int b) {
        return 10 <= (a + b) && (a + b) <=20;
    }

    private static void printPoisiveNegative(int a) {
        if (a >= 0) System.out.println("    Передано положительное число");
        else System.out.println("   Передано отрицательное число");
    }

    private static boolean isNegative(int a) {
        return a < 0;
    }

    private static void helloUser(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void checkYear(int year) {
        boolean isLeap = ((year % 4 == 0) & (year % 100 != 0)) || (year % 400 == 0) ;
        System.out.println(year + ": " + (isLeap ? "" : "не ") + "високосный");
    }

    public static void main(String[] args) {
        // lesson 1.2
        byte byteVal = 1;
        short shortVal = 2;
        int intVal = 3;
        long longVal = 4;
        float floatVal = 11.11f;
        double doubleVal = 11.11;
        char charVal = 'A';
        boolean boolVal = true;
        // lesson 1.3
        System.out.println("getValueABCD: " + getValueABCD(1, 2, 3, 4));
        // lesson 1.4
        System.out.println("isSumIncludeRange1020(10,5): " + isSumIncludeRange1020(10, 5));
        System.out.println("isSumIncludeRange1020(10,15): " + isSumIncludeRange1020(10, 15));
        // lesson 1.5
        System.out.println("printPoisiveNegative(5):");
        printPoisiveNegative(5);
        System.out.println("printPoisiveNegative(-2):");
        printPoisiveNegative(-2);
        // lesson 1.6
        System.out.println("isNegative(2): " + isNegative(2));
        System.out.println("isNegative(-1): " + isNegative(-1));
        // lesson 1.7
        helloUser("Вася");
        // lesson 1.8
        for (int i = 1600; i<=2400; i = i + 1)
            checkYear(i);
    }
}
