import java.io.InputStream;
import java.util.Scanner;

public class ConverterNDS {
    public static void main(String[] args) {
        double nds =1.2;

        InputStream stream = System.in;
        Scanner console = new Scanner(stream);
        String line = console.nextLine();  // тип данных строка, надо преобразовать в double и передать в Calculation
        System.out.println(Calculation);


        public double Calculation(nds, (double) line){
            double value = line/nds; //ругается что стринг и дабл хочу поделить.
            System.out.println(value);
        }




        }
    }

}
