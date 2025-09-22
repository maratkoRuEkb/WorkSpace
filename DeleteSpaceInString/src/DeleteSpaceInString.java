import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
в терминале будем принимать строку текста и удалять в ней лишние пробелы(в том числе множественные.
в терминал обратно будем выдавать нормализованную строку
 */
public class DeleteSpaceInString {
    public static void main(String[] args) {
        InputStream stream = System.in;
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buff = new BufferedReader(reader);
// ввод строки через терминал - ок
        System.out.println("Введите строку для удаления лишних пробелов");
        String line = null;
        try {
            line = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
// обработка строки - ОК
        String str = line.trim(); //трим у строки спереди и сзади успешно режет пробелы (множественные тоже)
        String result = str.replaceAll("\\s+"," "); // все множественные пробелы заменяем одним пробелом

        System.out.println(result);
    }
}
