import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene4_Sub2 extends Scene {
    private int subcnt = 0;
    private long time;
    private String curStr = "";
    
    public Scene4_Sub2() {
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(10,10,10));
        g2d.setFont(font.deriveFont(30.0f));
        g2d.fillRect(0,0,1000,600);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=10;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==10) {
            String text = "If I could redo my life... I wonder...";
            if(curStr.length() < text.length() && System.currentTimeMillis() - time >= 70) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length() && System.currentTimeMillis() - time >= 700) {
                time = System.currentTimeMillis();
                subcnt = 3;
                fade_stage = 2;
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,100,200);
        }else if(subcnt==3) {
            g2d.setColor(Color.WHITE);
            g2d.drawString("If I could redo my life... I wonder...",100,200);
            if(fade_stage == 3) {
                transition("scene4_sub2","scene5_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
