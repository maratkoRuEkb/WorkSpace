public class Zadanie11 {
    /*
    Задание 11 - ВЫПОЛНЕНО
Напишите Java-программу для печати области и периметра круга.
Тестовые данные:
Радиус = 7,5
Ожидаемый результат
Периметр = 47.12388980384689
Площадь = 176.71458676442586
     */

    public static void main(String[] args) {
        float rad = 7.5f;

        double perim = 2*Math.PI*rad; //2πR
        double s = Math.PI*Math.pow(rad,2); //πR²

        System.out.println("Периметр = "+perim);
        System.out.println("Площадь = "+s);
    }
}
