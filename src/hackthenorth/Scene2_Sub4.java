import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene2_Sub4 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image box1, box2;
    private String curStr = "";
    private Image icon1, icon2, icon3;
    private String text;
    
    public Scene2_Sub4() {
        try {
            bg = ImageIO.read(new File("image/background/newyear_1.png"));
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            box2 = ImageIO.read(new File("image/other/textbox2.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_sister.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_mom.png"));
            icon3 = ImageIO.read(new File("image/icons/icon_dad.png"));
        } catch (IOException e) { System.out.println(e.getMessage()); }
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if((subcnt==4 || subcnt==8 || subcnt==10 || subcnt==14 || subcnt==12) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
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
            text = "It doesn’t feel the same when it’s just the 3 of us.";
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
            g2d.drawImage(icon3,854,420,null);
            text = "Don’t dampen the mood. She hasn’t been home for 3 years, who";
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
            g2d.drawImage(icon3,854,420,null);
            text = "knows when we'll see her again.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Don’t dampen the mood. She hasn’t been home for 3 years, who",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==9) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 10;
                curStr = "";
            }
        } else if(subcnt==10) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "I’m hopeful. Maybe she’ll be home next year.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==11) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==11) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 12;
                curStr = "";
            }
        } else if(subcnt==12) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon1,854,420,null);
            text = "Don’t worry, I’ll always make time for you. I love you both so much.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==13) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 14;
                curStr = "";
            }
        } else if(subcnt==14) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon3,854,420,null);
            text = "May our years be happy and prosperous.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==15) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 16;
                fade_stage = 2;
            }
        } else if(subcnt==16) {
            if(fade_stage == 3) {
                transition("scene2_sub4","scene3_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
