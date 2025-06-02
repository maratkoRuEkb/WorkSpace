package org.example;

import java.io.*;
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

        /* тут подсчитал кол-во строк в файле РАБОТАЕТ за минуту выдал 955742503 строк
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
            System.out.println("Количество строк в файле: " + count); // 955742503 строк
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } //конец try
        */

        //System.out.println(sourcePath.getFileName());
    }
}
