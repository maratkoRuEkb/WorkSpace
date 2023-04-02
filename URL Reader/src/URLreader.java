import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLreader {

    public static void main (String[] args){
        new URLreader().go();
        }

    private void go() {
        try {// пробуем и ловим исключения
            URL url = new URL("https://alexandr-rogers.livejournal.com/2020/11/13/"); //создаем объект URL и передаем ему ссылку
            InputStream input = url.openStream();// созд InputStream открываем его и передаем в него ссылку URL
            byte[] buffer = input.readAllBytes();//читаем все байты и передаем в массив
            String str = new String(buffer);//преобразуем массив байт в строку
            System.out.println(str);//выводим в печать всю строку
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
