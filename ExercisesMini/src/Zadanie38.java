/*
Задание 38 - ВЫПОЛНЕНО
Напишите программу на Java для подсчета букв, пробелов, чисел и других символов входной строки.
Ожидаемый результат

 Строка: Aa kiu, я swd skieo 236587. GH kiu: sieo ?? 25,33
буквы: 23
пробелы: 9
цифры: 10
другое: 6
 */

import java.util.Scanner;

public class Zadanie38 {
    public static void main(String[] args) {
        String str = "Aa kiu, я swd skieo 236587. GH kiu: sieo ?? 25,33";
        char[] arr = str.toCharArray();
        int letters = 0;
        int space = 0;
        int number = 0;
        int other = 0;


        for (int i = 0; i < arr.length; i++) {
            if (Character.isDigit(arr[i])) {//проверка на цифру
                number++;
            }
            else if  (Character.isSpaceChar(arr[i])) {
                space++;
            }
            else if  (Character.isLetter(arr[i])) {
                letters++;
            }
            else
                other++;

        }//конец fori

        System.out.println("В строке "+str+" имеется:");
        System.out.println("буквы: "+letters);
        System.out.println("пробелы: "+space);
        System.out.println("цифры: "+number);
        System.out.println("другое: "+other);

    }
}
