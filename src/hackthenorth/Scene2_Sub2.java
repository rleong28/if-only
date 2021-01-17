import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene2_Sub2 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image box1, box2;
    private String curStr = "";
    private Image icon1, icon2;
    private String text;
    
    public Scene2_Sub2() {
        try {
            bg = ImageIO.read(new File("image/background/split-screen.png"));
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            box2 = ImageIO.read(new File("image/other/textbox2.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_mom.png"));
        } catch (IOException e) {}
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if((subcnt==5 || subcnt==8 || subcnt==12 || subcnt==14 || subcnt==17 || subcnt==19) && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
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
            g2d.drawImage(icon2,854,420,null);
            text = "Hey, we've got boxes of your favourite lunar new year snacks,";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 5;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==5) g2d.drawString("Hey, we've got boxes of your favourite lunar new year snacks,",70,470);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==5) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "ready for you! When are you coming home?";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Hey, we've got boxes of your favourite lunar new year snacks,",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==6) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 7;
                curStr = "";
            }
        } else if(subcnt==7) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "I'm so sorry but I'm swamped in work right now. My boss isn't";
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
            text = "letting me take time off.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("I'm so sorry but I'm swamped in work right now. My boss isn't",180,470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==9) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 10;
                curStr = "";
            }
        } else if(subcnt==10) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "What?! But this is the only time you and your sister ever";
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
            text = "come home! Your dad and I have rarely seen you since";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 12;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length()==0 && subcnt==12) g2d.drawString(text,70,505);
            g2d.drawString("What?! But this is the only time you and your sister ever",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==12) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "you moved to San Francisco.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("What?! But this is the only time you and your sister ever",70,470);
            g2d.drawString("come home! Your dad and I have rarely seen you since",70,505);
            g2d.drawString(curStr,70,540);
        } else if(subcnt==13) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 14;
                curStr = "";
            }
        } else if(subcnt==14) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "I'm sorry.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==15) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 16;
                curStr = "";
            }
        } else if(subcnt==16) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "Even your sister is flying home from France...";
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
            text = "Is there no way you can make it?";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } 
            g2d.setColor(Color.WHITE);
            g2d.drawString("Even your sister is flying home from France...",70,470);
            g2d.drawString(curStr,70,505);
        } else if(subcnt==18) {
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 19;
                curStr = "";
            }
        } else if(subcnt==19) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "I already said no! Stop making me repeat myself!";
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
                transition("scene2_sub2","scene2_sub5");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
