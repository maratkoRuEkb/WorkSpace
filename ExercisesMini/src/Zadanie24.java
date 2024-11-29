import java.util.Scanner;

public class Zadanie24 {
/*
Задание 24 - ВЫПОЛНЕНО
Напишите программу на Java для преобразования двоичного числа в восьмеричное число.
Входные данные:
Введите двоичное число: 111
Ожидаемый результат
Восьмеричное число: 7
*/

    public static void main(String[] args) {
        //Проще сначала двоичное перевести в десятичное и далее из десятичной в восьмеричное.
        //2->10->8

        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите двоичное число: ");
        int number = scanner.nextInt();
        String str = Integer.toString(number); //преобразуем двоичное число в строку

        /* parseInt - принимает два параметра на вход, двоичную строку и
         основание системы счисления, из которой должна быть преобразована входная строка */
        int ten = Integer.parseInt(str, 2); // в переменной b теперь десятичное число

        System.out.println("Восьмеричное число: ");
        String b = Integer.toOctalString(ten);
        System.out.println(b);

    }
}
