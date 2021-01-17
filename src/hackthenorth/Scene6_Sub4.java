import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

import java.lang.Math;

public class Scene6_Sub4 extends Scene {
    private Image meatball, pepper;
    private int seconds = 20;
    private long time;
    private int countdown = 4;
    private int score = 0;
    private int x, y;
    private boolean isPepper;
    String stage = "countdown";
    private long gameTime = 0;
    //private int subcnt = 0;
    
    public Scene6_Sub4() {
        try {
            meatball = ImageIO.read(new File("image/other/chicken.png"));
            pepper = ImageIO.read(new File("image/other/sichuan.png"));
        } catch (IOException e) { System.out.println(e.getMessage()); }
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if(e.getX()>=x && e.getX()<=x+80 && e.getY()>=y && e.getY()<=y+80) {
                	gameTime = 0;
                	if(isPepper)score--;
                	else score++;
                }
            }
        });
    }
    
    public void randomCoords() {
    	x = (int)(Math.random() * (900 - 200 + 1) + 200); //900 max, 200 min
    	y = (int)(Math.random() * (500 - 50 + 1) + 50); //500 max, 50 min
    }
    
    public void randomPepper() {
    	int temp = (int)(Math.random() * (101 - 1 + 1) + 1); //100 max, 1 min
    	if (temp%5 == 0) isPepper = true;
    	else isPepper = false;
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,1000,600);
        g2d.setColor(Color.WHITE);
        g2d.setFont(font.deriveFont(20.0f));
        g2d.drawString("New Year's feast!",20,100);
        g2d.drawString("Eat as many meatballs",20,130);
        g2d.drawString("as you can by clicking",20,160);
        g2d.drawString("on them. Make sure to avoid",20,190);
        g2d.drawString("those pesky sichuan peppers, ",20,220);
        g2d.drawString("or else you lose points!",20,250);
        
        if(stage.equals("countdown")) {
        	if(countdown == 4) {
        		start();
        		countdown = 3;
            	time = System.currentTimeMillis();
        	}
        	//g2d.setFont(font.deriveFont(50.0f));
            g2d.drawString(countdown+"",500,300);
            if(System.currentTimeMillis()>=time+1000) {
            	countdown--;
            	time = System.currentTimeMillis();
            }
            if(countdown == 0)stage = "game";
        }else if (stage.equals("game")) {
        	g2d.drawString("timer: "+seconds+"",80,370);
        	g2d.drawString("score: "+score+"",80,320);
        	if(seconds == 0) {
        		stage = "end";
        		time = System.currentTimeMillis();
        	}
        	if(System.currentTimeMillis()>=time+1000) {
            	seconds--;
            	time = System.currentTimeMillis();
            }
        	if(gameTime == 0) {
        		randomPepper();
        		randomCoords();
        		gameTime = System.currentTimeMillis();
        	}else if(System.currentTimeMillis()>=gameTime+1500) {
        		gameTime = 0;
        	}
        	if(isPepper) {
        		g2d.drawImage(pepper,x,y,null);
        	}else {
        		g2d.drawImage(meatball,x,y,null);
        	}
        } else if(stage.equals("end")) {
            g2d.drawString("Score: "+score+"",450,290);
            if(System.currentTimeMillis()>=time+2500) {
                fade_stage = 2;
                stage = "end2";
            }
        } else if(stage.equals("end2")) {
            if(fade_stage == 3) {
                transition("scene6_sub4","scene7_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
