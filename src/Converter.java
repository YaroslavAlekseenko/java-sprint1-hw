public class Converter {

    // Коэффициенты конвертации шагов
    double distance = 0.00075;
    double kilocalorie = 0.05;

    // Конвертация шагов за месяц в км и ккал
    void convert(int sum) {
        System.out.println("Дистанция в километрах: " + sum * distance);
        System.out.println("Количество сожжённых килокалорий: " + sum * kilocalorie);
    }
}
