package Sorting;

import org.w3c.dom.ls.LSOutput;

public class QuickSort {
    public static void main(String[] args) {
        int [] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        quickSort(array, 0, array.length - 1);//вызываем метод сортировки, передаем массив и начальную с конечной точкой в нем
        System.out.println(arrayToString(array));//выводим в консоль отсортированный массив
    }

    public static void quickSort(int[] arr, int from, int to) {//метод сортировки принимает массив и границы сортировки
        if (from < to) {//от и до, если от меньше до
            int divideIndex = partition(arr, from, to);
            //опорное значение, его возвращает метод partition, там происходит сортировка и разбивка на подмассивы
            quickSort(arr, from, divideIndex - 1);
            //рекурсивно сортируем массив в границах от начала и до опорного значения-1
            quickSort(arr, divideIndex, to);//рекурсивно сортируем  массив в границах с опорного значения и до конца

        }
    }

    private static int partition(int[] arr, int from, int to) {//метод возвращающий опорное значение
        int rightIndex = to;
        int leftIndex = from;
        int pivot = arr[from + (to - from) / 2];//опорное значение из середины массива
        while (leftIndex <= rightIndex) {//цикл выполняется сужая границы массива

            while (arr[leftIndex] < pivot) {
                //цикл если значение в массиве слева меньше опорного то увеличиваем индекс
                //так мы ищем слева большое значение чтобы обменять его с правым значением
                leftIndex++;//то увеличиваем индекс так сужается граница слева
            }
            while (arr[rightIndex] > pivot) {
                //цикл если значение в массиве справа больше опорного
                //так мы ищем в правой части значение меньше опорного чтобы обменять с левым
                rightIndex--;//то сужается граница справа
            }
            if (leftIndex <= rightIndex) {//если найденное левое значение меньше или равно правому то обмениваем
                swap(arr, rightIndex, leftIndex);//делаем обмен местами значений
                leftIndex++;//сужаем границы
                rightIndex--;
            }
        }
        return leftIndex;// левое значение возвращается и становится divideIndex - опорным, это точка встречи по которой далее массив делится пополам и рекурсивно сортируется и делится снова
    }


    private static void swap(int[] array, int index1, int index2) {
        int tmp  = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    private static String arrayToString(int[] array) {// метод вывода на печать массива
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
        }
}


