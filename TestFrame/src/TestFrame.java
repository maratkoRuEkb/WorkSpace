import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame {
    public static void main(String[] args) {
        //TestFrame TestFrame = new TestFrame();
        //TestFrame.go();

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

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setBackground(Color.cyan);

            }
        });


    }// ����� ������ main


}//����� ������  TestFrame

////----------------------------------------------------------
//class ButtonStart implements ActionListener{
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        //double column = e.getColumns();
//        //��� ���� �������� �������� ��� ����� ����������� ��� ������� ������ ��������� �����
//        //1.������ � ��������� ���� �����
//        //2. �������� ������, ������� �����, ���������� ������
//        //3, ��������� ���������� � �������, ��������� ��������� � �������
//
//    }
//}// ����� ������ ButtonStart