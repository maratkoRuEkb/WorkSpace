import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.Reader;

public class Proba2 {

    //double[][] massiv = new double[5][2];//������ ������ ������ ��� ���������� �������? 10 �����




    public static void main(String[] args) {
        Proba2 Proba2 = new Proba2();
        //�������� GUI
        JFrame frame = new JFrame("Main window");
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
        //JTable  table = new JTable (5,1);
        // �������� ������ ��������!!! ������ ��������� ������� �� ��������
        String[] columnNames = {"� ���","��� ���"};
        Object[][] data = {
                {"40000", 50000}, // ��� ���� ����� ��������
                {"5500",  300.005},
                {"5500",  Double.valueOf(300.548)},


        };

        JTable table2 = new JTable(data, columnNames);
        downPanel.add(table2);

        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
        frame.getContentPane().add(BorderLayout.CENTER, downPanel);
        frame.setVisible(true);




        double[] massiv = new double[5];//������ ������ ������ ��� ���������� �������? 10 �����
        massiv[0] = 40000;
        massiv[1] = 60000;
        massiv[2] = 10000;
        System.out.println(massiv[0]);
        System.out.println(massiv[1]);
        System.out.println(massiv[2]);

        String s1 = new String("������1");

        //table.setValueAt(s1, 1,1 );
        //System.out.println(table.isCellEditable(1,1));
        //table.setValueAt(massiv[1], 2,1 );
        //table.setValueAt(massiv[2], 3,1 );

    }

}
