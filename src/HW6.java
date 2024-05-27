

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

class ClickEvent extends JFrame implements Runnable {
    JLabel show1; JLabel show2; JLabel show3; JLabel la;
    ImageIcon[] shape = new ImageIcon[4];

    ClickEvent(JLabel show1, JLabel show2, JLabel show3, JLabel la) {
        shape[0] = new ImageIcon("images2/club.png");
        shape[1] = new ImageIcon("images2/diamond.png");
        shape[2] = new ImageIcon("images2/heart.png");
        shape[3] = new ImageIcon("images2/spade.png");
        this.show1 = show1;this.show2=show2;this.show3=show3;
        this.la=la;
    }
    public void run() {
        int random1 = (int) (Math.random() * 4);
        show1.setIcon(shape[random1]);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int random2 = (int) (Math.random() * 4);
        show2.setIcon(shape[random2]);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int random3 = (int) (Math.random() * 4);
        show3.setIcon(shape[random3]);
        if(random1 == random2 && random2 == random3) {
            la.setText("축하합니다!!");
        } else {
            la.setText("아쉽군요");
        }
    }
}
public class HW6 extends JFrame{

    public HW6() {
        setTitle("스레드를 가진 겜블링");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();


        c.add(new MyPanel());
        setSize(500,400);
        setVisible(true);
    }
    public static void main(String[] args) {
        new HW6();
    }
    class MyPanel extends JPanel implements MouseListener {

        JLabel show1 = new JLabel();
        JLabel show2 = new JLabel();
        JLabel show3 = new JLabel();
        JLabel la;

        public MyPanel() {
            addMouseListener(this);
            la = new JLabel("마우스를 클릭할 때마다 게임합니다.");
            la.setFont(new Font(Font.SERIF, Font.BOLD, 20));
            ImageIcon empty = new ImageIcon("images2/intermediate.png");
            show1.setIcon(empty);
            show2.setIcon(empty);
            show3.setIcon(empty);
            setBackground(Color.GRAY);
            add(show1);
            add(show2);
            add(show3);
            add(la);
        }


        @Override
        public void mouseClicked(MouseEvent e) {
            ClickEvent c = new ClickEvent(show1, show2, show3, la);
            Thread t = new Thread(c);
            t.start();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}