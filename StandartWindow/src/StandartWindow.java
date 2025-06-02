import javax.swing.*;

//заготовка для стандартного окна с кнопками


public class StandartWindow {
    public static void main(String[] args) {
        MainWindow  mainWindow = new MainWindow("My Programm", "src/Resources/icon.png", 300,300);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false); //неизменяемый размер окна
        mainWindow.setLocationRelativeTo(null); //окно - в центре экрана
        mainWindow.setVisible(true);


    }
}
