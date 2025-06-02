import javax.print.StreamPrintService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int stage_n; //этажи
        int appartaments_m; //кол-во квартир на этаже
        int windows_x; //окно в высоту
        int windows_y; //окно в ширину

        //получаем конфигурацию дома
        Scanner console = new Scanner(System.in);
        String array = console.nextLine();
        //распарсили в массив данные
        int[] input = Stream.of(array.split(" ")).mapToInt(Integer::parseInt).toArray();

        stage_n = input[0];
        appartaments_m = input[0];
        windows_x = input[0];
        windows_y = input[0];

        int total_char = stage_n * windows_x * appartaments_m * windows_y;
        //получаем строки с планом
        List<Character> array_char = new ArrayList<>(total_char);
        for (int i = 0; i <= total_char; i++) {
            array_char.add(console.nextLine().charAt(i));
        }

        /*
        for (int i = 1; i <= input[0]; i++) {
            for (int j = 1; j <= input[1]; j++) {
                double value = input[2] * input[3] /2;
                double result = Math.ceil(value);
            }
        }
*/
        System.out.println("start value");
        for (int i : input) {System.out.print(i + " ");}
        System.out.println("end value");
        System.out.println(array_char);

    }


    }
/*
2 2 2 2
X000
000X
X000
XX00
 */

