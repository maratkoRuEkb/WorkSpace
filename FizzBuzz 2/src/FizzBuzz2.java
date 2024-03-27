public class FizzBuzz2 {
    /*
    Создайте программу, которая выводит числа от 1 до 100.
    Если число делится на 3, выведите 'Fizz'.
    Если число делится на 5, выведите 'Buzz'.
    Если число делится и на 3, и на 5, выведите 'FizzBuzz'.

    ГОТОВО - Это будет вторая вариация как правильно типо ВСЕ РАБОТАЕТ
     */

    public static void main(String[] args) {
        final  int MAX_COUNT = 50; //константа максимального счетчика
        System.out.println("Start Погнали");

        for (int i = 1; i <= MAX_COUNT;i++){
            if (i % 3 == 0) { //если делится на 3 то...(модуль числа 3 равен нулю)
                if (i % 5 == 0) { //если делится на 5 то это физбуз (модуль числа 5 равен нулю)
                    System.out.println("FizzBuzz");
                } else { //иначе просто Физ
                    System.out.println("Fizz");
                }
            }else if (i % 5 == 0) { //если делится на 5 то это Буз (модуль числа 5 равен нулю)
                    System.out.println("Buzz");
                } else {// иначе просто печатаем номер
                System.out.println(i);
            }
            }//цикл фор
        System.out.println("End");
        }//майн

}// класс

