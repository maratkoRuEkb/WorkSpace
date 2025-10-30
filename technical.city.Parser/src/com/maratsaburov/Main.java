package com.maratsaburov;

/*
Хочу запарсить данные по процессорам и видеокартам с сайта technical.city
Сохранить достаточно в тхт формате с разделителями, далее в экселе сам в таблицу перекину


мне нужно получить:
1) номер в рейтинге
2) название
3) тип
4) Производительность
5) ядра/потоки
6) год
7) Тепловыделение
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start / Старт");
        String target = "https://technical.city/ru/cpu/rating";

        //метод создание файла для сохранения - ГОТОВО
        File txt = null;
        try { //создадим файл для сохранения документа
            txt = new File("output.txt");
            if (txt.createNewFile()) {
                System.out.println("Файл создан");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла");
            e.printStackTrace();
        }

        //метод получение 1 страницы сайта - описать сохранение в файл через стринг билдер конкат


        //метод получение


        sendingRequest(target, txt);
        System.out.println("End");
    }

    public static void sendingRequest(String target, File txt){ //метод запрашивает страницу и записывает ее в файл
        Document document = null; //тут будет сохранена страница сайта
        StringBuilder sb = new StringBuilder((CharSequence) txt);
        try { // пробуем получить страницу сайта
            System.out.println("sending a request / отправляем запрос ");
            document = Jsoup.connect(target)
                    .userAgent("Chrome/141.0.0.0 Safari/537.36")
                    .referrer("http://www.google.com").get();
            System.out.println("document received / документ получен");
        }catch (Exception e){
            System.out.println("request failure");
            e.printStackTrace();
        }

        System.out.println("Write in txt file");
        System.out.println(document);
        //sb.insert(document);
        sb.append(document);
        System.out.println("write done");
    }


} //end main
