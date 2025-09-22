// Marat Saburov  mail: maratsaburov@yandex.ru

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class RuCode3 {
    public static void main(String[] args) {
        int count9;
        int[] arrayInput = new int[10];
        Scanner console = new Scanner(System.in);
        System.out.println("Ввод данных:"); //убрать потом
        int numberArray = console.nextInt(); //взяли первое число как длинну массива
        int[] array = new int[numberArray]; //создали массив
        for (int i = 0; i < array.length ; i++) { //следующие числа - наполняем массив в цикле
            array [i] = console.nextInt();
        }

        System.out.println("у нас есть массив с исходными числами");

        //надо создать массив с числами -1

//создадим массив символов и реверсом посимвольно закинем туда число
        for (int k = 0; k < array.length; k++) {
            System.out.println("цикл стартовал");
            arrayInput = IntStream.iterate(array[k], i -> i > 0, i -> i / 10).map(i -> i % 10).toArray();
            //воткнуть сюда второй поток с измененными числами
            //сравним оба потока и посчитаем девятки
            for (int a : arrayInput) {
                System.out.println(a);

            }
            System.out.println("Обработали число " +array[k]);
            System.out.println();
        }



// создадим второй массив и реверсом посимвольно закинем туда число - 0,01

//в цикле сравниваем ячейки обоих массивов и считаем число новых девяток


/*
        String str = Arrays.toString(array);

        int charCountOfA = (int) str.chars().filter(c -> c == '9').count();

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] - 1;
        }

        String str2 = Arrays.toString(array);
        int charCountOfZ = (int) str2.chars().filter(c -> c == '9').count(); //стрим с фильтром на цифру 9
*/



        //System.out.println(count9); //число дополнительных девяток - ОТВЕТ
    }
}
