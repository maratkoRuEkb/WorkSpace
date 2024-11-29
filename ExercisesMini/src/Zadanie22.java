import java.util.Scanner;

public class Zadanie22 {
/*
Задание 22 - ВЫПОЛНЕНО
Напишите программу на Java для преобразования двоичного числа в десятичное число.
Входные данные:
Введите двоичное число: 100
Ожидаемый результат
 Десятичное число: 4
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите двоичное число: ");
        int number = scanner.nextInt();
        String str = Integer.toString(number); //преобразуем двоичное число в строку

        System.out.println("Десятичное число: ");
        /* parseInt - принимает два параметра на вход, двоичную строку и
         основание системы счисления, в которую должна быть преобразована входная строка */
        int b = Integer.parseInt(str, 2);
        System.out.println(b);
    }

}
