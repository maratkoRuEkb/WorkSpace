import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        Document document = null;

        try{
            System.out.println("sending a request / отправл€ем запрос");
            document = Jsoup.connect("https://easyoffer.ru/rating/android_developer")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com")
                    .get();
            System.out.println("document received / документ получен");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(document.toString()); //вывод всего содержимого сайта
        //Elements tr = document.select("tr") ; //вывод по тэгу <tr> сайта

//        for (Element element : document.select("tr")){ //построчно выдергивает содержимое
//            System.out.println(element.text());
//        }
        for (Element element : document.select("td")){ //выдергивает каждую €чейку
            System.out.println(element.text());
        }

        System.out.println("End");
    }
}
