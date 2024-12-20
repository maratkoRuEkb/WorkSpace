/*
Задание 36 - ВЫПОЛНЕНО
Напишите программу на Java, чтобы вычислить расстояние между двумя точками на поверхности земли.
Расстояние между двумя точками [(x1, y1) & (x2, y2)]
d = радиус * arccos (sin (x1) * sin (x2) + cos (x1) * cos (x2) * cos (y1 - y2)) //оказывается надо градусы в радианы переводить
Радиус земли r = 6371.01 Километров

Входные данные:
Введите широту координаты 1: 25
Введите долготу координаты 1: 35
Введите широту координаты 2: 35,5
Введите долготу координаты 2: 25,5
Ожидаемый результат

 Расстояние между этими точками: 1480.0848451069087 км
 */

import java.util.Scanner;

public class Zadanie36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите широту координаты 1: ");//25
        double location_X1 = scanner.nextDouble();
        System.out.println("Введите долготу координаты 1: ");//35
        double location_Y1 = scanner.nextDouble();

        System.out.println("Введите широту координаты 2: ");//35.5
        double location_X2 = scanner.nextDouble();
        System.out.println("Введите долготу координаты 2: ");//25.5
        double location_Y2 = scanner.nextDouble();

        double distance = calculate(location_X1, location_Y1, location_X2, location_Y2);

        System.out.println("Расстояние между этими точками: " + distance);


    }//end main

    private static double calculate (double x1, double y1, double x2, double y2){
        double radius = 6371.01;
        double Rx1 = Math.toRadians(x1); //оказывается надо градусы в радианы переводить
        double Ry1 = Math.toRadians(y1);
        double Rx2 = Math.toRadians(x2);
        double Ry2 = Math.toRadians(y2);
        double value = radius * Math.acos(Math.sin(Rx1) * Math.sin(Rx2) + Math.cos(Rx1) * Math.cos(Rx2) * Math.cos(Ry1 - Ry2));
        return value;

    }//end calculate
}
