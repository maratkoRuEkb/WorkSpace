//пример кода. Два потока через интерфейс Runnable
public class TestMultiTreading2 implements Runnable {
    Thread t;

    TestMultiTreading2() {//constructor
        t = new Thread(this, "Demo Thread"); // Через конструктор создается новый объект Thread.
        System.out.println("Child Thread: " + t);
    }

    public void run() { // Это точка входа для второго потока.
        System.out.println("second starter");
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("second Thread: " + i);
                Thread.sleep(500);
            }//end for
        } catch (InterruptedException е) {
            System.out.println("second Thread interrupted.");
        }//end try catch
            System.out.println("End second Thread.");
        }//end run
    }//end class

class ThreadDemo {
    public static void main(String[] args) {
        TestMultiTreading2 nt = new TestMultiTreading2(); // создать дочерний поток
        nt.t.start(); //Обращаемся в объекте nt к переменной t, содержащей ссылку на новый объект Thread и запускаем в нем метод start
        try { //тут в главном потоке работает цикл с счетчиком и парралельно работает дочерний поток из объекта nt
            for (int i = 5; i > 0; i--) {
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }//end for
        } catch (InterruptedException e) {
            System.out.println("Main Thread interrupted. "); //эксепшн Главный поток прерван
        }//end try catch
        System.out.println("End main Thread . ");
    }//end main
}//end class


