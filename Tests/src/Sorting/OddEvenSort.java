package Sorting;

public class OddEvenSort {
    public static void main(String[] args) {
        int[] array = new int[]{6, 3, 8, 2, 100, 9, 4, 11, 1,-33};// есть массив чисел
        OddEvenSort(array);//вызвали метод пузырьковой сортировки, передали в него массив
        for (int i : array) {// распечатали массив на экран
            System.out.print(i + " ");
        }
    }

    public static void OddEvenSort(int[] array) {
        for (int i = 0; i < array.length; i++) {// цикл бежим по массиву
            if (i % 2 == 0) { // НЕЧЕТНАЯ итерация, проверка остатка от деления по модулю
                for (int j = 0; j <= array.length - 2; j = j + 2) {
                    // условие j <= array.length - 2 нужно чтобы array[j+1] не выходило за
                    // пределы массива (не больше array.length-1)
                    // j = j+2 для перехода к следующей паре для сравнения
                        if (array[j] > array[j + 1]) { //если левое число больше правого то выполняется обмен
                        int temp = array[j];//меняем местами значения если слева больше чем справа - метод `Swap`
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
            else { // ЧЕТНАЯ итерация
                for (int j = 1; j <= array.length - 2; j = j + 2) {
                    if (array[j] > array[j + 1]) { //если левое число больше правого то выполняется обмен
                        int temp = array[j];//меняем местами значения если слева больше чем справа - метод `Swap`
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }//конец if-else
        }//конец цикла фор
    }// конец метода сортировки
}//конец класса