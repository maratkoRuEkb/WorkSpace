import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//charset UTF-8
//version 0.23
//���������� � ���������
//��������� ���������� ������ � ���������� ����, ������ �� ������� ����� ��� ��������

public class ConverterNDS {
    static double summaSNds = 0.0;
    static double summaBezNds = 0.0;

    static void startGUI(Object data[][], Object columnNames[]) {//�������� GUI
        JFrame frame = new JFrame("����������� ��� ���");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);  //������ ����

        //������ ������� ������
        JTextField valueText = new JTextField(10);// ���� ��� ����� �����
        JButton button1 = new JButton("���������");// ������ �������
        JPanel hightPanel = new JPanel();
        hightPanel.add(valueText);
        hightPanel.add(button1);

        //������ ������ ������ � �������
        JTable table2 = new JTable(data, columnNames);// ������� ������� JTable � �������� � ��� ������

        JScrollPane scrollPane = new JScrollPane(table2); //������� ������� ��������� � ��������� � ��� ���� �������
        table2.setFillsViewportHeight(true); //true, ������� ���������� ��� ������ ����������, ���� ���� � ������� ������������ �����, ����� ������������ ��� ������������ ������������.

        //��������� ������� � ������ ������ �� ������
        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        scrollPane.setPreferredSize(new Dimension(300, 105));// ����������� ������ �������������� ������

        frame.pack();//������������ ����� � ����������� ���������
        frame.setVisible(true);

        Action action = new AbstractAction() { //������� ������ ������� ����� ������ ������
            @Override
            public void actionPerformed(ActionEvent e) {
                //����� ����� �� ���������� ���� � ������ ������
                parsingText(valueText.getText()); //� ������ �������� ���� �� ���������� ����
                summaBezNds = summaSNds / 1.2;
                //��� ����������� � ������ � ������ �����������

                String RoundedSummaSNds = String.format("%.2f", summaSNds);
                String RoundedSummaBezNds = String.format("%.2f", summaBezNds);
                //��������
                System.out.println("amount received with NDS " + RoundedSummaSNds);
                System.out.println("amount received without NDS " + RoundedSummaBezNds);
                //� ����� ������������ ������ �� ������� ���� �� ������ � ���������� ����� ������
                for (int i = 4; i > 0; i--) {
                    int y = i - 1;
                    data[i][0] = data[i - 1][0];
                    data[i][1] = data[i - 1][1];
                }
                data[0][0] = RoundedSummaSNds;
                data[0][1] = RoundedSummaBezNds;

                //������ �������� � �������� � �����
                for (int i = 0; i <= 4; i++) {
                    int y = i + 1;
                    System.out.println(y + " line " + data[i][0] + ", " + data[i][1]);
                }

                //��������� ����� �������
                scrollPane.repaint();//������������ ������ ������. ��������

                System.out.println("OK");
                System.out.println("��������� ���, KODIROVKA FAULT");
            }
        }; //����� ������ action
        valueText.addActionListener(action);  //����������� ��������� � ���������� ����
        button1.addActionListener(action); //����������� ��������� � ������
    }// ����� ������ startGUI

    static void parsingText(String text) {
        String str2 = text;
        try {
            summaSNds = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect string format!");
        }// ����� ������ try
    }// ����� parsingText

    public static void main(String[] args) {
        ConverterNDS ConverterNDS = new ConverterNDS();
        Object[][] data = new Object[5][2];
        Object[] columnNames = {"� ���", "��� ���"};
        startGUI(data, columnNames); //��������� ���
        System.out.println("Programm start");
    }//����� main

}// ����� ������