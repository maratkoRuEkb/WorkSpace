import java.util.*;
import java.util.function.Consumer;


public class TestRecords {
    public static void main(String[] args) {
        int [] massiv = new int[]{1, 2, 3, 4, 5};

        //String [] m2 = new String[]{"Bob","Tom","Sam"};

        //Consumer<String> stringConsumer = (String) -> System.out.println(m2.toString() + "print");

        for (int i : massiv) {System.out.println(i);}

        Lambdainterface codeBlock = s -> System.out.println(s);
    }
}
@FunctionalInterface
interface Lambdainterface {
    public void doSome(String s);
}// end Lambdainterface