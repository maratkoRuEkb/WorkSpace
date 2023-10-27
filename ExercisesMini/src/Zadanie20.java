import java.util.HexFormat;
import java.util.Scanner;

public class Zadanie20 {
    /*
    Задание 20 - ВЫПОЛНЕНО
    Напишите Java-программу для преобразования десятичного числа в шестнадцатеричное число.
Входные данные:
Введите десятичное число: 15
Ожидаемый результат

 Шестнадцатеричное число: F
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите десятичное число: ");
        int number = scanner.nextInt();
        //--------------- первый вариант
        System.out.print("Шестнадцатеричное число: ");
        String b = Integer.toHexString(number);
        System.out.println(b);

        //----------------- второй вариант
        System.out.print("Шестнадцатеричное число второй вариант: ");
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem;
        String hexdec_num="";
        while(number >0) {
            rem = number %16; //деление на 16, модуль остатка это будет номером ячейки в массиве
            hexdec_num = hex[rem] + hexdec_num; //значение из массива запишется в строку
            number = number/16; // число делится на 16 и само округляется
        }
        System.out.println(hexdec_num);
    }
}
