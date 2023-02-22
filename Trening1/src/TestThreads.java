public class TestThreads {

    public static void main(String[] args) {
        ThreadOne t1 = new ThreadOne();
        Thread one = new Thread(t1);
        ThreadTwo t2 = new ThreadTwo();
        Thread two = new Thread(t2);
        one.start();
        two.start();

    }//end main
}// end TestThreads

    class Accum{
        private static Accum a = new Accum();//создаем статический экземпляр класса
        private int counter = 0;
        private Accum(){}//приватный конструктор

        public static Accum getAccum(){//геттер дай-экземпляр класса, а он СТАТИЧЕСКИЙ
            return a;
        }//end getAccum

        public int getCount(){//геттер дай counter
            return counter;
        }//end getCount

        public void updateCounter(int add){//метод ничего не возвращает, он считает counter
            counter += add;
        }//end updateCounter
    }//end Accum

    class ThreadOne implements Runnable {
        Accum a = Accum.getAccum();// создаем экз класса через геттер

        public void run() {
            for (int x = 0; x < 98; x++) {
                a.updateCounter(1000);

                try {//1 try
                    Thread.sleep(1);


                } catch (InterruptedException ex) {
                }//end try
                }//end for
            System.out.println("один " + a.getCount());
        }//end run
    }//end ThreadOne
    class ThreadTwo implements Runnable {
        Accum a = Accum.getAccum();// создаем экз класса через геттер
        public void run(){
           for(int x=0; x<99; x++){
                a.updateCounter(2);
            try{//2 try
            Thread.sleep(1);
           }catch (InterruptedException ex){
        }//end try
           }//end for

            System.out.println("два "+a.getCount());
        }//end run

    }//end ThreadTwo


