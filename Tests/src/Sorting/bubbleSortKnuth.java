package Sorting;

public class bubbleSortKnuth {
    public static void main(String[] args) {
        int[] array = new int[]{6,3,8,2,100,9,4,11,1};// есть массив чисел
        bubbleSortKnuth(array);//вызвали метод пузырьковой сортировки, передали в него массив
        for (int i : array) {// распечатали массив на экран
            System.out.print(i+" ");
        }
    }

    public static int bubbleSortKnuth(int[] array) {
        int count = 0;
        int k = 1;
        int j = array.length;
        while (k > 0) {
            k = 0;
            for (int i = 1; i < j; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    k = i;
                }
                count++;
            }
            j = k;
        }
        return count;
    }
}
