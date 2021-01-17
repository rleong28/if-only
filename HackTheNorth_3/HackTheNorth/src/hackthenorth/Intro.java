import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Intro extends Scene {
    private Image bg;
    private Image bg2;
    private int subcnt = 0;
    private long time;
    
    public Intro() {
        try {
            bg = ImageIO.read(new File("image/background/titlePg.png"));
            bg2 = ImageIO.read(new File("image/background/titlePg-1.png"));
            // load images here
            throw new IOException("fdjks");
        } catch (IOException e) {}
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        fade(g2d);
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
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 3;
            }
        } else if(subcnt==3) {
            g2d.drawImage(bg2,0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                fade_stage = 2;
                subcnt = 4;
            }
        } else if(subcnt==4) {
            g2d.drawImage(bg2,0,0,null);
            if(fade_stage == 3) {
                transition("intro","instructions");
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
