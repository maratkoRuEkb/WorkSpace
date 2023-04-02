import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame {
    public static void main(String[] args) {
        //TestFrame TestFrame = new TestFrame();
        //TestFrame.go();

        JFrame frame = new JFrame("Конвертер НДС");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //делаем верхнюю панель ГОТОВО
        JTextField value = new JTextField(10);// поле для ввода числа

        JButton button1 = new JButton("Вычислить");// кнопка запуска

        JPanel hightPanel = new JPanel();
        hightPanel.add(value);
        hightPanel.add(button1);

        //делаем нижнюю таблицу
        JPanel downPanel = new JPanel();
        JTable  table = new JTable (5,2);
        downPanel.add(table);
        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);

        //делаем таблицу
        frame.getContentPane().add(BorderLayout.CENTER, downPanel);
        frame.setVisible(true);
        //как заполнять таблицу данными???

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setBackground(Color.cyan);

            }
        });


    }// конец метода main


}//конец класса  TestFrame

////----------------------------------------------------------
//class ButtonStart implements ActionListener{
//    @Override
//    public void actionPerformed(ActionEvent e) {
//
//        //double column = e.getColumns();
//        //тут надо написать действие что будет происходить при нажатии кнопки ЗАПУСКАЕТ МЕТОД
//        //1.вводим в текстовое поле цифру
//        //2. нажимаем кнопку, берется цифра, проводится расчет
//        //3, результат передается в таблицу, результат выводится в таблице
//
//    }
//}// конец класса ButtonStart