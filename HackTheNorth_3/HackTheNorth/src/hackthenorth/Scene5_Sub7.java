import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene5_Sub7 extends Scene {
    private Image bg;
    private Image bg2;
    private int subcnt = 0;
    private long time;
    
    public Scene5_Sub7() {
        try {
            bg = ImageIO.read(new File("image/other/heart.png"));
            bg2 = ImageIO.read(new File("image/other/heart_1.png"));
        } catch (IOException e) {}
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(0,0,0));
        g2d.drawImage(bg,0,0,null);
        
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) { 
            
            
            if(System.currentTimeMillis() - time > 3000) {
                subcnt = 3;
                time = System.currentTimeMillis();
                fade_stage = 2;
            }
        } else if(subcnt==3) {
            if(fade_stage == 3) {
                transition("scene5_sub7","scene6_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
