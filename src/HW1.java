import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class HW1 extends JFrame {
    private final JLabel imageLabel;
    private final ImageIcon[] images = new ImageIcon[4];
    int currentImageIdx;
    public HW1() {
        setTitle("Problem");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        for(int i = 0; i < images.length; i++) {
            images[i] = getScaledImage("images/image" + i + ".jpg");
        }
        currentImageIdx = 0;
        imageLabel = new JLabel(images[currentImageIdx]);
        c.add(imageLabel, BorderLayout.CENTER);
        c.add(new MenuPanel(), BorderLayout.SOUTH);
        setSize(300, 400);
        setVisible(true);
    }
    private ImageIcon getScaledImage(String imagePath) {
        Image scaledImage = new ImageIcon(imagePath).getImage().getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING);

        return new ImageIcon(scaledImage);
    }
    class MenuPanel extends JPanel {
        public MenuPanel() {
            setBackground(Color.GRAY);
            ImageIcon leftIcon = new ImageIcon("images/left.png");
            ImageIcon rightIcon = new ImageIcon("images/right.png");
            JButton leftBtn = new JButton(leftIcon);
            JButton rightBtn = new JButton(rightIcon);
            add(leftBtn);
            add(rightBtn);
            leftBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentImageIdx--;
                    currentImageIdx += images.length;
                    currentImageIdx %= images.length;
                    imageLabel.setIcon(images[currentImageIdx]);
                }
            });
            rightBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentImageIdx++;
                    currentImageIdx %= images.length;
                    imageLabel.setIcon(images[currentImageIdx]);
                }
            });

        }
    }
    public static void main(String[] args) {
        new HW1();

    }
}