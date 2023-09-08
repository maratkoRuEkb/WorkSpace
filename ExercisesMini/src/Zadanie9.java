public class Zadanie9 {
    /*
    Задание 9 - ВЫПОЛНЕНО
    Напишите программу на Java для вычисления указанных выражений и распечатки вывода.
Тестовые данные:
((25,5 * 3,5 - 3,5 * 3,5) / (40,5 - 4,5))
Ожидаемый результат
+2,138888888888889
     */

    public static void main(String[] args) {
    float num1= 25.5f;
    float num2= 3.5f;
    float num3= 40.5f;
    float num4= 4.5f;

    double result = ((num1*num2-num2*num2)/(num3-num4));
        System.out.println(result);
        System.out.println((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5));

    }
}
