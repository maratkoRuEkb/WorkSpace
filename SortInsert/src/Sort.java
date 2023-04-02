import java.util.Arrays;

public class Sort {

    public static void main (String[] args){
        int[] massiv = new int[] {48, 32, 24, 3, 59, 18, 99, 20, 5};

        for(int i=1; i<massiv.length; i++){ //
            int index= massiv[i];//
            int temp = i-1;//

            while(temp >= 0 && (massiv [temp]>index)) {//
                massiv[temp+1] = massiv[temp];
                temp--;
            }

            massiv[temp+1] = index;
        }


        System.out.println(Arrays.toString(massiv));

    }

}
