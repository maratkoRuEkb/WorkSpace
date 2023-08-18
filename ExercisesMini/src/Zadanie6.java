import java.util.Scanner;

public class Zadanie6 {
    /*
    Задание 7 - ВЫПОЛНЕНО
     Напишите Java-программу для печати суммы (сложения), умножения, вычитания, деления и остатка двух чисел.
     Тестовые данные:
        Введите первое число: 125
        Введите второе число: 24
     Ожидаемый результат :
        125 + 24 = 149
        125 - 24 = 101
        125 х 24 = 3000
        125/24 = 5
        125 мод 24 = 5
     */
    public static void main(String[] args) {
        //InputStream stream = System.in;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int a = console.nextInt();
        System.out.println("Введите второе число: ");
        int b = console.nextInt();

        int c = a+b;
        System.out.println(a+" + "+ b +" = "+c);

        int c2 = a-b;
        System.out.println(a+" - "+ b +" = "+c2);

        int c3 = a*b;
        System.out.println(a+" x "+ b +" = "+c3);

        int c4 = a/b;
        System.out.println(a+" / "+ b +" = "+c4);

        int c5 = a%b;
        System.out.println(a+" модуль "+ b +" = "+c5);
    }
}
