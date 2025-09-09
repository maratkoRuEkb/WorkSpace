// Marat Saburov  mail: maratsaburov@yandex.ru

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
задача посчитать кол-во новых девяток в ценниках 9800 - 9799,99 (4 новых)
делаю через 2 массива: первый исходные цифры, второй новые значения -0,01
цифры сравниваем справа налево.
 */
public class Main {
    public static void main(String[] args) {
        int count9 = 0;
        int[] arrayInput = new int[10]; //инициализируем массив с размером отбалды для временного содержания цифр
        int[] arrayOutput = new int[10];
        Scanner console = new Scanner(System.in);
        System.out.println("Ввод данных:"); //убрать потом
        int numberArray = console.nextInt(); //взяли первое число как длинну массива
        int[] array = new int[numberArray]; //создали массив для входящих чисел
        for (int i = 0; i < array.length ; i++) { //следующие числа - наполняем массив в цикле
            array [i] = console.nextInt();
        }

        System.out.println("у нас есть массив с исходными числами");
        int[] arrayResult = new int[numberArray]; //создали массив для чисел -1
        for (int i = 0; i < arrayResult.length; i++) {
            arrayResult[i] = array[i] - 1;
        }
        for (int a : arrayResult) { //проверка исходящих данных
            System.out.println(a);
        }


//создадим массив символов и реверсом посимвольно закинем туда число
        for (int k = 0; k < array.length; k++) {
            System.out.println("цикл стартовал");
            arrayInput = IntStream.iterate(array[k], i -> i > 0, i -> i / 10).map(i -> i % 10).toArray(); //обратный поток входящий
            //воткнуть сюда второй поток с измененными числами
            arrayOutput = IntStream.iterate(arrayResult[k], i -> i > 0, i -> i / 10).map(i -> i % 10).toArray();    //обратный поток результата -1, оба потока надо сравнить

            //сравним оба потока и посчитаем девятки
            if(arrayInput[k] != 9 & arrayOutput[k] != 9) { //если обе ячейки не 9 то выход
                break;
            } else if (arrayInput[k] == 9 & arrayOutput[k] != 9) { // если входная ячейка 9, а выходная не 9 то выход
                break;
            } else if (arrayInput[k] == 9 & arrayOutput[k] == 9) { //если обе ячейки  9 то выход
                break;
            } else if(arrayInput[k]!= 9 & arrayOutput[k] == 9) { //остается только если входная ячейка любая(кроме 9), а выходная 9 то счетчик +1
                count9++;
            } else
                System.out.println("Error check input " + arrayInput[k] + "output " + arrayOutput[k]);

 /*           for (int a : arrayInput) { //проверка
                System.out.println(a);
            }
            for (int b : arrayOutput) { //проверка
                System.out.println(b);
            }
*/
            System.out.println("Обработали число " +array[k] + " и " + arrayResult[k]);
            System.out.println();
        }// конец цикла фор





        int decimal = numberArray * 2; //девятки после запятой

        System.out.println(count9 + decimal);
        //System.out.println(count9 + decimal); //число дополнительных девяток - ОТВЕТ
    }//конец мэйн
}
/*
https://ejudge.rucode.net/rucode2025try
тесты сначала вводим количество чисел для проверки
15 - 2
10 - 3
2023 - 2 // ответ 7

7000 - 5
9800 - 4
1890 - 3
90 - 3
2010 - 3
999 - 2
9000 - 5

 */