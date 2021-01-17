import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene1_Sub1 extends Scene {
    private Image bg;
    private int subcnt = 0;
    public Player player;
    private long time;
    private String curStr = "";
    private Image box1;
    private Image icon1;
    private String text;
    private Image phone;
    private long time2;
    private boolean on = false;
    
    public Scene1_Sub1() {
        try {
            bg = ImageIO.read(new File("image/background/bedroom.png"));
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
            phone = ImageIO.read(new File("image/background/phone_screen.png"));
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
                if(subcnt==2 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && player.x>=200 && player.x<=350 && player.y>=50 && player.y<=300 && player.dir.startsWith("up")) {
                    fade_stage = 2;
                    subcnt = 4;
                } 
                if(subcnt==2 && player.x >= 445 && player.x <= 645 && player.y>=435 && player.y<=800 && (e.getKeyChar() == 's' || e.getKeyChar()=='S')) {
                    subcnt = 5;
                }
                if((subcnt==6) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt = 2;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
            }
        });
        player = new Player(600,140);
        int[] x1 = {0,0,0,645,944,0,470,770,0,}, y1 = {-100,0,586,586,0,700,0,0,0,}, x2 = {1000,56,445,1000,1000,1000,680,1000,290}, y2 = {14,600,1000,1000,1000,800,100,200,100};    
        player.x1 = x1; player.y1 = y1; player.x2 = x2; player.y2 = y2;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setFont(font);
        g2d.drawImage(bg,0,0,null);
        if(System.currentTimeMillis() - time2 > 1500) {
            on = ! on;
            time2 = System.currentTimeMillis();
        }
        if(on) g2d.drawImage(phone,0,0,null);
        player.drawPlayer(g2d);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time2 = System.currentTimeMillis();
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) { 
            g2d.setFont(font.deriveFont(20.0f));
            if(player.x>=200 && player.x<=350 && player.y>=50 && player.y<=300 && player.dir.startsWith("up")) {
                g2d.drawString("Press X to interact.", 20, 35);
            }
            g2d.setFont(font);
        } else if(subcnt==4) {
            if(fade_stage == 3) {
                transition("scene1_sub1","scene1_sub2");
            }
        } else if(subcnt==5) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "You have a new message. You should check your phone";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 6;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==6) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==6) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "before leaving.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("You have a new message. You should check your phone",180,470);
            g2d.drawString(curStr,180,505);
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
