import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox {

    JPanel mainPanel; // присваиваем имя для главной панели JPanel
    ArrayList<JCheckBox> checkboxList;// присваиваем имя арайлисту с Чекбоксами
    Sequencer sequencer;//мидипроигрыватель
    Sequence sequence;// мидифайл?
    Track track;//мидитрэк
    JFrame theFrame;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat","Acoustic Snare",// создаем масив строк
            "Crash Cymbal","Hand Clap","High Tom","Hi Bongo","Maracas","Whistle","Low Conga",// с названиями муз
            "Cowbell","Vibraslap","Low-mid Tom","High Agogo","Open Hi Conga",};// инструментов для интерфейса

    int[] instruments = {35,42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};//создаем массив с каналами барабанов.ХЗ

    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    public void buildGUI(){
        theFrame = new JFrame("Cyber BeatBox");//создаем окно с рамкой и надписью
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//вешаем на кнопку Закрыть закрытие программы
        BorderLayout layout = new  BorderLayout();//создаем диспетчера компоновки 5 сторон света
        JPanel background = new JPanel (layout);//создаем контейнер JPanel для хранения и размещения объектов интерфейса и присваиваем ей диспетчера компоновки
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));//делаем границы рамки, отступ от края окна

        checkboxList = new ArrayList<>();//создаем новый список арайлист, он будет хранить флажки
        Box buttonBox = new Box(BoxLayout.Y_AXIS);// ���������, диспетчера компоновки BoxLayout с ориентацией по оси У

        JButton start = new JButton("Start");// создаем кнопку старт
        start.addActionListener(new MyStartListener());// присваиваем слушателя
        buttonBox.add(start);

        JButton stop = new JButton("Stop");// создаем кнопку стоп
        stop.addActionListener(new MyStopListener());//присваиваем слушателя
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");// создаем кнопку "Tempo Up"
        upTempo.addActionListener(new MyUpTempoListener());// присваиваем слушателя
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");// создаем кнопку "Tempo Down"
        downTempo.addActionListener(new MyDownTempoListener());// присваиваем слушателя
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);// Создаем контейнер Бокс с диспетчером по умолчанию BoxLayout � ������������ �������������
        for (int i = 0; i<16; i++){
            nameBox.add(new Label(instrumentNames[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16,16);//создаем диспетчера расположения сетки
        grid.setVgap(1);//вертикальный зазор между компонентами на заданное
        grid.setHgap(2);//горизонтальный зазор между компонентами на заданное
        mainPanel = new JPanel(grid); //создаем главную панель JPanel, запихиваем в нее диспетчера расположения сетки
        background.add(BorderLayout.CENTER, mainPanel); //mainPanel вставили в центр панели

        for (int i=0; i<256; i++){ //цикл создания флажков
            JCheckBox c = new JCheckBox();//новый объект флажок
            c.setSelected(false); //присвоение значения Пусто
            checkboxList.add(c); //добавляем чекбокс в арайлист
            mainPanel.add(c);//добавляем чекбокс на главную панель
        }
        setUpMiDi(); //первоначальная настройка синтезатора

        theFrame.setBounds(50,50,300,300);// как то устанавливает размеры окна
        theFrame.pack(); //сформировали и расчитали окно
        theFrame.setVisible(true); //сделали видимым окно
    } //закрытие метода Билд Гуи

    public void setUpMiDi(){
        try{//пробуем запустить миди проигрыватель
            sequencer = MidiSystem.getSequencer();//присваиваем синтезатор для миди в переменную
            sequencer.open();//открываем синтезатор
            sequence = new Sequence(Sequence.PPQ,4);//создаем объект дорожку и устанавливаем синхроТики PPQ
            track = sequence.createTrack();// создаем новый трэк
            sequencer.setTempoInBPM(120);//устанавливает темп воспроизведения
        } catch (Exception e) {e.printStackTrace();}//ловим любую ошибку
    }//закрываем метод сетапмиди

    public void buildTrackAndStart(){//основной метод создания музыки
        int[] trackList;//создаем массив для хранения инструмента для каждого такта

        sequence.deleteTrack(track);//очищаем память от старой дорожки
        track = sequence.createTrack();//создаем новую дорожку

        for(int i=0; i<16; i++){//(внешний цикл)заполняем ряды в массиве
            trackList = new int[16];
            int key = instruments[i];

            for(int j=0; j<16; j++){//(внутренний цикл) заполняем строки в рядах
                JCheckBox jc = checkboxList.get(j+(16*i));
                if (jc.isSelected()){//проверка флажка в Чекбоксе.
                    trackList[j] = key;//если да то помещаем в ячейку j массива
                }else {
                    trackList[j] = 0;//если нет флажка то инструмент молчит
                }
            }//закрытие внутреннего цикла
            makeTracks(trackList);
            track.add(makeEvent(176,1,127,0,16));
        }//закрытие внешнего цикла

        track.add(makeEvent(192,9,1,0,15));
        try {
            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);//задает колво повторений трека, сейчас непрерывно
            sequencer.start();//запуск воспроизведения
            sequencer.setTempoInBPM(120);
        }catch (Exception e) {e.printStackTrace();}//ловим ошибки исключения
    }//закрываем метод БилдтрэкИстарт

    public class MyStartListener implements ActionListener{//внутренний класс Слушатель для кнопок1
        public void actionPerformed(ActionEvent a){
            buildTrackAndStart();
        }
    }//закрываем внутренний класс1

    public class MyStopListener implements ActionListener{//внутренний класс Слушатель для кнопок2 Стоп
        public void actionPerformed(ActionEvent a){
            sequencer.stop();
        }
    }//закрываем внутренний класс2

    public class MyUpTempoListener implements ActionListener{//внутренний класс Слушатель для кнопок3 Поднять темп
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor*1.03));
        }
    }//закрываем внутренний класс3

    public class MyDownTempoListener implements ActionListener{//внутренний класс Слушатель для кнопок3 Снизить темп
        public void actionPerformed(ActionEvent a){
            float tempoFactor = sequencer.getTempoFactor();
            sequencer.setTempoFactor((float)(tempoFactor*0.97));
        }
    }//закрываем внутренний класс4


    public void makeTracks(int[] list){//метод создает трек
        for (int i=0; i<16; i++){ //начало цикла
            int key = list[i];
            if(key!=0){
                track.add(makeEvent(144,9,key,100,i));
                track.add(makeEvent(128,9,key,100,i+1));
            }
        }//конец цикла
    }//закрываем метод makeTracks

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick){
        MidiEvent event = null;
        try{
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        }catch (Exception e){e.printStackTrace();}
        return event;

    }//закрываем метод makeEvent
}//закрываем класс Битбокс
