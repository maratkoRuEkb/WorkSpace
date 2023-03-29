import java.awt.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.*;


public class ConverterNDS {
    public static void main(String[] args) {

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

        //данные нужно будет хранить в связном списке

        Scanner console = new Scanner(System.in);
        System.out.println("введите сумму с НДС");
        double number1 = console.nextDouble();
        double nds = 1.2;
        System.out.println("Сумма без НДС");
        double otvet = number1/nds;

        //Вариант 2, с верным округлением до 2 знаков после запятой, 2 знака будут всегда.
        System.out.format("%.2f",otvet);
        System.out.println();

    }

}
