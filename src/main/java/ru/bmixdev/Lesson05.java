package ru.bmixdev;

import ru.bmixdev.model.Employee;

import java.util.Scanner;

public class Lesson05 {

    private static void printTableEmployees(Employee[] employees, int largeAge) {

        StringBuilder sb = new StringBuilder();
        if (largeAge == 0)
            sb.append("\nСписок всех сотрудников:\n\n");
        else
            sb.append(String.format("\nСписок сотрудников старше %s лет:\n\n", largeAge));

        sb.append(ConsoleColors.BLACK +""+ConsoleColors.WHITE_BACKGROUND).append(String.format("+-%20c-+-%20c-+-%20c-+-%10c-+-%20c-+-%10c-+-%20c-+", ' ',' ',' ',' ',' ',' ', ' ', ' ').replace(' ','-')).append(ConsoleColors.RESET).append('\n');

        sb.append(ConsoleColors.BLACK +""+ConsoleColors.WHITE_BACKGROUND).append(String.format("| %20s | %20s | %20s | %10s | %20s | %10s | %20s |", "Фамилия", "Имя", "Отчество", "Должность", "EMAIL", "Возраст", "Зарплата")).append(ConsoleColors.RESET).append('\n');
        sb.append(ConsoleColors.BLACK +""+ConsoleColors.WHITE_BACKGROUND).append(String.format("+-%20c-+-%20c-+-%20c-+-%10c-+-%20c-+-%10c-+-%20c-+", ' ',' ',' ',' ',' ',' ', ' ', ' ').replace(' ','-')).append(ConsoleColors.RESET).append('\n');

        int cntRec = 0;
        for (Employee e: employees) {
            if (e.getAge() > largeAge) {
                if (cntRec % 2 == 1)
                    sb.append(ConsoleColors.BLACK +""+ConsoleColors.WHITE_BACKGROUND);
                sb.append(String.format("| %20s | %20s | %20s | %10s | %20s | %10s | %20.2f |", e.getFirstName(), e.getMiddleName(), e.getLastName(), e.getPosition(), e.getEmail(), e.getAge(), e.getSalary()));
                if (cntRec % 2 == 1)
                    sb.append(ConsoleColors.RESET);
                sb.append('\n');
                cntRec++;
            }
        }

        sb.append(String.format("+-%20c-+-%20c-+-%20c-+-%10c-+-%20c-+-%10c-+-%20c-+", ' ',' ',' ',' ',' ',' ', ' ', ' ').replace(' ','-')).append('\n');
        sb.append(ConsoleColors.GREEN_BOLD).append(String.format("Кол-во записей: %s", cntRec)).append(ConsoleColors.RESET).append('\n');

        System.out.print(sb);
    }

    public static void main(String[] args) {
         String[] arrayFirstName = new String[]{"Иванов", "Петров", "Сидоров", "Спичкин", "Козловский", "Осминог"};
         String[] arrayMiddleName = new String[]{"Михаил", "Иван", "Сергей", "Павел", "Владимир", "Андрей"};
         String[] arrayLastName = new String[]{"Иванович", "Михайлович", "Сергеевич", "Олегович", "Дмитриевич"};
         String[] arrayPosition = new String[]{"дворник", "кассир", "менеджер", "директор", "врач", "водитель"};

        Scanner scanner = new Scanner(System.in);
        int sizeEmployees = 0;
        System.out.print("Введите кол-во сотрудников:"); sizeEmployees = scanner.nextInt();

        Employee[] employees = new Employee[sizeEmployees];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(arrayLastName[Utils.getRandomInt(0, arrayLastName.length - 1)],
                    arrayMiddleName[Utils.getRandomInt(0, arrayMiddleName.length-1)],
                    arrayFirstName[Utils.getRandomInt(0, arrayMiddleName.length-1)],
                    arrayPosition[Utils.getRandomInt(0, arrayPosition.length-1)],
                    "email_"+Utils.getRandomInt(0, 1000)+"@gmail.com",
                    Utils.getRandomInt(18, 80),
                    Utils.getRandom(1000, 1000000));
        }
        // список всех сотрудников
        printTableEmployees(employees,0);
        // список сотрудников старше 40 лет
        printTableEmployees(employees,40);

    }
}
