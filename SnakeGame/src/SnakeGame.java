/*
Логика игры:

есть поле из клеточек, где случайным образом появляется еда;
Создать GUI,
поле,
метод случайной генерации еды

есть змейка, которая всё время двигается и которой мы можем управлять;
Создать объект змейку,
метод движения вперед,
управление.

если змейка на своём пути встречает еду — еда исчезает, появляется в новом месте, а сама змейка удлиняется на одну клеточку;
Условие поедание еды и удлинение змейки


если змейка врежется в стену или в саму себя, игра заканчивается.
или змейка не врезается в стенки, а проходит сквозь них.
 */

import javax.swing.*;

public class SnakeGame {
    Snake snake;
    Food food;
    JFrame frame;
    Canvas canvasPanel;
    Random random = new Random();
    boolean gameOver = false;

    public static void main(String[] args) {
        SnakeGame game = new SnakeGame();
        game.gui();
        }//end main

    void gui(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }//end gui
}//end class SnakeGame

