import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;



public class QuizCardPlayer {
    private JTextArea display;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private QuizCard currentCard;
    private int currentCardIndex;
    private JFrame frame;
    private JButton nextButton;
    private boolean isShowAnswer;

    public static void main (String[] args){
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();// запуск метода формирования интерфейса и игры
    }// end main

    public void go(){ //формируем GUI
        frame = new JFrame ("Викторина"); //создаем окно с надписью Викторина
        JPanel mainPanel = new JPanel();// создали главную панель
        Font bigFont = new Font("sanserif", Font.BOLD, 24);

        display = new JTextArea(10,20);// создали текстовое поле
        display.setFont(bigFont);
        display.setLineWrap(true);
        display.setEditable(false);

        JScrollPane qScroller = new JScrollPane(display);//на скроллпанели разместили Дисплей
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        nextButton = new JButton("Показать вопрос");//создали кнопку
        mainPanel.add(qScroller);//добавили текстовое поле -Дисплей- со скроллингом на главную панель
        mainPanel.add(nextButton);//добавили кнопку Показать вопрос на главную панель
        nextButton.addActionListener(new NextCardListener());//к кнопке привязали слушателя и создали класс

        JMenuBar menuBar = new JMenuBar();// создали полоску меню
        JMenu fileMenu = new JMenu("File");//создали кнопку Меню
        JMenuItem loadMenuItem = new JMenuItem("Load card set");//создали пункт меню загрузка
        loadMenuItem.addActionListener(new OpenMenuListener());//назначили слушателя на кнопку загрузки
        fileMenu.add(loadMenuItem);//добавили в меню кнопку Загрузить
        menuBar.add(fileMenu);//добавили в полоску меню кнопку Меню
        frame.setJMenuBar(menuBar);//добавили в главное окно полоску меню
        frame.getContentPane().add(BorderLayout.CENTER,mainPanel);//разсестили в окне главную панель
        frame.setSize(640, 500);//установили размеры окна
        frame.setVisible(true);// сделали окно видимым
        }//end go

    public class NextCardListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            if(isShowAnswer){// если показываем ответ isShowAnswer-тру то
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;// переменную меняем на ложь
            } else {
                if(currentCardIndex<cardList.size()){// если счетчик карточек меньше кол-ва карточек в массиве
                    showNextCard();// показать следующую карточку
                } else {// если карточки кончились то
                    display.setText("Это была последняя карточка");
                    nextButton.setEnabled(false);
                }// end 2 ветвление
            }//end 1 ветвление
        }// end actionPerformed
    }//end NextCardListener

    public class OpenMenuListener implements ActionListener{//класс вызова окна выбора файла
        @Override
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();//новый объект выбиратель файла
            fileOpen.showOpenDialog(frame);
            loadFile(fileOpen.getSelectedFile());//запуск метода loadFile
        }// end actionPerformed
    }//end OpenMenuListener

    private void loadFile(File file){// метод при загрузке файла считывает и создает массив с карточками
        cardList = new ArrayList<QuizCard>();//создаем массив с карточками QuizCard
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));//создали буферчиталку и передали в него файлочиталку, в который передали файл
            String line = null;//временная переменная для хранения данных буфера из файла
            while ((line = reader.readLine()) != null){//цикл считываем строку из файла присваиваем ее в line, пока она не равна 0 цикл повторяем
                makeCard(line);//в цикле создаем карточку методом, передаем в него строку из line
            }//конец цикла
            reader.close();//закрываем цикл после того как он отработал
        } catch (Exception ex){//ловим ошибку
            System.out.println("невозможно прочитать файл");
            ex.printStackTrace();//
        }//конец try-catch
    }//end loadFile

    private void makeCard (String lineToParse){// в методе создаем карточки, принимаем загруженную строку присваиваем тип Строка и имя lineToParse
        String[] result = lineToParse.split("/");// в переменной массива сохраняем лексемы разделитель будет /
        QuizCard card = new QuizCard(result[0], result[1]);//создаем
        cardList.add(card);
        System.out.println("создана карточка");
    }// end makeCard

    private void showNextCard(){// метод показать следующую карточку
        currentCard = cardList.get(currentCardIndex);//достаем из массива карточку согласно индексу
        currentCardIndex++// увеличиваем индекс на +1
        display.setText(currentCard.getQuestion());// из текущей карточки показываем вопрос
        nextButton.setText("Показать ответ");// меняем название кнопки
        isShowAnswer = true;// меняем переменную isShowAnswer на правду
    }// end showNextCard
}//конец класса QuizCardPlayer
