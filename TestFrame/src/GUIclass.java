import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIclass {
    JFrame frame = new JFrame("��������� ���");
    JPanel downPanel = new JPanel();
    JTable  table = new JTable (5,2);

    void go(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //������ ������� ������
        JTextField value = new JTextField(10);// ���� ��� ����� �����
        JButton button1 = new JButton("���������");// ������ �������
        JPanel hightPanel = new JPanel();
        hightPanel.add(value);
        hightPanel.add(button1);

        //������ ������ �������


        downPanel.add(table);

        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
        frame.getContentPane().add(BorderLayout.CENTER, downPanel);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //��� ����� ����� ����������� ������� �������
                TestFrame.interaction(value.getText());;//������� ��������� ����� ��, �������� � ��� ����� ��� ��� �� ���������� ����

                //�������� �� ���� ��������� ������� ������� �� �������
                table.setValueAt(TestFrame.massiv[0][0]);
                table.revalidate();
                table.repaint();
                downPanel.revalidate();
                downPanel.repaint();
            }
        });
    }// ����� go

    /*void obnovlebieFrame(){
        table.revalidate();
    }*/

}
