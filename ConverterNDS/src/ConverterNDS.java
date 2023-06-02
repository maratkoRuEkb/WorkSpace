import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//charset UTF-8
//version 0.23
//Кракозябры в терминале
//переделал слушателей кнопки и текстового поля, теперь по нажатию Энтер все работает

public class ConverterNDS {
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

        Action action = new AbstractAction() { //создаем объект который будет делать расчет
            @Override
            public void actionPerformed(ActionEvent e) {
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
        }; //конец метода action
        valueText.addActionListener(action);  //прикрепляем слушателя к текстовому полю
        button1.addActionListener(action); //прикрепляем слушателя к кнопке
    }// конец метода startGUI

    static void parsingText(String text) {
        String str2 = text;
        try {
            summaSNds = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            System.err.println("Incorrect string format!");
        }// конец метода try
    }// конец parsingText

    public static void main(String[] args) {
        ConverterNDS ConverterNDS = new ConverterNDS();
        Object[][] data = new Object[5][2];
        Object[] columnNames = {"С НДС", "Без НДС"};
        startGUI(data, columnNames); //запускаем ГУИ
        System.out.println("Programm start");
    }//конец main

}// конец класса