/*
Задание 33 - ВЫПОЛНЕНО
Напишите программу на Java и вычислите сумму цифр целого числа. Перейти к редактору
Входные данные:
Введите целое число: 25
Ожидаемый результат

 Сумма цифр: 7
 */

import java.util.Scanner;

public class Zadanie33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        long count = scanner.nextInt();

        System.out.println("Сумма цифр: " + sumDigits(count));
        System.out.println("end");
    }

    private static int sumDigits(long count) { //Остаток от деления на 10 это ЕДИНИЦЫ, их плюсуем в сумму. Само число делим на 10, в инте дробная часть убирается, десяток стал единицей и снова по циклу.
        int sum = 0;
        while (count != 0){
            sum += count % 10;//25-> остаток от деления на 10 = 5(его записываем в sum), 2-> ...
            count /= 10;// делим 25 на 10, остается 2,5 но в инт сохранится 2.
        }
        return sum;
    }
}
