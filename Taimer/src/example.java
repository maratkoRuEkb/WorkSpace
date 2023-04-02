    import javax.swing.*;

    class example{
        example(){//конструктор
            JFrame a = new JFrame("example");
            JScrollBar b = new JScrollBar(); //Скрол панель
            b.setBounds(90,90,40,90);
            a.add(b);
            a.setSize(300,300);
            a.setLayout(null);
            a.setVisible(true);
        }

        public static void main(String args[]){
            new example();
        }
    }



