import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;


public class ConverterNDS  {
    private Object nds;

    public static void main(String[] args) {
        ConverterNDS  Converter = new ConverterNDS();
        Converter.go();
        double nds = 1.2;
        //данные нужно будет хранить в связном списке





        /

    }//конец main

    ActionListener reshit = new ActionListener()
    //метод расчета
    public double setOtvet() { 
        
        double otvet = number1/nds;
        double number1;
        String textNum= value.getText(); //получили цифру в виде текста надо привести его к Дабл
        try {
            number1 = Integer.doubleValue(textNum);
            System.out.println(number1);
        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }

    }


    

    public void go () { //метод создающий интерфейс
        JFrame frame = new JFrame("Конвертер НДС");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        //делаем верхнюю панель ГОТОВО
        JTextField value = new JTextField(10);// поле для ввода числа
        //



        JButton button1 = new JButton("Вычислить");// кнопка запуска
        button1.addActionListener(new ButtonStart());

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


    }// конец метода go

    //тут можно делать внутренний класс
class ButtonStart implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            double column = e.getColumns();
            //тут надо написать действие что будет происходить при нажатии кнопки ЗАПУСКАЕТ МЕТОД
            //1.вводим в текстовое поле цифру
            //2. нажимаем кнопку, берется цифра, проводится расчет
            //3, результат передается в таблицу, результат выводится в таблице

        }
    }// конец класса ButtonStart


}// конец класса ConverterNDS





