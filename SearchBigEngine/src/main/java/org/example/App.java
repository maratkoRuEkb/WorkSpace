package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Будет программа для поиска в большом текстовом файле (11Гб)
Обработка:
запрашиваем из файла немного строк
производим в них поиск
сохраняем результат в лог или показываем в терминале

так как файл большой, целиком его грузить в память накладно.

 */
public class App 
{
    public static void main( String[] args )    {
        String path = "c:\\Users\\Tetragon10\\Documents\\база паролей combined\\combined.txt";
        Path sourcePath = Paths.get("c:\\Users\\Tetragon10\\Documents\\база паролей combined\\combined.txt");
        Scanner scanner = null;
        int count = 0; // счетчик строк

        try(FileInputStream fin=new FileInputStream("c:\\Users\\Tetragon10\\Documents\\база паролей combined\\combined.txt")){
            int i=-1;
            while(условие){
                System.out.print((char)i);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } //конец try


        //System.out.println(sourcePath.getFileName());
    }
}
