import java.util.Scanner;

public class Zadanie16 {
/* Задание 7 - разобраться в ней
Напишите программу на Java, чтобы добавить два двоичных числа.
Входные данные:
Введите первое двоичное число: 100010
Введите второе двоичное число: 110010
Ожидаемый результат

 Сумма двух двоичных чисел: 1010100
 */
    public static void main(String[] args) {
        long binary1, binary2;
        int i = 0, remainder = 0;
        int[] sum = new int[20];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first binary number: ");
        binary1 = scanner.nextLong();
        System.out.print("Input second binary number: ");
        binary2 = scanner.nextLong();
        while (binary1 != 0 || binary2 != 0)// в цикле что вообще происходит??
        {
            sum[i++] = (int)((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum[i++] = remainder;
        }
        --i;
        System.out.print("Sum of two binary numbers: ");
        while (i >= 0) {
            System.out.print(sum[i--]);
        }
        System.out.print("\n");


    }
}
