import jdk.jshell.Snippet;

import java.util.Arrays;
import java.util.Scanner;

public class Zadanie12 {
    /*
    Задание 12 - ВЫПОЛНЕНО
    Напишите программу на Java, которая принимает три числа в качестве входных данных для вычисления и печати среднего числа.
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите первое число");
        int first = console.nextInt();

        System.out.println("Введите второе число");
        int second = console.nextInt();

        System.out.println("Введите третье число");
        int third = console.nextInt();

        int[] numbers = new int[] {first, second,third};
        Arrays.sort(numbers);
        System.out.print("Среднее число: ");
        System.out.println(numbers[1]);

        System.out.println("Среднее арифметическое = "+(first+second+third)/3);
    }
}
