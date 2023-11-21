import java.util.Scanner;

public class Zadanie15 {
    /*
    Задание 15 - ВЫПОЛНЕНО
    Напишите программу на Java для замены двух переменных. SWAP
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int a = scanner.nextInt();

        System.out.println("Введите второе число:");
        int b = scanner.nextInt();
        System.out.println("До обмена a = "+a +" b = "+b);
        int c = a;
        a = b;
        b = c;
        System.out.println("После обмена a = "+a +" b = "+b);



    }

}
