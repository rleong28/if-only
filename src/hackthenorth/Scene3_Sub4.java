import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene3_Sub4 extends Scene {
    private int subcnt = 0;
    private long time;
    private String curStr = "";
    private String text;
    private Image box1;
    private Image icon1;
    private Image comp[];
    private int opac = 0;
    
    public Scene3_Sub4() {
        comp = new Image[2];
        try {
            for(int i=0; i<2; i++) {
                comp[i] = ImageIO.read(new File("image/computer/comp"+(i+1)+".png"));
            }
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
        } catch (IOException e) {System.out.println(e.getMessage());}
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if(subcnt==8 && curStr.length() == text.length() && System.currentTimeMillis() - time >= 700) {
                    subcnt = 9;
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
        g2d.drawImage(comp[0],0,0,null);
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
                subcnt = 7;
            }
        } else if(subcnt==3) {
            g2d.drawImage(comp[1],0,0,null);
            if(System.currentTimeMillis() - time >= 500) {
                time = System.currentTimeMillis();
                subcnt = 10;
            }
        } else if(subcnt==7) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "What a steal! I've been waiting for it to go on sale for the";
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
            text = "longest time. Now I've finally got it!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("What a steal! I've been waiting for it to go on sale for the",180,470);
            g2d.drawString(curStr,180,505);
        } if(subcnt==9) {
            g2d.drawImage(comp[1],0,0,null);
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 3;
                curStr = "";
            }
        } else if(subcnt==10) {
            g2d.drawImage(comp[1],0,0,null);
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Thank goodness I didn't spend it on a plane ticket to France. That";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 11;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==11) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==11) {
            g2d.drawImage(comp[1],0,0,null);

            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "would have been ridiculous.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Thank goodness I didn't spend it on a plane ticket to France. That",180,470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==12) {
            g2d.drawImage(comp[1],0,0,null);
            if(System.currentTimeMillis() - time > 800) {
                subcnt = 13;
                curStr = "";
                fade_stage = 2;
            }
        } else if(subcnt==13) {
            g2d.drawImage(comp[1],0,0,null);
            if(fade_stage == 3) {
                transition("scene3_sub4","scene4_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
