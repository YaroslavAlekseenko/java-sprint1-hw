public class Converter {

    // Коэффициенты конвертации шагов
    double distance = 0.00075;
    double kilocalorie = 0.05;

    // Конвертация шагов за месяц в км
    double distanceConvert(int sum) {
        double kmConvert = sum * distance;
        return kmConvert;
    }

    // Конвертация шагов за месяц в ккал
    double kilocalorieConvert(int sum) {
        double kcalConvert = sum * kilocalorie;
        return kcalConvert;
    }

    // Вывод км
    void printDistanceConvert(int sum) {
        System.out.println("Дистанция в километрах: " + distanceConvert(sum));
    }

    // Вывод ккал
    void printKilocalorieConvert(int sum) {
        System.out.println("Количество сожжённых килокалорий: " + kilocalorieConvert(sum));
    }

}
