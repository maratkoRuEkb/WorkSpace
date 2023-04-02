package Sorting;

public class BubbleSort2 {
    //сортировка массива методом пузырька С ФЛАЖКОМ
    public static void main(String[] args) {
        int[] array = new int[]{6,3,8,2,100,9,4,11,1};// есть массив чисел
        bubbleSort(array);//вызвали метод пузырьковой сортировки, передали в него массив
        for (int i : array) {// распечатали массив на экран
            System.out.print(i+" ");
        }
    }
    public static void bubbleSort(int[] array) { //это сам метод пузырьковой сортировки
        boolean isSorted = false; //флажок если тру то массив отсортирован
        while (!isSorted) { // пока флажок нетру (пока неотсортирован)заходим в цикл
            isSorted = true; // меняем флажок на тру, если обмена значений не будет, то массив отсортирован
            for (int i = 1; i < array.length; i++) { //перебираем элементы в цикле
                if (array[i - 1] > array[i]) { //если левое число больше правого то выполняется обмен
                    int tmp = array[i]; //меняем местами значения если слева больше чем справа - метод `Swap`
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false; //меняем флажок на фолс, был обмен значений, значит массив еще неотсортирован
                }
            }
        }
    }
}

