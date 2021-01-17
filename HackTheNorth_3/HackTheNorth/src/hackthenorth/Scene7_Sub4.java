import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene7_Sub4 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image box1;
    private Image box2;
    private String curStr = "";
    private Image icon1, icon2;
    private String text;
    private Image player;
    private Image sister;
    
    public Scene7_Sub4() {
        try {
            bg = ImageIO.read(new File("image/background/wedding.png"));
            box1 = ImageIO.read(new File("image/other/textbox2.png"));
            box2 = ImageIO.read(new File("image/other/textbox1.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_sister.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_player.png"));
            sister = ImageIO.read(new File("image/other/sister_bride.png"));
            player = ImageIO.read(new File("image/other/player_mic.png"));
        } catch (IOException e) { System.out.println(e.getMessage()); }
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if((subcnt==5 || subcnt==7 || subcnt==11) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt ++;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
            }
        });
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(bg,0,0,null);
        g2d.drawImage(sister,376,90,null);
        g2d.drawImage(player,480,90,null);
        g2d.setFont(font);
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
            subcnt = 4;
        } else if(subcnt==4) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,22,420,null);
            text = "I can't believe my sister is old enough to get married.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 5;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==5) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==5) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,22,420,null);
            text = "She's still the same smiling 12 year old in my mind.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("I can't believe my sister is old enough to get married.", 180, 470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==6) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 7;
                curStr = "";
            }
        } else if(subcnt==7) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,854,420,null);
            text = "Hey!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==8) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==8) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 9;
                curStr = "";
            }
        } else if(subcnt==9) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,22,420,null);
            text = "Just kidding. I’m so grateful to be your sister and I wish you";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 10;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==10) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==10) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,22,420,null);
            text = "happiness and prosperity for eternity. I'll always be here for you.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 11;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Just kidding. I’m so grateful to be your sister and I wish you", 180, 470);
            if(curStr.length() == 0 && subcnt==11) g2d.drawString(text,70,505);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==11) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,22,420,null);
            text = "Now, let's dance!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Just kidding. I’m so grateful to be your sister and I wish you", 180, 470);
            g2d.drawString("happiness and prosperity for eternity. I'll always be here for you.", 180, 505);
            g2d.drawString(curStr,180,540);
        } else if(subcnt==12) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 18;
                curStr = "";
                fade_stage = 2;
            }
        } else if(subcnt==18) {
            if(fade_stage == 3) {
                transition("scene7_sub4","scene7_sub5");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
