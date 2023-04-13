import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.Reader;

public class Proba2 {
    static double summaSNds = 0.0;
    static double summaBezNds = 0.0;

    static void  startGUI(Object data[][], Object columnNames[]){//создание GUI
    JFrame frame = new JFrame("Вычислитель без НДС");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);

    //делаем верхнюю панель
    JTextField valueText = new JTextField(10);// поле для ввода числа
    JButton button1 = new JButton("Вычислить");// кнопка запуска
    JPanel hightPanel = new JPanel();
    hightPanel.add(valueText);
    hightPanel.add(button1);

    //делаем нижнюю таблицу
    JPanel downPanel = new JPanel();

    JTable table2 = new JTable(data, columnNames);// создаем таблицу JTable и передаем в нее данные
    downPanel.add(table2);//дабавляем таблицу

    frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
    frame.getContentPane().add(BorderLayout.CENTER, downPanel);
    frame.setVisible(true);

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //пишем что произойдет при нажатии кнопки
            //берем сумму из текстового поля и делаем расчет
            parsingText (valueText.getText()); //получаем дабл из текстового поля
            summaBezNds = summaSNds/1.2;
            System.out.println("получена сумма с НДС "+summaSNds);
            System.out.println("получена сумма без НДС "+summaBezNds);
            //в цикле переписываем массив со сдвигом вниз на строку и записываем новые данные
            data [4] [0] = data [3] [0];
            data [4] [1] = data [3] [1];

            data [3] [0] = data [2] [0];
            data [3] [1] = data [2] [1];

            data [2] [0] = data [1] [0];
            data [2] [1] = data [1] [1];

            data [1] [0] = data [0] [0];
            data [1] [1] = data [0] [1];

            data [0] [0] = summaSNds;
            data [0] [1] = summaBezNds;

//
//            data [0] [0]; data [0] [1]
//            data [1] [0]; data [1] [1]
//            data [2] [0]; data [2] [1]
//            data [3] [0]; data [3] [1]
//            data [4] [0]; data [4] [1]
//
            System.out.println("1 строка " + data[0][0] + ", "+ data [0] [1]);
            System.out.println("2 строка " + data[1][0] + ", "+ data [1] [1]);
            System.out.println("3 строка " + data[2][0] + ", "+ data [2] [1]);
            System.out.println("4 строка " + data[3][0] + ", "+ data [3] [1]);
            System.out.println("5 строка " + data[4][0] + ", "+ data [4] [1]);

            //обновляем фрейм таблицы
            downPanel.repaint(); // ПЕРЕРИСОВАТЬ нижнюю панель. работает
            //frame.repaint(); // ПЕРЕРИСОВАТЬ все окно. работает
            System.out.println("Все ок");
        }
    });//конец addActionListener
}// конец метода startGUI

    static void parsingText(String text){
        String str2 = text;
        try {
            summaSNds = Double.parseDouble(str2);
        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }// конец метода try
    }

    public static void main(String[] args) {
        Proba2 Proba2 = new Proba2();
        Object[][] data = new Object[5][2];
        Object[] columnNames = {"С НДС","Без НДС"};

        startGUI(data, columnNames); //запускаем ГУИ
        // только заголовки таблицы не работают

        System.out.println("Programm start");
    }//конец main

}
