package com.maratsaburov;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

/*
Программа выводит в консоль всю таблицу процессоров, далее сохранить в тхт и регулярками доработать
 */


public class Helper {
    public static void main(String[] args) throws IOException {
        System.out.println("Start / Старт");

        for (int i = 1; i < 20; i++) {
            int count = i;
            String target = "https://technical.city/ru/cpu/rating?&pg="+count;
            sendingRequest(target);
        }//for
        System.out.println("Finish / Конец");
    }//main

    //метод запрашивает страницу и выводит в терминал
    public static void sendingRequest(String target) throws IOException {//на вход получаем URL адрес
        Document document = null; //в документ сохраняем страницу сайта

        try { // пробуем получить страницу сайта - РАБОТАЕТ
            System.out.println("sending a request / отправляем запрос ");
            document = Jsoup.connect(target)
                    .userAgent("Chrome/141.0.0.0 Safari/537.36")
                    .referrer("http://www.google.com").get();
            System.out.println("document received / документ получен");
        } catch (Exception e) {
            System.out.println("request failure / запрос провален");
            e.printStackTrace();
        }

        // цикл выводит в файл построчно что мне надо, но разбить на столбцы в экселе не могу, не хватает разделителей
        for (Element element : document.select("tr")) {
            System.out.println(element.text());
        }
    } //конец sendingRequest
}
