package Sorting;

public class BubbleSort3 {
    public static void main(String[] args) {
        int[] array = new int[]{6,3,8,2,100,9,4,11,1,0,0,422,11,-3,49};// есть массив чисел
        Sort(array);//вызвали метод пузырьковой сортировки, передали в него массив
        for (int i : array) {// распечатали массив на экран
            System.out.print(i+" ");
        }
    }

    public static void Sort(int[] items) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < items.length; i++) {
                if (items[i - 1]- (items[i]) > 0) {
                    Swap(items, i - 1, i);
                    swapped = true;
                }
            }
        } while (swapped != false);
    }

    static void Swap(int[] items, int left, int right)
    {
        if (left != right)
        {
            int temp = items[left];
            items[left] = items[right];
            items[right] = temp;
        }
    }
}
