package Easy_Moving;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
public class EasyMoving extends JPanel implements KeyListener{
    private BufferedImage image,image2;
    private Timer timer ;
    int x = 0 , y = 0,xy2;
    EasyMoving () throws IOException {
        image = ImageIO.read(new File("src/Easy_Moving/grass.jpg"));
        image2 = ImageIO.read(new File("src/Easy_Moving/3.png"));
        addKeyListener(this);
        setFocusable(true);
    }
    public void paint(Graphics g){
        super.paintComponent(g);
        setSize(800,800);
        g.drawImage(image, 0, 0,800,800,null);
        g.drawImage(image2, x, y, 50,50,null);
    }
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Простое перемещение");
        frame.getContentPane().add(new EasyMoving());
        frame.setSize(800,800);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isShiftDown()){
            xy2 = 100;
        }
        else {xy2 = 50;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        x-=xy2;
        repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x+=xy2;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y-=xy2;
            repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y+=xy2;
            repaint();
        }
        if (x >= 800 || y >= 800 ){
            x = 0;
            y = 0;
            repaint();
        }
        if (x < 0 || y < 0){
            x = 0;
            y = 0;
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {  }
    }