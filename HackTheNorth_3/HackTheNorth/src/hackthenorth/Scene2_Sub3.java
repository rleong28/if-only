import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene2_Sub3 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image box1, box2;
    private String curStr = "";
    private Image icon1, icon2;
    private Player player;
    private String text;
    
    public Scene2_Sub3() {
        try {
            bg = ImageIO.read(new File("image/background/office_2.png"));
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            box2 = ImageIO.read(new File("image/other/textbox2.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_boss.png"));
        } catch (IOException e) { System.out.println(e.getMessage()); }
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(subcnt==2 || subcnt==3 || subcnt==10) {
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
                if(subcnt==2 || subcnt==3 || subcnt==10) {
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
                if(subcnt==3 && player.x >= 510 && player.x <= 620 && player.y >= 60 && player.y <= 130 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && player.dir.startsWith("up")) {
                    subcnt = 4;
                }
                if(subcnt==3 && player.x >= 912 && player.x <= 1200 && player.y>=0 && player.y<=1000 && (e.getKeyChar() == 'd' || e.getKeyChar()=='D')) {
                    subcnt = 22;
                }
                if(subcnt==22 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt = 3;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
                if(subcnt==10 && player.x >= 912 && player.x <= 1200 && player.y>=0 && player.y<=1000 && (e.getKeyChar() == 'd' || e.getKeyChar()=='D')) {
                    subcnt = 11;
                    fade_stage = 2;
                }
                if((subcnt==5 || subcnt==7 || subcnt==9) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt ++;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
            }
        });
        player = new Player(900,200);
        int[] x1 = {0,0,0,944,944,0,0,320,1050,840,}, y1 = {-100,0,586,0,510,0,0,0,0,0,}, x2 = {1000,56,1000,1200,1200,130,168,630,1200,1000,}, y2 = {14,600,1000,180,1000,110,280,115,700,80};    
        player.x1 = x1; player.y1 = y1; player.x2 = x2; player.y2 = y2;
        player.dir = "left_stop";
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(bg,0,0,null);
        g2d.setFont(font);
        player.drawPlayer(g2d);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) { 
            if(System.currentTimeMillis() - time > 1000) {
                subcnt = 3;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==3) {
            g2d.setFont(font.deriveFont(20.0f));
            if(player.x >= 510 && player.x <= 620 && player.y >= 60 && player.y <= 130 && player.dir.startsWith("up")) {
                g2d.drawString("Press X to interact.", 20, 35);
            }
            g2d.setFont(font);
        } else if(subcnt==4) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "As I promised, I talked to HR and secured you a $5000 pay raise";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 5;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==5) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==5) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "and a promotion to Project Manager. Keep up the good work!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("As I promised, I talked to HR and secured you a $5000 pay raise",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==6) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 7;
                curStr = "";
            }
        } else if(subcnt==7) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "I can't thank you enough. I couldn't ask for a better boss.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==8) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 9;
                curStr = "";
            }
        } else if(subcnt==9) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "We'll be working closely in the future. Welcome to the big leagues.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==10) {
        } else if(subcnt==11) {
            if(fade_stage == 3) {
                transition("scene2_sub3","scene2_sub4");
            }
        } else if(subcnt==22) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "You need to talk to your boss before leaving.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
            
        } 
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
