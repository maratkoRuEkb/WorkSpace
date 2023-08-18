import java.util.Scanner;

public class Zadanie7 {
    /*
    Задание 7 - ВЫПОЛНЕНО
    Напишите программу на Java, которая принимает число в качестве входных данных и печатает свою таблицу умножения до 10.
    Тестовые данные:
        Введите число: 8
    Ожидаемый результат :
        8 х 1 = 8
        8 х 2 = 16
        8 х 3 = 24
        ...
        8 х 10 = 80
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите число: ");
        int a = console.nextInt();

        for (int i = 1; i < 11; i++) {
            int b = a*i;
            System.out.println(a+" x "+i+" = "+b);
        }

    }

}
