public class Zadanie13 {
    /*
    Задание 13 - ВЫПОЛНЕНО
    Напишите Java-программу для печати площади и периметра прямоугольника. Перейти к редактору
Тестовые данные:
Ширина = 5,6 Высота = 8,5

Ожидаемый результат
Площадь 5,6 * 8,5 = 47,60
Периметр 2 * (5,6 + 8,5) = 28,20
     */
    public static void main(String[] args) {
        float height = 5.6f;
        double width = 8.5;

        double area = height * width;
        float perimeter = (float) ((height+width)*2);

        System.out.println("Площадь = "+ area);
        System.out.println("Периметр = "+ perimeter);

        System.out.print("Площадь (с мои форматированием)= ");
        System.out.printf("%.2f\n\n",area);// вывод с форматированием


        System.out.println("Совсем по замороченному");
        System.out.printf("Perimeter is 2*(%.1f + %.1f) = %.2f \n", height, width, perimeter);
        System.out.printf("Area is %.1f * %.1f = %.2f \n", width, height, area);
    }
}
