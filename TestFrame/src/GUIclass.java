import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIclass {
    JFrame frame = new JFrame("Конвертер НДС");
    JPanel downPanel = new JPanel();
    JTable  table = new JTable (5,2);

    void go(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //делаем верхнюю панель
        JTextField value = new JTextField(10);// поле для ввода числа
        JButton button1 = new JButton("Вычислить");// кнопка запуска
        JPanel hightPanel = new JPanel();
        hightPanel.add(value);
        hightPanel.add(button1);

        //делаем нижнюю таблицу


        downPanel.add(table);

        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
        frame.getContentPane().add(BorderLayout.CENTER, downPanel);
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //тут будет метод заполняющий таблицу данными
                TestFrame.interaction(value.getText());;//кнопкой запустили метод го, передали с ним сумму без ндс из текстового поля

                //ПРОБЛЕМА не могу заполнить таблицу данными из массива
                table.setValueAt(TestFrame.massiv[0][0]);
                table.revalidate();
                table.repaint();
                downPanel.revalidate();
                downPanel.repaint();
            }
        });
    }// конец go

    /*void obnovlebieFrame(){
        table.revalidate();
    }*/

}
