import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();

        StepTracker stepTracker = new StepTracker();
        Converter converter = new Converter();

        while (true) {

            // Команда ввода данных о количестве пройденных шагов
            if (userInput == 1) {
                System.out.println("Введите количество шагов за определённый день");
                System.out.println("Введите месяц");
                int month = scanner.nextInt();
                System.out.println("Введите день");
                int day = scanner.nextInt();
                System.out.println("Введите количество шагов");
                int step = scanner.nextInt();

                stepTracker.saveSteps(month, day, step);

                printMenu();
                userInput = scanner.nextInt();

                // Команда вывода статистики за определённый месяц
            } else if (userInput == 2) {
                System.out.println("Статистика за определённый месяц");
                System.out.println("Введите месяц");
                int month = scanner.nextInt();

                stepTracker.printAllSteps(month);             // Статистика шагов за месяц
                System.out.println("");
                int sum = stepTracker.printSumSteps(month);   // Сумма шагов за месяц
                stepTracker.printMediumSteps(month);          // Среднее кол-во шагов за месяц
                stepTracker.printMaxSteps(month);             // Максимальное кол-во шагов в месяце
                stepTracker.printBeastSeries(month);          // Лучшая серия шагов
                converter.convert(sum);                       // Конвертация шагов в км и ккал

                printMenu();
                userInput = scanner.nextInt();

                // Команда ввода цели по количеству шагов в день
            } else if (userInput == 3) {
                System.out.println("Измените цель по количеству шагов в день");
                int steps = scanner.nextInt();
                stepTracker.targetStep(steps);

                printMenu();
                userInput = scanner.nextInt();

                // Команда выхода из приложения
            } else if (userInput == 0) {
                System.out.println("Программа завершена");
                break;

                // Сообщение для некорректной команды
            } else {
                System.out.println("Извините, такой команды пока нет.");

                printMenu();
                userInput = scanner.nextInt();
            }
        }
    }


    // Меню для управления программой
    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}