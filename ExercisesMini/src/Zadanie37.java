/*
Задание 37 - ВЫПОЛНЕНО
Напишите программу на Java для обращения строки.
Входные данные:
Введите строку: The quick brown fox
Ожидаемый результат
 Обратная строка: xof nworb kciuq ehT
 */

import java.util.Scanner;

public class Zadanie37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = scanner.nextLine();

        // 1 - через StringBuilder
        System.out.println("Обратная строка через StringBuilder: " + new StringBuilder(str).reverse().toString());

        // 2 - через массив
        System.out.println("Обратная строка через массив: " + reverseString(str));
    }
    public static String reverseString(String s){ //сам метод через массив
        char [] array = s.toCharArray(); //строку преобразуем в массив символов
        String result = "";
        for (int i = array.length-1; i >= 0;  i--) {
            result = result + array[i];
        }
        return result;
    }
}
