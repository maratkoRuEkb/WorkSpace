import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;


public class ConverterNDS  {
    private Object nds;

    public static void main(String[] args) {
        ConverterNDS  Converter = new ConverterNDS();
        Converter.go();
        double nds = 1.2;
        //������ ����� ����� ������� � ������� ������





        /

    }//����� main

    ActionListener reshit = new ActionListener()
    //����� �������
    public double setOtvet() { 
        
        double otvet = number1/nds;
        double number1;
        String textNum= value.getText(); //�������� ����� � ���� ������ ���� �������� ��� � ����
        try {
            number1 = Integer.doubleValue(textNum);
            System.out.println(number1);
        } catch (NumberFormatException e) {
            System.err.println("������������ ������ ������!");
        }

    }


    

    public void go () { //����� ��������� ���������
        JFrame frame = new JFrame("��������� ���");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //������ ������� ������ ������
        JTextField value = new JTextField(10);// ���� ��� ����� �����
        //



        JButton button1 = new JButton("���������");// ������ �������
        button1.addActionListener(new ButtonStart());

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


    }// ����� ������ go

    //��� ����� ������ ���������� �����
class ButtonStart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            double column = e.getColumns();
            //��� ���� �������� �������� ��� ����� ����������� ��� ������� ������ ��������� �����
            //1.������ � ��������� ���� �����
            //2. �������� ������, ������� �����, ���������� ������
            //3, ��������� ���������� � �������, ��������� ��������� � �������

        }
    }// ����� ������ ButtonStart


}// ����� ������ ConverterNDS





