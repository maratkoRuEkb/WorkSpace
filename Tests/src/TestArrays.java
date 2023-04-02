import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestArrays {
    public static void main(String[] args) {

        List<String> fraza= new ArrayList<>();
        System.out.println("список fraza создан");

        fraza.add("Fuck");
        fraza.add("you");
        fraza.add("ass");

        List<String> fraza2 = Arrays.asList("Go", "Putin", "you", "super");

        //преобразуем в массив
        String[] mas1 = new String[fraza.size()];//создали пустой массив с длинной равной списку
        for(int i=0; i<fraza.size(); i++){
            mas1[i] = fraza.get(i);
        }
        System.out.println(mas1[0]);

        //String[] mas2 = new String[fraza2.size()];
        String[] mas2 = fraza2.toArray(new String[5]);//применили на списке метод toArray,

        System.out.println("печать целого массива");
        for(String s:mas2){
        System.out.print(s+" ");
        }

    }

}
