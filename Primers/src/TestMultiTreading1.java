public class TestMultiTreading1 {
    // Управление главным потоком.
    public static void main (String [ ] args){
        Thread t = Thread.currentThread (); //получаем ссылку на текущий поток
        System.out.println("Current tread: " + t); //Текущий поток: Thread[main, 5,maiп]

        t.setName ("My Thread"); // Изменили имя потока
        System.out.println ("New name tread: " + t) ;
        try {
            for (int n = 5; n > 0; n--) {
                System.out.println(n);
                t.sleep(1000);
            }
        }
        catch(InterruptedException e){
                    System.out.println("Главный поток прерван");
        } //end try catch
    }// end main
}// end class