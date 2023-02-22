public class Sort {

    public static void main(String[] args) {
        int[] testArr = new int[]{6, 3, 8, 2, 6, 9, 4, 11, 1};
        minValue(testArr);
        sortBySelect(testArr);
        for (int i : testArr) {
            System.out.println(i);
        }
    }
    public static void sortBySelect(int[] array) {

        for (int i = 0; i < array.length-1; i++) {// внешний обычный  цикл
            int min = i;
            for (int j = i + 1; j < array.length; j++) {// обычный цикл, но с отчетом с сортированных чисел
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            int temp = array[i];// вставка отссортиованного числа, в положеную ему ячейку
            array[i] = array[min];
            array[min] = temp;
        }
    }
    public static void minValue(int[] array){
        int minimum = 0;
        int value = array[0];
        for(int d = 1; d < array.length; d++){
            if(array[d] < value) {
                array[d] = minimum;
                array[d] = value;
            }
        }
        System.out.println("минимальное значение в сратом массиве"+ minimum);
    }
}

