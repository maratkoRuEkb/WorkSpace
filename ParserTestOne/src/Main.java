import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
/*
- выводит в терминал страницу сайта
- оформить в методы:
   1)
- надо чтобы вывел все страницы сайта (сделать в цикле запрос в глубину)
- надо сделать форматирование текста (вставить разделители таблицы) цикл со счетчиком 3 (три ячейки соединяем
- сделать сохранение в файлик
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        Document document = null; //тут будет сохранена страница сайта
        //--------------
        try{// пробуем получить страницу сайта
            System.out.println("sending a request / отправляем запрос");
            document = Jsoup.connect("https://easyoffer.ru/rating/android_developer")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com")
                    .get();
            System.out.println("document received / документ получен");
        } catch (Exception e) {
            e.printStackTrace();
        }


        // сделать метод получения ячейки из документа, через return
        for (Element element : document.select("td")){ //выдергивает и печатает в терминал каждую ячейку
            System.out.println(element.text());
        }



        //тут сделать метод который вернет строку из 3 ячеек
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            s.append(fields[i]);
        }
        return s.toString();



        System.out.println("End");
    }
}
