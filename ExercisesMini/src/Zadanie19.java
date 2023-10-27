import java.util.Scanner;
import java.util.function.IntBinaryOperator;

public class Zadanie19 {
    /*
    Задание 19 - ВЫПОЛНЕНО
Напишите программу на Java для преобразования десятичного числа в двоичное число. Перейти к редактору
Входные данные:
Введите десятичное число: 5
Ожидаемый результат

 Двоичный номер: 101
     */
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.print("Введите десятичное число: ");
        int a = scaner.nextInt();

        //--------------- первый вариант
        String s = Integer.toBinaryString(a);
        System.out.println("Двоичный номер: "+s);
        //--------------- второй вариант

        int[] binNum = new int[100];
        int i = 1;
        int z = a;
        while (z != 0){
            binNum[i++] = z%2;
            z = z/2;
        }
        System.out.println("Двоичный номер второй вариант: ");
        for (int j =i-1; j > 0; j--) {
            System.out.print(binNum[j]);
        }

    }

}
