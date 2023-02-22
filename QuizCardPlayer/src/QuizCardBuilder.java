import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class QuizCardBuilder {
    private JTextArea question; //создаем переменные
    private JTextArea answer;
    private ArrayList<QuizCard> cardlist;
    private JFrame frame;

    public static void main (String[] args){
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();//запуск метода формирования интерфейса
    }// end main

    public void go(){// формируем  GUI
        frame = new JFrame("Quiz Card Builder");// главное окно
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);// задаем шрифт

        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);
        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);
        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Следующая карточка");
        cardlist = new ArrayList<QuizCard>();
        JLabel qLabel = new JLabel("Вопрос:");
        JLabel aLabel = new JLabel("Ответ:");

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar=new JMenuBar();
        JMenu fileMenu= new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("new");
        JMenuItem saveMenuItem = new JMenuItem("save");
        newMenuItem.addActionListener(new NewMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }//end go

    public class NextCardListener implements ActionListener {//создается новая карточка
        public void actionPerformed(ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardlist.add(card);// добавляем карточку в массив
            clearCard();// метод очищает поля Вопрос-Ответ
        }//end actionPerformed
    }// end class NextCardListener

    public class SaveMenuListener implements ActionListener{//что происходит при нажатии на кнопку Сохранить в Меню
        public void actionPerformed(ActionEvent ev){
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardlist.add(card);// добавляем карточку в массив
            JFileChooser fileSave = new JFileChooser();//создали объект JFileChooser для выбора файла сохранения
            fileSave.showSaveDialog(frame); // взываем у JFileChooser дилоговое окно
            saveFile(fileSave.getSelectedFile());// вызываем метод saveFile передаем в него выбранный файл
        }//end actionPerformed
    }//end SaveMenuListener

    public class NewMenuListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent ev) {
            cardlist.clear();//очищаем массив с карточками
            clearCard();// метод очищает поля Вопрос-Ответ
        }//end actionPerformed
    }//end NewMenuListener

    private void clearCard(){// метод Очистки карточки
        question.setText("");
        answer.setText("");
        question.requestFocus();//ставим курсор в поле Вопрос
    }// end clearCard

    private void saveFile(File file){
        try{//создаем Буферзаписи передаем в него файлозаписывалку в которую передали получееннный файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(QuizCard card:cardlist){// пробегаем по массиву с карточками
                writer.write(card.getQuestion()+ "/");//карточку записываем в одну строку, разделяя вопрос и ответ /
                writer.write(card.getAnswer()+"\n");// в конце ставим символ новой строки
            }// конец цикла
            writer.close();// закрыть writer
        }catch (IOException ex){
            System.out.println("запись карточек невозможна");
            ex.printStackTrace();
        }//end try-catch
    }//end saveFile
}// end QuizCardBuilder
