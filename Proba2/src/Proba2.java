import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.Reader;

public class Proba2 {
    static double summaSNds = 0.0;
    static double summaBezNds = 0.0;

    static void  startGUI(Object data[][], Object columnNames[]){//�������� GUI
    JFrame frame = new JFrame("����������� ��� ���");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);

    //������ ������� ������
    JTextField valueText = new JTextField(10);// ���� ��� ����� �����
    JButton button1 = new JButton("���������");// ������ �������
    JPanel hightPanel = new JPanel();
    hightPanel.add(valueText);
    hightPanel.add(button1);

    //������ ������ �������
    JPanel downPanel = new JPanel();

    JTable table2 = new JTable(data, columnNames);// ������� ������� JTable � �������� � ��� ������
    downPanel.add(table2);//��������� �������

    frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
    frame.getContentPane().add(BorderLayout.CENTER, downPanel);
    frame.setVisible(true);

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //����� ��� ���������� ��� ������� ������
            //����� ����� �� ���������� ���� � ������ ������
            parsingText (valueText.getText()); //� ������ �������� ���� �� ���������� ����
            summaBezNds = summaSNds/1.2;
            //��� ����������� � ������ � ������ �����������

            String RoundedSummaSNds = String.format("%.2f",summaSNds);
            String RoundedSummaBezNds = String.format("%.2f",summaBezNds);
            //��������
            System.out.println("�������� ����� � ��� "+RoundedSummaSNds);
            System.out.println("�������� ����� ��� ��� "+RoundedSummaBezNds);
            //� ����� ������������ ������ �� ������� ���� �� ������ � ���������� ����� ������
            for (int i = 4; i >0 ; i--) {
                int y = i-1;
                data [i] [0] = data [i-1] [0];
                data [i] [1] = data [i-1] [1];
            }
            data [0] [0] = RoundedSummaSNds;
            data [0] [1] = RoundedSummaBezNds;

/*
//            data [0] [0]; data [0] [1]
//            data [1] [0]; data [1] [1]
//            data [2] [0]; data [2] [1]
//            data [3] [0]; data [3] [1]
//            data [4] [0]; data [4] [1]
//
*/
            //������ �������� � �������� � �����
            for (int i = 0; i <= 4; i++) {
                int y = i+1;
                System.out.println(y + " ������ " + data[i][0] + ", "+ data [i] [1]);
            }

            //��������� ����� �������
            downPanel.repaint(); // ������������ ������ ������. ��������
            //frame.repaint(); // ������������ ��� ����. ��������
            System.out.println("��� ��");
        }
    });//����� addActionListener
}// ����� ������ startGUI

    static void parsingText(String text){
        String str2 = text;
        try {
            summaSNds = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            System.err.println("������������ ������ ������!");
        }// ����� ������ try
    }

    public static void main(String[] args) {
        Proba2 Proba2 = new Proba2();
        Object[][] data = new Object[5][2];
        Object[] columnNames = {"� ���","��� ���"};

        startGUI(data, columnNames); //��������� ���
        // ������ ��������� ������� �� ��������

        System.out.println("Programm start");
    }//����� main

}
