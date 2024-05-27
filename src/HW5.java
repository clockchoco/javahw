import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class HW5 extends JFrame {


    public HW5() {
        setTitle("디지털 시계 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JLabel la = new JLabel();
        la.setFont(new Font(la.getFont().getFontName(),la.getFont().getStyle(),la.getFont().getSize() + 20));
        Clock cc = new Clock(la);
        Thread t= new Thread(cc);
        c.add(la);
        setSize(250,100);
        setVisible(true);

        t.start();
    }

    public static void main(String[] args) {
        new HW5();
    }
}

class Clock implements Runnable {
    private JLabel la;
    int hour;
    int min;
    int second;
    Clock(JLabel la) {
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        min = calendar.get(Calendar.MINUTE);
        second = calendar.get(Calendar.SECOND);
        this.la = la;
    }
    @Override
    public void run() {
        while(true) {
            if (second >= 60) {
                second = 0;
                min += 1;
            }
            if (min >= 60) {
                min = 0;
                hour += 1;
            }
            if (hour >=24) hour = 0;
            la.setText(hour + ":" + min + ":" + second);
            try {
                Thread.sleep(1000);
                second++;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
