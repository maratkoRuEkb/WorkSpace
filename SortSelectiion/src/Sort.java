import java.util.Arrays;

public class Sort {

    public static void main (String[] args){

        int[] massiv = new int[] {48, 32, 24, 3, 59, 18, 99, 20, 5};

        for(int i=0; i<massiv.length; i++){//бежим по масиву
            int pos = i;
            int min = massiv[i];
            for (int j = i+1; j < massiv.length; j++){//цикл выбора наименьшего элемента, ищем в неотсорт части
                if(massiv [j]<min) {
                    pos = j;//индекс наименьшего элемента
                    min = massiv[j];
                }// end if
            }
            massiv [pos] = massiv[i];
            massiv [i] = min;
        }//end for1

        System.out.println(Arrays.toString(massiv));
    }
}
