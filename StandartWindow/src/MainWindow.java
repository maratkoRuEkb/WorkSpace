import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private String iconPath;
    private ImageIcon iconFile;
    private JPanel buttonsPanel;
    private JButton start, stop;
    private final int width, height;

    public MainWindow(String winTitle, String path, int w, int h){ //Конструктор с параметрами
        super(winTitle); //Конструктор суперкласса
        iconPath = path;
        width = w;
        height = h;
        iconFile = new ImageIcon(iconPath); //создали объект ImageIcon куда сохранена иконка
        setIconImage(iconFile.getImage()); //устанавливаем иконку
        setSize(width, height);
        buttonsPanel = new JPanel();

        start = new JButton("Start");
        stop = new JButton("Stop");
        ActionListener myButtonsListener = new ButtonsListener();
        start.setActionCommand("Запуск"); //добавили к кнопкам команды
        stop.setActionCommand("Остановка");
        start.addActionListener(myButtonsListener);//добавили к кнопкам слушателя
        stop.addActionListener(myButtonsListener);
        buttonsPanel.add(start);
        buttonsPanel.add(stop);
        getContentPane().add(BorderLayout.NORTH, buttonsPanel);

        JLabel label = new JLabel("Nintendo");
        label.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder(
                        BorderFactory.createLineBorder(Color.GREEN, 2), "Frame Title"),
                BorderFactory.createEmptyBorder(5,10,10,10)));
        // Используем составную рамку:
        //   1. всё та же обводка зелёного цвета с толщиной линии в 2 пикселя
        //   2. дополнительно добавлен заголовок
        //   3. пустая(невидимая рамка) для отступа в 25 пикселей от каждой стороны панели

        JPanel panel = new JPanel();// панель для размещения
        panel.add(label);
        getContentPane().add(BorderLayout.CENTER, panel);

    }//end constructor

    private class ButtonsListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand(); //пришла команда, сохранили в переменную
            if (command.equals("Остановка")){//востанавливаем исходные надписи при остановке
                start.setText("Start");
                stop.setText("Stop");
            }else {
                start.setText("Запущено");
                stop.setText("Остановить");
            }//end if-else
        }
    }//end class ButtonsListener
}//end class MainWindow


