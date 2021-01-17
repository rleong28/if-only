import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene5_Sub2 extends Scene {
    private Image bg[];
    private int subcnt = 0;
    private long time;
    
    public Scene5_Sub2() {
        bg = new Image[5];
        try {
            for(int i=0; i<5; i++) {
                bg[i] = ImageIO.read(new File("image/phone2/"+(i+1)+".png"));
            }
        } catch (IOException e) {}
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(100,100,100));
        g2d.fillRect(0,0,1000,600);
        g2d.drawImage(bg[0],0,-25,null);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) {
            if(System.currentTimeMillis() - time > 4000) {
                subcnt = 3;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==3) {
            g2d.drawImage(bg[1],0,-25,null);
            if(System.currentTimeMillis() - time > 4000) {
                subcnt = 4;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==4) {
            g2d.drawImage(bg[2],0,-25,null);
            if(System.currentTimeMillis() - time > 4000) {
                subcnt = 5;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==5) {
            g2d.drawImage(bg[3],0,-25,null);
            if(System.currentTimeMillis() - time > 4000) {
                subcnt = 6;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==6) {
            g2d.drawImage(bg[4],0,-25,null);
            if(System.currentTimeMillis() - time > 4000) {
                subcnt = 7;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==7) { 
            g2d.drawImage(bg[4],0,-25,null);
            if(System.currentTimeMillis() - time > 4000) {
                subcnt = 8;
                time = System.currentTimeMillis();
                fade_stage = 2;
            }
        } if(subcnt==8) {
            g2d.drawImage(bg[4],0,-25,null);
            if(fade_stage == 3) {
                transition("scene5_sub2","scene5_sub3");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
