import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame {

    public static double[][] massiv = new double[5][2];//создал массив данных для заполнения таблицы? 10 ячеек

    public static void main(String[] args) {

        //создание GUI
        GUIclass myGUI = new GUIclass();
        myGUI.go();

    }// конец метода main

    static public void interaction(String text) {
        //получаем Дабл из Стринга
        double numSNds = 0; //переменная хранящая сумму с НДС
        String str2 = text;
        try {
            numSNds = Double.parseDouble(str2); //преобразуем полученный Стрнг в дабл
        } catch (NumberFormatException e) {
            System.err.println("Неправильный формат строки!");
        }// конец метода try

        //проводим вычисления
        double numBezNds = numSNds/1.2;  //переменная хранящая сумму без НДС
        //тест отправить в таблицу
        massiv[0][0] = numSNds;
        massiv[0][1] = numBezNds;


    }// конец метода go


}//конец класса  TestFrame