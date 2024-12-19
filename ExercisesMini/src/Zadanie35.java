/*
Задание 35 - ВЫПОЛНЕНО
Напишите программу на Java для вычисления площади многоугольника.
Площадь многоугольника = (n * s ^ 2) / (4 * tan (π / n))  где n - это n-сторонний многоугольник, а s - длина стороны

Входные данные:
Введите количество сторон на многоугольнике: 7
Введите длину одной из сторон: 6
Ожидаемый результат

 Площадь составляет: 130.82084798405722
 */

import java.util.Scanner;

public class Zadanie35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество сторон на многоугольнике: ");
        int side = scanner.nextInt();
        System.out.println("Введите длину одной из сторон: ");
        double lenghtside = scanner.nextDouble();

        double area = solve(side, lenghtside);

        System.out.println("Площадь составляет: " + area);
    }

    private static double solve (int n, double s){
        double top = n * Math.pow(s,2);
        double down = 4 * Math.tan(Math.PI/n);
        return top/down;
    }


}
