import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;


public class ConverterNDS {
    public static void main(String[] args) {

        JFrame frame = new JFrame("��������� ���");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //������ ������� ������ ������
        JTextField value = new JTextField(10);// ���� ��� ����� �����
        JButton button1 = new JButton("���������");// ������ �������
        JPanel hightPanel = new JPanel();
        hightPanel.add(value);
        hightPanel.add(button1);
        //������ ������ �������
        JPanel downPanel = new JPanel();
        JTable  table = new JTable (5,2);
        downPanel.add(table);
        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);

        //������ �������
        frame.getContentPane().add(BorderLayout.CENTER, downPanel);
        frame.setVisible(true);
        //��� ��������� ������� �������???

        //������ ����� ����� ������� � ������� ������

        Scanner console = new Scanner(System.in);
        System.out.println("������� ����� � ���");
        double number1 = console.nextDouble();
        double nds = 1.2;
        System.out.println("����� ��� ���");
        double otvet = number1/nds;

        //������� 2, � ������ ����������� �� 2 ������ ����� �������, 2 ����� ����� ������.
        System.out.format("%.2f",otvet);
        System.out.println();

    }

}
