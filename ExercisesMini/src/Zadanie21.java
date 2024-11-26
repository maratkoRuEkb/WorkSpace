import java.util.Scanner;

public class Zadanie21 {
    /*
    Задание 21 - ВЫПОЛНЕНО
    Напишите программу на Java для преобразования десятичного числа в восьмеричное число.
Входные данные:
Введите десятичное число: 15
Ожидаемый результат

 Восьмеричное число: 17
     */

    public static void main(String[] args) {
        Scanner  scanner = new Scanner (System.in);
        System.out.println("Введите десятичное число: ");
        int number = scanner.nextInt();
//--------------- первый вариант
        System.out.println("Восьмеричное число: ");
        String b = Integer.toOctalString(number);
        System.out.println(b);

//--------------- второй вариант
        System.out.print("Восьмеричное число второй вариант: ");
        char octa[]={'0','1','2','3','4','5','6','7'};
        int rem;
        String octadec_num="";
        while(number >0) {
            rem = number %8; //деление на 8, модуль остатка это будет номером ячейки в массиве
            octadec_num = octa[rem] + octadec_num; //значение из массива запишется в строку
            number = number/8; // число делится на 8 и само округляется
        }
        System.out.println(octadec_num);

    }

}//конец класса
