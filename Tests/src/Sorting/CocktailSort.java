package Sorting;

import java.util.Arrays;
public class CocktailSort {
    public static void main(String[] args) {
        int[] arr = new int[]{6,3,8,2,100,9,-33,4,11,1};// есть массив чисел
        shakerSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shakerSort(int arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

}
