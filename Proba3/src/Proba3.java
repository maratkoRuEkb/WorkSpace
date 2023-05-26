import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//charset UTF-8
//version 0.22
//С кодировками все хорошо
//исправил размеры окна таблицы и переделал вывод в терминал с русских на английский язык.

public class Proba3 {
    static double summaSNds = 0.0;
    static double summaBezNds = 0.0;

    static void startGUI(Object data[][], Object columnNames[]) {//создание GUI
        JFrame frame = new JFrame("Вычислитель без НДС");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);  //размер окна

        //делаем верхнюю панель
        JTextField valueText = new JTextField(10);// поле для ввода числа
        JButton button1 = new JButton("Вычислить");// кнопка запуска
        JPanel hightPanel = new JPanel();
        hightPanel.add(valueText);
        hightPanel.add(button1);

        //делаем нижнюю панель и таблицу
        JTable table2 = new JTable(data, columnNames);// создаем таблицу JTable и передаем в нее данные

        JScrollPane scrollPane = new JScrollPane(table2); //создаем область прокрутки и добавляем в нее нашу таблицу
        table2.setFillsViewportHeight(true); //true, таблица использует всю высоту контейнера, даже если в таблице недостаточно строк, чтобы использовать все вертикальное пространство.

        //размещаем верхнюю и нижнюю панель на фрейме
        frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);

        scrollPane.setPreferredSize(new Dimension(300, 105));// скролпанели задаем предпочитаемый размер

        frame.pack();//пересобирает фрэйм с актуальными размерами
        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //пишем что произойдет при нажатии кнопки
                //берем сумму из текстового поля и делаем расчет
                parsingText(valueText.getText()); //в методе получаем дабл из текстового поля
                summaBezNds = summaSNds / 1.2;
                //тут преобразуем в стринг с верным округлением

                String RoundedSummaSNds = String.format("%.2f", summaSNds);
                String RoundedSummaBezNds = String.format("%.2f", summaBezNds);
                //Проверки
                System.out.println("amount received with NDS " + RoundedSummaSNds);
                System.out.println("amount received without NDS " + RoundedSummaBezNds);
                //в цикле переписываем массив со сдвигом вниз на строку и записываем новые данные
                for (int i = 4; i > 0; i--) {
                    int y = i - 1;
                    data[i][0] = data[i - 1][0];
                    data[i][1] = data[i - 1][1];
                }
                data[0][0] = RoundedSummaSNds;
                data[0][1] = RoundedSummaBezNds;

/*
//            data [0] [0]; data [0] [1]
//            data [1] [0]; data [1] [1]
//            data [2] [0]; data [2] [1]
//            data [3] [0]; data [3] [1]
//            data [4] [0]; data [4] [1]
//
*/
                //вывожу проверку в терминал в цикле
                for (int i = 0; i <= 4; i++) {
                    int y = i + 1;
                    System.out.println(y + " line " + data[i][0] + ", " + data[i][1]);
                }

                //обновляем фрейм таблицы
                scrollPane.repaint();//ПЕРЕРИСОВАТЬ нижнюю панель. работает

                System.out.println("OK");
                System.out.println("Кракозябр нет, KODIROVKA FAULT");
            }
        });//конец addActionListener
    }// конец метода startGUI

    static void parsingText(String text) {
        String str2 = text;
        try {
            summaSNds = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect string format!");
        }// конец метода try
    }

    public static void main(String[] args) {
        Proba3 Proba3 = new Proba3();
        Object[][] data = new Object[5][2];
        Object[] columnNames = {"С НДС", "Без НДС"};

        startGUI(data, columnNames); //запускаем ГУИ

        System.out.println("Programm start");
    }//конец main

}
