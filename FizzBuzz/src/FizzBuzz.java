public class FizzBuzz {
    /*
    Создайте программу, которая выводит числа от 1 до 100.
    Если число делится на 3, выведите 'Fizz'.
    Если число делится на 5, выведите 'Buzz'.
    Если число делится и на 3, и на 5, выведите 'FizzBuzz'.

    ГОТОВО
     */

    public static void main(String[] args) {
        int count = 1; //счетчик
        System.out.println("Start Погнали");

        while (count <= 50){
            if (count % 3 == 0  & count % 5 == 0){ //если делится на 3 и 5 то...(модуль числа 3 и 5 равен нулю)
                System.out.println("FizzBuzz");
                count++;
            }else {
                if (count % 5 == 0){ //если делится на 5 то...(модуль числа 5 равен нулю)
                    System.out.println("Buzz");
                    count++;
                }else{
                    if (count % 3 == 0){ //если делится на 3 то...(модуль числа 3 равен нулю)
                        System.out.println("Fizz");
                        count++;
                    }else {
                        System.out.println(count);
                        count++;
                    }
                }
            }
        }
        System.out.println("End Конец");
    }
}
