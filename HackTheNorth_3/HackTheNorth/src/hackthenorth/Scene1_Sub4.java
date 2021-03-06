import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene1_Sub4 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Player player;
    private Image box1, box2;
    private Image icon1, icon2;
    private String curStr = "";
    private String text = " ";
    private Image mom;
    
    public Scene1_Sub4() {
        try {
            bg = ImageIO.read(new File("image/background/livingroom.png"));
            box1 = ImageIO.read(new File("image/other/textbox1.png"));
            box2 = ImageIO.read(new File("image/other/textbox2.png"));
            icon1 = ImageIO.read(new File("image/icons/icon_player.png"));
            icon2 = ImageIO.read(new File("image/icons/icon_mom.png"));
            mom = ImageIO.read(new File("image/background/mother_sit.png"));
        } catch (IOException e) {}
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if(subcnt==2 || subcnt==15) {
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
                if(subcnt==2 || subcnt==15) {
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
                if(subcnt==2 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && player.x >= 570 && player.x <= 680 && player.y >= 0 && player.y <= 250 && player.dir.startsWith("up")) {
                    subcnt = 3;
                } 
                if(subcnt==2 && player.x >= 445 && player.x <= 645 && player.y>=435 && player.y<=800 && (e.getKeyChar() == 's' || e.getKeyChar()=='S')) {
                    subcnt = 20;
                }
                if(subcnt==15 && player.x >= 445 && player.x <= 645 && player.y>=435 && player.y<=800 && (e.getKeyChar() == 's' || e.getKeyChar()=='S')) {
                    subcnt = 25;
                }
                if(subcnt==2 && player.x >= 912 && player.x <= 1200 && player.y>=0 && player.y<=1000 && (e.getKeyChar() == 'd' || e.getKeyChar()=='D')) {
                    subcnt = 22;
                }
                if(subcnt==15 && player.x >= 912 && player.x <= 1200 && player.y>=0 && player.y<=1000 && (e.getKeyChar() == 'd' || e.getKeyChar()=='D')) {
                    fade_stage = 2;
                    subcnt = 16;
                }
                
                if(subcnt==21 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt = 2;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
                if(subcnt==22 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt = 2;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
                if(subcnt==15 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && player.x >= 800 && player.x <= 1000 && player.y >= 400 && player.y <= 600) {
                    subcnt=16;
                }
                if(subcnt==26 && (e.getKeyChar()=='x' || e.getKeyChar()=='X')) {
                    subcnt=15;
                }
                if(subcnt >= 3 && subcnt <= 14 && subcnt%2==1 && (e.getKeyChar()=='x' || e.getKeyChar()=='X') && System.currentTimeMillis() - time >= 700 && curStr.length() == text.length()) {
                    subcnt ++;
                    curStr = "";
                    time = System.currentTimeMillis();
                }
            }
        });
        player = new Player(468,380);
        int[] x1 = {0,0,0,645,944,944,0,503,0,1050,}, y1 = {-100,0,586,586,0,510,700,0,0,0,}, x2 = {1000,56,445,1000,1200,1200,1000,874,460,1200}, y2 = {14,600,1000,1000,180,1000,800,105,250,600};    
        player.x1 = x1; player.y1 = y1; player.x2 = x2; player.y2 = y2;
        player.dir = "up_stop";
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(bg,0,0,null);
        g2d.drawImage(mom,0,0,null);
        player.drawPlayer(g2d);
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
            g2d.setFont(font.deriveFont(20.0f));
            if(player.x >= 570 && player.x <= 680 && player.y >= 0 && player.y <= 250 && player.dir.startsWith("up")) {
                g2d.drawString("Press X to interact.", 20, 35);
            }
            g2d.setFont(font);
        } else if(subcnt==3) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "Good morning sweetie!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==4) {
            if(System.currentTimeMillis() - time > 800) {
                curStr = "";
                time = System.currentTimeMillis();
                subcnt = 5;
            }
        } else if(subcnt==5) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Mom, my friend is throwing a party today. I want to go!";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==6) {
            if(System.currentTimeMillis() - time > 800) {
                curStr = "";
                time = System.currentTimeMillis();
                subcnt = 7;
            }
        } else if(subcnt==7) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "...You know how long we've been planning your sister's party.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==8) {
            if(System.currentTimeMillis() - time > 800) {
                curStr = "";
                time = System.currentTimeMillis();
                subcnt = 9;
            }
        } else if(subcnt==9) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "It’s fine, I’ll be back at 9PM to cut the cake.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==10) {
            if(System.currentTimeMillis() - time > 800) {
                curStr = "";
                time = System.currentTimeMillis();
                subcnt = 11;
            }
        } else if(subcnt==11) {
            g2d.drawImage(box2,0,400,null);
            g2d.drawImage(icon2,854,420,null);
            text = "You promise?";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,70,470);
        } else if(subcnt==12) {
            if(System.currentTimeMillis() - time > 800) {
                curStr = "";
                time = System.currentTimeMillis();
                subcnt = 13;
            }
        } else if(subcnt==13) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "I promise.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==14) {
            if(System.currentTimeMillis() - time > 800) {
                curStr = "";
                time = System.currentTimeMillis();
                subcnt = 15;
            }
        } else if(subcnt==15) {
        } else if(subcnt==16) {
            if(System.currentTimeMillis() - time > 1000) {
                subcnt = 17;
                time = System.currentTimeMillis();
                fadeRate = 5;
                fade_stage = 2;
            }
        } else if(subcnt==17) {
            if(fade_stage == 3) {
                
                transition("scene1_sub4","scene1_sub5");
            }
        } else if(subcnt==20) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "You have a party to go to. You should talk to your mother";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 21;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==21) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==21) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "before leaving.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("You have a party to go to. You should talk to your mother",180,470);
            g2d.drawString(curStr,180,505);
        } else if(subcnt==22) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "You need to ask for permission before leaving for the party.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString(curStr,180,470);
            
        } else if(subcnt==25) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "Your mother agreed to let you go to the party. You should";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            } else if(curStr.length() == text.length()) {
                time = System.currentTimeMillis();
                subcnt = 26;
                curStr = "";
            }
            g2d.setColor(Color.WHITE);
            if(curStr.length() == 0 && subcnt==26) g2d.drawString(text,180,470);
            g2d.drawString(curStr,180,470);
        } else if(subcnt==26) {
            g2d.drawImage(box1,0,400,null);
            g2d.drawImage(icon1,22,420,null);
            text = "leave through the front door.";
            if(System.currentTimeMillis() - time > 35 && curStr.length() < text.length()) {
                time = System.currentTimeMillis();
                curStr += text.charAt(curStr.length());
            }
            g2d.setColor(Color.WHITE);
            g2d.drawString("Your mother agreed to let you go to the party. You should",180,470);
            g2d.drawString(curStr,180,505);
        } 
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
