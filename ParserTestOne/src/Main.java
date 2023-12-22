import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.IOException;
/*
- ������� � �������� �������� �����
- �������� � ������:
   1)
- ���� ����� ����� ��� �������� ����� (������� � ����� ������ � �������)
- ���� ������� �������������� ������ (�������� ����������� �������) ���� �� ��������� 3 (��� ������ ���������
- ������� ���������� � ������
 */

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Start");
        Document document = null; //��� ����� ��������� �������� �����
        //--------------
        try{// ������� �������� �������� �����
            System.out.println("sending a request / ���������� ������");
            document = Jsoup.connect("https://easyoffer.ru/rating/android_developer")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com")
                    .get();
            System.out.println("document received / �������� �������");
        } catch (Exception e) {
            e.printStackTrace();
        }


        // ������� ����� ��������� ������ �� ���������, ����� return
        for (Element element : document.select("td")){ //����������� � �������� � �������� ������ ������
            System.out.println(element.text());
        }



        //��� ������� ����� ������� ������ ������ �� 3 �����
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < fields.length; i++) {
            s.append(fields[i]);
        }
        return s.toString();



        System.out.println("End");
    }
}
