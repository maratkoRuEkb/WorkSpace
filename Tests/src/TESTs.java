

public class TESTs {
//сортировка массива методом пузырька
    public static void main(String[] args) {
        int[] testArr = new int[]{6,3,8,2,100,9,4,11,1};// есть массив чисел
        bubbleSort(testArr);//вызвали метод пузырьковой сортировки, передали в него массив
        for (int i : testArr) {// распечатали массив на экран
            System.out.print(i+" ");
        }
    }

    public static void  bubbleSort(int[] array) { //это сам метод пузырьковой сортировки
        for(int i = array.length -1; i >= 1; i--) { //внешний цикл, бежим по ячейкам
            // с каждым проходом i-- уменьшаем неотсортированную область
            for (int j = 0; j < i; j++) { //внутренний цикл
                if (array[j] > array[j+1]) { //если левое число больше правого то выполняется обмен
                    int temp = array[j];//меняем местами значения если слева больше чем справа - метод `Swap`
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
}