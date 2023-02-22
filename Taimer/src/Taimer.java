import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ConcurrentMap;
import java.awt.event.*;

public class Taimer extends Timer{
    /**
     * Creates a {@code Timer} and initializes both the initial delay and
     * between-event delay to {@code delay} milliseconds. If {@code delay}
     * is less than or equal to zero, the timer fires as soon as it
     * is started. If <code>listener</code> is not <code>null</code>,
     * it's registered as an action listener on the timer.
     *
     * @param delay    milliseconds for the initial and between-event delay
     * @param listener an initial listener; can be <code>null</code>
     * @see #addActionListener
     * @see #setInitialDelay
     * @see #setRepeats
     */
    public Taimer(int delay, ActionListener listener) {
        super(delay, listener);
    }

    public static void main(String[] args) {

        Taimer gui = new Taimer();
                gui.go();

    }

    public void go() {
        JFrame frame = new JFrame("ТАЙМЕР БЛЯ");
        JPanel panelMain = new JPanel();
        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.yellow);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        //panel1.setSize(200, 200);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.blue);
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));

        JButton buttonStartUser1 = new JButton("Start");
        panel1.add(buttonStartUser1);
        //ButtonStartUser1.addActionListener(this);

        JButton buttonStopUser1 = new JButton("Stop");
        panel2.add(buttonStopUser1);

        //panelMain.add(panel1);
        //panelMain.add(panel2);

        frame.add(BorderLayout.CENTER, panel1);
        frame.getContentPane().add(BorderLayout.NORTH, panel2);

        //frame.getContentPane().add(buttonStopUser1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(300, 400);
        frame.setVisible(true);

    }


}
