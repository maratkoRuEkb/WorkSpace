import java.io.InputStream;
import java.util.Scanner;

public class Zadanie5 {
    /*
    Задание 5 - ВЫПОЛНЕНО
    Напишите программу Java, которая принимает два числа в качестве входных данных и отображает произведение двух чисел.
        Тестовые данные:
    Введите первое число: 25
    Введите второе число: 5
        Ожидаемый результат :
    25 х 5 = 125
    */
    public static void main(String[] args) {
        //InputStream stream = System.in;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = console.nextInt();
        System.out.println("Введите второе число: ");
        int b = console.nextInt();
        int c = a*b;
        System.out.println(a+" x "+ b +" = "+c);
    }
}
