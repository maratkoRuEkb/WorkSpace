package Sorting;

public class CombSort {
    public static void main(String[] args) {
        int[] array = new int[]{6,3,8,2,100,9,4,11,1,-33,-54};// есть массив чисел
        sort(array);//вызвали метод пузырьковой сортировки, передали в него массив
        for (int i : array) {// распечатали массив на экран
            System.out.print(i+" ");
        }
    }

    static int getNextGap(int gap)  {  // высчитываем пробел между элементами
        gap = (gap*10)/13;// вместо 1,24 (требует тип double или float, используем целые инты
        if (gap < 1)
            return 1;
        return gap;
    }

    static void sort(int arr[]) { // метод сортировки
        int n = arr.length;
        int gap = n; // инициализируем пробел
        boolean swapped = true; // флажок обмена элем
        while (gap != 1 || swapped == true)  {//цикл бежит пока пробел больше 1 и был обмен элем.
            gap = getNextGap(gap);// получаем следующий пробел
            swapped = false;//флажок ставим на неправда
            for (int i=0; i<n-gap; i++){//сравниваем элементы с текущим пробелом
                if (arr[i] > arr[i+gap]) {// если  текущий элемент больше элемент+пробел то делаем обмен
                    int temp = arr[i];
                    arr[i] = arr[i+gap];
                    arr[i+gap] = temp;

                    // Set swapped
                    swapped = true; //флажок ставим на правда
                }
            }
        }
    }
}

