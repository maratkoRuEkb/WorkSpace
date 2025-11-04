package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Scanner;

/*
PROGRAMM IS FINISHED
Будет программа для поиска в большом текстовом файле (11Гб)
Обработка:
запрашиваем из файла немного строк
производим в них поиск
сохраняем результат в лог или показываем в терминале

так как файл большой, целиком его грузить в память накладно.
Эти 3 пароля в базе точно есть. Образцы для проверки.
$|ovki
!ee!oo
$e[-xd
 */
public class App 
{
    public static void main( String[] args )    {
        String path = "j:\\база паролей combined\\combined.txt";
        Path sourcePath = Paths.get("c:\\Users\\Tetragon10\\Documents\\база паролей combined\\combined.txt");
        Scanner scanner = null;
        String s = "$e[-xd";

        /* //тут подсчитал кол-во строк в файле,за минуту выдал 955 742 503 строк - РАБОТАЕТ
        int count = 0; // счетчик строк
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                count++;
            }
            System.out.println("Количество строк в файле: " + count); // 955 742 503 строк
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } //конец try
        */

        //читаем файл построчно и сравниваем с тем что ищем
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            System.out.println("Search starting. Target: "+s);
            String line;
            int count = 0; // счетчик строк
            while ((line = reader.readLine()) != null) {
                if (Objects.equals(line, s)) {
                    System.out.println("FIND: " + s);
                }
                count++;
            }

/*
            //выводит в терминал 100 первых строк - РАБОТАЕТ
            for (int i = 0; i < 100; i++) {
                System.out.println(reader.readLine());
            }
*/

            System.out.println("searching is over. String checked is "+ count);
            //System.out.println("searching is over.");

        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        } //конец try

    }
}
