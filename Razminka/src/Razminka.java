import java.io.IOException;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Razminka {
        public static void main(String[] args) {
        // 5. �������� ��������� Java, ������� ��������� ��� ����� � �������� ������� ������ � ���������� ������������ ���� �����.

        Scanner console = new Scanner(System.in);
        System.out.println("������� ����� � ���");
        double number1 = console.nextDouble();
        double nds = 1.2;
        System.out.println("����� ��� ���");
        double otvet = number1/nds;

        //������� 1, � ����������� ������� ���� 0,999999
        System.out.println(otvet);

        //������� 2, � ������ ����������� �� 2 ������ ����� �������, 2 ����� ����� ������.
        System.out.format("%.2f",otvet);
        System.out.println();

        //������� 3, � ������ �����������, �� �������� ������� ����� ���� ��� ����. ������ 34 ������ 34,00
        double value = otvet;
        DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
        String result = decimalFormat.format(value);
        System.out.println(result);

        System.out.println("�������� ����������");
                System.out.println (19 % 12);
                System.out.println (19 % -12);



    }
}



