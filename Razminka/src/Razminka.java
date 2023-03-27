import java.io.IOException;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Razminka {
        public static void main(String[] args) {
        // 5. Напишите программу Java, которая принимает два числа в качестве входных данных и отображает произведение двух чисел.

        Scanner console = new Scanner(System.in);
        System.out.println("введите сумму с НДС");
        double number1 = console.nextDouble();
        double nds = 1.2;
        System.out.println("Сумма без НДС");
        double otvet = number1/nds;

        //Вариант 1, с некоректным ответом типа 0,999999
        System.out.println(otvet);

        //Вариант 2, с верным округлением до 2 знаков после запятой, 2 знака будут всегда.
        System.out.format("%.2f",otvet);
        System.out.println();

        //Вариант 3, с верным округлением, не печатает дробную часть если там нули. Пример 34 вместо 34,00
        double value = otvet;
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        String result = decimalFormat.format(value);
        System.out.println(result);

        System.out.println("проверка математики");
                System.out.println (19 % 12);
                System.out.println (19 % -12);



    }
}



