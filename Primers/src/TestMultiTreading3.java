public class TestMultiTreading3 implements  Runnable{
    // Создание множества потоков.
    String name; // имя: потока
    Thread t;
    TestMultiTreading3 (String threadname) {//constructor получает имя и создает новый поток
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Create new thread: " + t);
    }//end constructor

        public void run() {// Это точка входа для: потока.
            try {
                for (int i = 5; i > 0; i--) {
                    System.out.println(name + ": " + i);
                    Thread.sleep(1000);
                }//end for
            } catch (InterruptedException e) {
                System.out.println(name + " прерван");
            }//end try/catch
            System.out.println(name + " end work.");
        }//end run
    }//end class TestMultiTreading3
class MultiThreadDemo {
    public static void main (String[] args) {
        TestMultiTreading3 nt1 = new TestMultiTreading3 ( "One") ;
        TestMultiTreading3 nt2 = new TestMultiTreading3 ( "Two" ) ;
        TestMultiTreading3 nt3 = new TestMultiTreading3 ( "Three") ;
// Запуск потоков.
        nt1.t.start() ;
        nt2.t.start() ;
        nt3.t.start() ;

            try {
            Thread.sleep(10000);// Ожидать окончания остальных потоков.
            }catch(InterruptedException e) {
                System.out.println("Глaвный поток прерван");
            }//end try/catch
        System.out.println("End main thread.");
    }//end main
}//end class MultiThreadDemo