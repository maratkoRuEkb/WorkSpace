import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestFrame {

    public static double[][] massiv = new double[5][2];//������ ������ ������ ��� ���������� �������? 10 �����

    public static void main(String[] args) {

        //�������� GUI
        GUIclass myGUI = new GUIclass();
        myGUI.go();

    }// ����� ������ main

    static public void interaction(String text) {
        //�������� ���� �� �������
        double numSNds = 0; //���������� �������� ����� � ���
        String str2 = text;
        try {
            numSNds = Double.parseDouble(str2); //����������� ���������� ����� � ����
        } catch (NumberFormatException e) {
            System.err.println("������������ ������ ������!");
        }// ����� ������ try

        //�������� ����������
        double numBezNds = numSNds/1.2;  //���������� �������� ����� ��� ���
        //���� ��������� � �������
        massiv[0][0] = numSNds;
        massiv[0][1] = numBezNds;


    }// ����� ������ go


}//����� ������  TestFrame