import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;

public class Instructions extends Scene {
    private int subcnt = 0;
    private long time = System.currentTimeMillis();
    private String curStr = "";
    
    public Instructions() {
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
            String str = "I don't have much time left. Yet there are still so many things";
            if(curStr.length() < str.length() && System.currentTimeMillis() - time >= 70) {
                curStr += str.charAt(curStr.length());
                if(curStr.length()-2 >= 0 && str.charAt(curStr.length()-2)=='.') { g2d.drawString(curStr, 100,200); try { Thread.sleep(1600); } catch (InterruptedException e) {} }
                time = System.currentTimeMillis();
            } else if(curStr.length()==str.length()) {
                subcnt = 3;
                curStr = "";
                time = System.currentTimeMillis();
            }
            if(subcnt==3) g2d.drawString("I don't have much time left. Yet there are still so many things",100,200);
            g2d.drawString(curStr, 100,200);
        } else if(subcnt==3) {
            String str = "I regret doing. If only I could change the past. ";
            if(curStr.length() < str.length() && System.currentTimeMillis() - time >= 70) {
                curStr += str.charAt(curStr.length());
                if(curStr.length()-2 >= 0 && str.charAt(curStr.length()-2)=='.') { g2d.drawString(curStr, 100,240); try { Thread.sleep(1600); } catch (InterruptedException e) {} }
                time = System.currentTimeMillis();
            } else if(curStr.length()==str.length()) {
                subcnt = 4;
                time = System.currentTimeMillis();
                curStr = "";
            }
            g2d.drawString("I don't have much time left. Yet there are still so many things",100,200);
            if(subcnt == 4) g2d.drawString("I regret doing. If only I could change the past.",100,240);            
            g2d.drawString(curStr, 100,240);
        } else if(subcnt==4) {
            String str = "Move using WASD. Interact and continue dialogue using X.";
            if(curStr.length() < str.length() && System.currentTimeMillis() - time >= 70) {
                curStr += str.charAt(curStr.length());
                if(curStr.length()-2 >= 0 && str.charAt(curStr.length()-2)=='.') { g2d.drawString(curStr, 100,320); try { Thread.sleep(1600); } catch (InterruptedException e) {} }
                time = System.currentTimeMillis();
            } else if(curStr.length()==str.length() && System.currentTimeMillis() - time >= 2000) {
                subcnt = 5;
                curStr = "";
            }
            g2d.drawString("I don't have much time left. Yet there are still so many things",100,200);
            g2d.drawString("I regret doing. If only I could change the past.",100,240); 
            if(subcnt==5) {
                fade_stage = 2;
                g2d.drawString("Move using WASD. Interact and continue dialogue using X.",100,320);
            }
            g2d.drawString(curStr,100,320);
        } else if(subcnt==5) {
            g2d.drawString("I don't have much time left. Yet there are still so many things",100,200);
            g2d.drawString("I regret doing. If only I could change the past.",100,240);            
            g2d.drawString("Move using WASD. Interact and continue dialogue using X.",100,320);
            if(fade_stage == 3) {
                transition("instructions","scene1_sub0");
            }
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
