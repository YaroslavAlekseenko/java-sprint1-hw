public class StepTracker {
    MonthData[] monthToData;    // Массив месяцев
    int target = 10000;         // Целевое кол-во шагов

    // Массив месяцев
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    // Массив дней
    class MonthData {
        int[] dayToData = new int[30];
    }

    // Ввод данных о количестве пройденных шагов
    int saveSteps(int month, int day, int step) {
        if (step >= 0) {
        this.monthToData[month].dayToData[day-1] = step;
        System.out.println("Значение сохранено! Пройдено шагов за день: " + this.monthToData[month].dayToData[day-1]);
        } else {
        System.out.println("Значение некорректно! Количество шагов должно быть положительным.");
        }
        return this.monthToData[month].dayToData[day-1];
    }

    // Вывод данных о количестве пройденных шагов
    void printAllSteps(int month) {
        int[] dayToData = monthToData[month].dayToData;
        for (int i = 0; i < dayToData.length - 1; i++) {
            System.out.print((i + 1) + " день: " + dayToData[i]+ ", ");
        }
        System.out.print((dayToData.length) + " день: " + dayToData[dayToData.length - 1]);
    }

     // Сумма пройденных шагов за месяц
     int printSumSteps(int month) {
        int sum = 0;
        int[] dayToData = monthToData[month].dayToData;
        for (int i = 0; i < dayToData.length; i++) {
            sum = sum + dayToData[i];
        }
        System.out.println("Общее количество шагов за месяц: " + sum);
        return sum;
    }

    // Среднее кол-во пройденных шагов за месяц
    void printMediumSteps(int month) {
        int sum = 0;
        int medium = 0;
        int[] dayToData = monthToData[month].dayToData;
        for (int i = 0; i < dayToData.length; i++) {
            sum = sum + dayToData[i];
        }
        medium = sum / dayToData.length;
        System.out.println("Среднее количество шагов: " + medium);
    }

    // Максимальное кол-во шагов в месяце
    void printMaxSteps(int month) {
        int maxSteps = 0;
        int[] dayToData = monthToData[month].dayToData;
        for (int i = 0; i < dayToData.length; i++) {
            if (dayToData[i] > maxSteps) {
                maxSteps = dayToData[i];
            }
        }
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
    }

    // Ввод цели по количеству шагов в день
    void targetStep(int steps) {
        if (steps >= 0) {
            this.target = steps;
            System.out.println("Значение сохранено! Целевое количество шагов: " + this.target);
        }
        else {
            System.out.println("Значение некорректно! Целевое количество шагов должно быть положительным.");
        }
    }

    // Подсчёт лучшей серии: максимальное кол-во подряд идущих дней,
    // в течение которых количество шагов за день было равно или выше целевого.
    void printBeastSeries(int month) {
        int[] dayToData = monthToData[month].dayToData;
        int beastSeries = 0;
        int curSeries = 0;

        for (int i = 0; i < dayToData.length; i++) {
            if (dayToData[i] >= this.target) {
                curSeries++;
            } else {
                curSeries = 0;
            }
            if (curSeries > beastSeries) {
                beastSeries = curSeries;
            }
        }
        System.out.println("Лучшая серия: " + beastSeries);
    }

}