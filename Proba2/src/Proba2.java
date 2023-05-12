import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//charset UTF-8
//version 0.21

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
    JPanel downPanel = new JPanel(); //нижняя панель, на ней будет таблица
    JTable table2 = new JTable(data, columnNames);// создаем таблицу JTable и передаем в нее данные

    JScrollPane scrollPane = new JScrollPane(table2); //создаем область прокрутки и добавляем в нее нашу таблицу
    table2.setFillsViewportHeight(true);

    //scrollPane.setSize(200, 200);
    downPanel.add(scrollPane);//добавляем таблицу


    frame.getContentPane().add(BorderLayout.NORTH, hightPanel);
    frame.getContentPane().add(BorderLayout.CENTER, downPanel);
        //scrollPane.setPreferredSize(new Dimension(300, 200));
        //frame.revalidate();
    frame.pack();//пересобирает фрэйм с актуальными размерами
    frame.setVisible(true);

    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //пишем что произойдет при нажатии кнопки
            //берем сумму из текстового поля и делаем расчет
            parsingText (valueText.getText()); //в методе получаем дабл из текстового поля
            summaBezNds = summaSNds/1.2;
            //тут преобразуем в стринг с верным округлением

            String RoundedSummaSNds = String.format("%.2f",summaSNds);
            String RoundedSummaBezNds = String.format("%.2f",summaBezNds);
            //Проверки
            System.out.println("получена сумма с НДС "+RoundedSummaSNds);
            System.out.println("получена сумма без НДС "+RoundedSummaBezNds);
            //в цикле переписываем массив со сдвигом вниз на строку и записываем новые данные
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
            //вывожу проверку в терминал в цикле
            for (int i = 0; i <= 4; i++) {
                int y = i+1;
                System.out.println(y + " строка " + data[i][0] + ", "+ data [i] [1]);
            }

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
