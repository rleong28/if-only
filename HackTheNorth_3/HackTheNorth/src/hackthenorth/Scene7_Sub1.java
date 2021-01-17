import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene7_Sub1 extends Scene {
    private int subcnt = 0;
    private long time;
    private String curStr = "";
    private Image letter;
    private Image env[];
    private int y = 0;
    private String text;
    private Image box1;
    private Image icon1;
    
    public Scene7_Sub1() {
        env = new Image[3];
        try {
            letter = ImageIO.read(new File("image/letter/letter_2.png"));
            for(int i=0; i<3; i++) {
                env[i] = ImageIO.read(new File("image/letter/env_"+(i+1)+"_2.png"));
            }
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
        } catch (IOException e) {}
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(subcnt==8 && curStr.length() == text.length() && System.currentTimeMillis() - time >= 700) {
                    subcnt++;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
                if(subcnt==11 && curStr.length() == text.length() && System.currentTimeMillis() - time >= 700) {
                    subcnt++;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
            }
        });
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(100,100,100));
        g2d.fillRect(0,0,1000,600);
        g2d.drawImage(env[2],0,y,null);
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
            if(System.currentTimeMillis() - time >= 500) {
                time = System.currentTimeMillis();
                subcnt = 3;
            }
        } else if(subcnt==3) {
            g2d.drawImage(env[0],0,0,null);
            if(System.currentTimeMillis() - time >= 500) {
                time = System.currentTimeMillis();
                subcnt = 4;
            }
        } else if(subcnt==4) {
            g2d.drawImage(env[0],0,y,null);
            g2d.drawImage(letter,0,0,null);
            g2d.drawImage(env[1],0,y,null);
            if(System.currentTimeMillis() - time >= 500 && y>=600) {
                time = System.currentTimeMillis();
                subcnt = 7;
            }
            if(y<600) {
                y += 5;
            } 
        } else if(subcnt==7) {
            g2d.drawImage(letter,0,0,null);
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Oh wow, she's choosing to stay in France for her wedding. I";
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
            g2d.drawImage(letter,0,0,null);
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "can book a ticket with my Air Miles for free!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Oh wow, she's choosing to stay in France for her wedding. I",180,470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==9) {
            g2d.drawImage(letter,0,0,null);
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 13;
                curStr = "";
                fade_stage = 2;
            }
        } else if(subcnt==13) {
            g2d.drawImage(letter,0,0,null);
            if(fade_stage == 3) {
                transition("scene7_sub1","scene7_sub2");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
