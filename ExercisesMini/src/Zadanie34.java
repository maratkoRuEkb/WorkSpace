/*
Задание 34 - ВЫПОЛНЕНО
Напишите программу на Java для вычисления площади шестиугольника.
Площадь шестиугольника = (6 * s ^ 2) / (4 * tan (π / 6)),  где s - длина стороны

Входные данные:
Введите длину стороны шестиугольника: 6
Ожидаемый результат

 Площадь шестиугольника: 93.53074360871938
 */

import java.util.Scanner;

public class Zadanie34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину стороны шестиугольника: ");
        double lenghtside= scanner.nextDouble();
        double area = solve(lenghtside);
        double area2 = solve2(lenghtside);
        System.out.println("Площадь шестиугольника вариант 1: "  + area);
        System.out.println("Площадь шестиугольника вариант 2: "  + area2);

    }

    private static double solve2(double lenghtside) { // по второй формуле (3 * √3 * s^2) / 2
        double top = 3 * Math.sqrt(3) * Math.pow(lenghtside, 2);
        return top / 2;
    }

    private static double solve(double lenghtside) {
        double top = 6 * Math.pow(lenghtside, 2);
        double down = 4 * Math.tan(Math.PI/6);
        return top / down;
    }//end solve
}
