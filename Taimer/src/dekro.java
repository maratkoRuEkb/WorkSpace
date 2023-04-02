public class dekro {

    public static void main(String[] args) {
        int a = 1;
        int b = a++;// в "b" записалось "а=1", далее "а+1" и в "а" записалось новое значение, теперь "а=2".
        int c = ++a;// сначало происходит инкремент "а+1" теперь "а=3" и в "с" записалось "3",
        c++;// с=3+1
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
    }
}
