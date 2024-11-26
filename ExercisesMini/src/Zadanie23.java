import java.util.Scanner;

public class Zadanie23 {
    /*
Задание 23 - ВЫПОЛНЕНО
Напишите программу на Java для преобразования двоичного числа в шестнадцатеричное число. Перейти к редактору
Входные данные:
Введите двоичное число: 1101
Ожидаемый результат
 Шестнадцатеричное значение: D
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите двоичное число: ");
        int number = scanner.nextInt();
        String str = Integer.toString(number); //преобразуем двоичное число в строку

        System.out.println("Шестнадцатеричное число: ");
        int dec = Integer.parseInt(str, 2);
        String b = Integer.toHexString(dec); //хекс принимает десятичное число, видимо двоичку надо сначала в десятичку перевести
        System.out.println(b);
    }
}