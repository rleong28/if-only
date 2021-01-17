import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene5_Sub3 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private Player player;
    
    public Scene5_Sub3() {
        try {
            bg = ImageIO.read(new File("image/background/bedroom.png"));
        } catch (IOException e) {}
        addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e) {
                if(subcnt==0||subcnt==1) return;
                if(subcnt==2) {
                    if(e.getKeyChar()=='d' || e.getKeyChar()=='D') {
                        player.dir = "right"; 
                    } else if(e.getKeyChar()=='a' || e.getKeyChar()=='A') {
                        player.dir = "left"; 
                    } else if(e.getKeyChar()=='w' || e.getKeyChar()=='W') {
                        player.dir = "up"; 
                    } else if(e.getKeyChar() == 's' || e.getKeyChar()=='S') {
                        player.dir = "down"; 
                    }
                }
            }
            public void keyReleased(KeyEvent e) {
                if(subcnt==0||subcnt==1) return;
                if(subcnt==2) {
                    if(e.getKeyChar()=='d' || e.getKeyChar()=='D') {
                        player.dir = "right_stop"; 
                    } else if(e.getKeyChar()=='a' || e.getKeyChar()=='A') {
                        player.dir = "left_stop"; 
                    } else if(e.getKeyChar()=='w' || e.getKeyChar()=='W') {
                        player.dir = "up_stop"; 
                    } else if(e.getKeyChar() == 's' || e.getKeyChar()=='S') {
                        player.dir = "down_stop"; 
                    }
                }
                if(subcnt==2 && player.x >= 445 && player.x <= 645 && player.y>=435 && player.y<=800 && (e.getKeyChar() == 's' || e.getKeyChar()=='S')) {
                    fade_stage = 2;
                    subcnt = 4;
                }
            }
        });
    }
    public void initialize() {
        player = ((Scene5_Sub1)map.get("scene5_sub1")).player;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont(font);
        g2d.drawImage(bg,0,0,null);
        player.drawPlayer(g2d);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
            }
        } else if(subcnt==2) { 
        } else if(subcnt==4) {
            if(fade_stage == 3) {
                transition("scene5_sub3","scene5_sub4");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
