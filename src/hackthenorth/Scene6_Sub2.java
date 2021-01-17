import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene6_Sub2 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image box1, box2;
    private String curStr = "";
    private Image icon1, icon2;
    private String text;
    
    public Scene6_Sub2() {
        try {
            bg = ImageIO.read(new File("image/background/split-screen.png"));
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            box2 = ImageIO.read(new File("image/other/textbox2.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_mom.png"));
        } catch (IOException e) {}
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if((subcnt==8 || subcnt==11 || subcnt==14 || subcnt==17 || subcnt==19) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
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
            subcnt = 7;
        } else if(subcnt==7) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Hey mom! I’ve got some of your favourite oranges! Fresh from the";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 8;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==8) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==8) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "farmer's market.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Hey mom! I’ve got some of your favourite oranges! Fresh from the",180,470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==9) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 10;
                curStr = "";
            }
        } else if(subcnt==10) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "Sweetie, you didn’t have to. But how are you going to get";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 11;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==11) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        }  else if(subcnt==11) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "them to me? You’re so far away!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } 
            g2d.setColor(Color.WHITE);
            g2d.drawString("Sweetie, you didn’t have to. But how are you going to get",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==12) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 13;
                curStr = "";
            }
        } else if(subcnt==13) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Surprise! I took 4 days off so that I could come home";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 14;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==14) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==14) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "and spend Lunar New Year with all of you.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } 
            g2d.setColor(Color.WHITE);
            g2d.drawString("Surprise! I took 4 days off so that I could come home",180,470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==15) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 16;
                curStr = "";
            }
        } else if(subcnt==16) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "What?! That’s more than we could ask for. I’ll save you some of";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 17;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==17) g2d.drawString(text,70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==17) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "your favourite cookies. Hurry though, your sister is ruthless!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } 
            g2d.setColor(Color.WHITE);
            g2d.drawString("What?! That’s more than we could ask for. I’ll save you some of",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==18) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 19;
                curStr = "";
            }
        } else if(subcnt==19) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Haha, I’ll be there in a few hours!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==20) {
            if(System.currentTimeMillis() - time > 1000) {
                subcnt = 31;
                fade_stage = 2;
            }
        } else if(subcnt==31) {
            if(fade_stage == 3) {
                transition("scene6_sub2","scene6_sub3");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
