import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HW7 extends JFrame {
    private JLabel monster;
    private JLabel player;
    public HW7() {
        monster = new JLabel("M");
        player = new JLabel("@");
        setTitle("Monster Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        c.add(player);
        c.add(monster);


        Player p = new Player(player);
        Thread t2 = new Thread(p);
        t2.start();
        Monster m = new Monster(monster, p);
        Thread t = new Thread(m);
        t.start();
        c.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                    if (key == KeyEvent.VK_UP) {
                        if(p.getPlayerY() > 10)
                            p.setPlayerY(p.getPlayerY() - 10);
                    } else if (key == KeyEvent.VK_DOWN) {
                        if(p.getPlayerY() < 450)
                            p.setPlayerY(p.getPlayerY() + 10);
                    } else if (key == KeyEvent.VK_LEFT) {
                        if(p.getPlayerX() > 10)
                            p.setPlayerX(p.getPlayerX() - 10);
                    } else if (key == KeyEvent.VK_RIGHT) {
                        if(p.getPlayerX() < 450)
                            p.setPlayerX(p.getPlayerX() + 10);
                    } else if (e.getKeyChar() == 'q') {
                        System.exit(0);
                    }
                    player.setLocation(p.getPlayerX(), p.getPlayerY());
            }

        });

        setSize(500,500);
        setVisible(true);
        setFocusable(true);
        c.requestFocus();
    }

    public static void main(String[] args) {
        new HW7();
    }
}
class Player extends JFrame implements Runnable {
    private JLabel player;
    private int playerX = 100;
    private int playerY = 100;
    public int getPlayerX() {
        return playerX;
    }
    public int getPlayerY() {
        return playerY;
    }
    public void setPlayerX(int x) {
        playerX = x;
    }
    public void setPlayerY(int y) {
        playerY = y;
    }
    Player(JLabel player) {
        this.player = player;
        this.player.setLocation(playerX, playerY);
        this.player.setSize(15,15);
    }
    public void run() {

    }
}
class Monster extends JFrame implements Runnable {
    JLabel monster;
    Player p;
    private int monsterX = 200;
    private int monsterY = 200;
    Monster(JLabel monster, Player p) {
        this.monster = monster;
        this.monster.setLocation(monsterX, monsterY);
        this.monster.setSize(15,15);
        this.p = p;
    }

    public void run() {
        while(true) {
            if (monsterX - p.getPlayerX() > 9) {
                monsterX -= 5;
            } else if (monsterX-p.getPlayerX() < -9){
                monsterX += 5;
            }
            if (monsterY-p.getPlayerY() > 9) {
                monsterY -= 5;
            } else if (monsterY-p.getPlayerY() < -9){
                monsterY += 5;
            }
            monster.setLocation(monsterX,monsterY);
            if (Math.abs(monsterX - p.getPlayerX()) < 10 && Math.abs(monsterY - p.getPlayerY()) < 10) {
                JOptionPane.showMessageDialog(null, "Game Over");
                System.exit(0);
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


