import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene3_Sub2 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image box2;
    private String curStr = "";
    private Image icon1, icon2;
    private String text;
    
    public Scene3_Sub2() {
        try {
            bg = ImageIO.read(new File("image/background/wedding2.png"));
            box2 = ImageIO.read(new File("image/other/textbox2.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_sister.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_husband.png"));
        } catch (IOException e) { System.out.println(e.getMessage()); }
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if((subcnt==4 || subcnt==8 || subcnt==12 || subcnt==14 || subcnt==16) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
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
            g2d.drawImage(icon1,854,420,null);
            text = "I wish she could have been here for me.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==5) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 6;
                curStr = "";
            }
        } else if(subcnt==6) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "I know how much her presence meant to you. No matter";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 8;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==8) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==8) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "what, I'll always be by your side.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("I know how much her presence meant to you. No matter",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==9) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 10;
                curStr = "";
            }
        } else if(subcnt==10) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon1,854,420,null);
            text = "I just don’t know how we grew so far apart. She didn’t even get";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 11;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==11) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==11) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon1,854,420,null);
            text = "to say her last words to our parents before they passed. I have";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 12;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==12) g2d.drawString(text,70,505);
            g2d.drawString("I just don’t know how we grew so far apart. She didn’t even get",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==12) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon1,854,420,null);
            text = "very few fond memories of her in my life.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("I just don’t know how we grew so far apart. She didn’t even get",70,470);
            g2d.drawString("to say her last words to our parents before they passed. I have",70,505);
            g2d.drawString(curStr,70,540);
        } else if(subcnt==13) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 14;
                curStr = "";
            }
        } else if(subcnt==14) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "Stop dwelling on the past. It’s our special day!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==15) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 16;
                curStr = "";
            }
        } else if(subcnt==16) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon1,854,420,null);
            text = "You’re right. Maybe she’ll come around one day.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==17) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 18;
                curStr = "";
                fade_stage = 2;
            }
        } else if(subcnt==18) {
            if(fade_stage == 3) {
                transition("scene3_sub2","scene3_sub4");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
