import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class Scene8_Sub4 extends Scene {
    private int subcnt = 0;
    private long time = System.currentTimeMillis();
    private String curStr = "";
    
    public Scene8_Sub4() {
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        fade(g2d);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,1000,600);
        g2d.setFont(font);
        g2d.setColor(Color.WHITE);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) {
            String str = "Hi sis. I know you probably don't want to speak to me.";
            if(curStr.length() < str.length() && System.currentTimeMillis() - time >= 90) {
                curStr += str.charAt(curStr.length());
                if(curStr.length()-2 >= 0 && str.charAt(curStr.length()-2)=='.') { g2d.drawString(curStr, 100,200); try { Thread.sleep(1600); } catch (InterruptedException e) {} }
                time = System.currentTimeMillis();
            } else if(curStr.length()==str.length()) {
                fade_stage = 2;
                subcnt = 3;
                curStr = "";
                time = System.currentTimeMillis();
            }
            if(subcnt==3) g2d.drawString("Hi sis. I know you probably don't want to speak to me.",100,200);
            g2d.drawString(curStr, 100,200);
        } else if(subcnt==3) {
            String str = "But my time is running out. I'm so sorry. Could you ever forgive me? ";
            if(curStr.length() < str.length() && System.currentTimeMillis() - time >= 130) {
                curStr += str.charAt(curStr.length());
                if(curStr.length()-2 >= 0 && (str.charAt(curStr.length()-2)=='.' || str.charAt(curStr.length()-2)=='?')) { g2d.drawString(curStr, 100,240); try { Thread.sleep(1600); } catch (InterruptedException e) {} }
                time = System.currentTimeMillis();
            } else if(curStr.length()==str.length()) {
                fade_stage = 2;
                subcnt = 4;
                time = System.currentTimeMillis();
                curStr = "";
            }
            g2d.drawString("Hi sis. I know you probably don't want to speak to me.",100,200);
            if(subcnt == 4) g2d.drawString("But my time is running out. I'm so sorry. Could you ever forgive me?",100,240);            
            g2d.drawString(curStr, 100,240);
        } else if(subcnt==4) {
            String str = "I love y-";
            if(curStr.length() < str.length() && System.currentTimeMillis() - time >= 200) {
                curStr += str.charAt(curStr.length());
                if(curStr.length()-2 >= 0 && (str.charAt(curStr.length()-2)=='.' || str.charAt(curStr.length()-2)=='?')) { g2d.drawString(curStr, 100,320); try { Thread.sleep(1600); } catch (InterruptedException e) {} }
                time = System.currentTimeMillis();
            } else if(curStr.length()==str.length() && System.currentTimeMillis() - time >= 2000) {
                fade_stage = 2;
                subcnt = 5;
                time = System.currentTimeMillis();
                curStr = "";
            }
            g2d.drawString("Hi sis. I know you probably don't want to speak to me.",100,200);
            g2d.drawString("But my time is running out. I'm so sorry. Could you ever forgive me?",100,240); 
            if(subcnt==5) g2d.drawString("I love y-",100,320);
            g2d.drawString(curStr,100,320);
        } else if(subcnt==5) {
            g2d.drawString("Hi sis. I know you probably don't want to speak to me.",100,200);
            g2d.drawString("But my time is running out. I'm so sorry. Could you ever forgive me?",100,240);            
            g2d.drawString("I love y-",100,320);
            if(fade_stage == 3) {
                transition("scene8_sub4","scene8_sub5");
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
