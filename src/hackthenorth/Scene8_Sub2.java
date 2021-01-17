import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene8_Sub2 extends Scene {
    private Image bg;
    private int subcnt = 0;
    private long time;
    private Image[] anim;
    
    public Scene8_Sub2() {
        anim = new Image[17];
        try {
            bg = ImageIO.read(new File("image/background/hospital_1.png"));
            for(int i=1; i<=16; i++) {
                anim[i] = ImageIO.read(new File("image/mon/mon"+i+".png"));
            }
        } catch (IOException e) {}
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(anim[1],0,0,null);
        if(subcnt==0) {
            fadeRate = 3;
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) {
            g2d.drawImage(anim[1],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 3;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) {
            g2d.drawImage(anim[1],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 3;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==3) {
            g2d.drawImage(anim[2],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 4;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==4) {
            g2d.drawImage(anim[3],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 5;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==5) {
            g2d.drawImage(anim[4],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 6;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==6) {
            g2d.drawImage(anim[5],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 7;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==7) {
            g2d.drawImage(anim[6],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 8;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==8) {
            g2d.drawImage(anim[7],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 9;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==9) {
            g2d.drawImage(anim[8],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 10;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==10) {
            g2d.drawImage(anim[9],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 11;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==11) {
            g2d.drawImage(anim[10],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 12;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==12) {
            g2d.drawImage(anim[11],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 13;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==13) {
            g2d.drawImage(anim[12],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 14;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==14) {
            g2d.drawImage(anim[13],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 15;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==15) {
            g2d.drawImage(anim[14],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 16;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==16) {
            g2d.drawImage(anim[15],0,0,null);
            if(System.currentTimeMillis() - time > 700) {
                subcnt = 17;
                time = System.currentTimeMillis();
                fade_stage = 2;
            }
        } else if(subcnt==17) { 
            g2d.drawImage(anim[16],0,0,null);
            if(System.currentTimeMillis() - time > 3000) {
                subcnt = 18;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==18) {
            if(fade_stage == 3) {
                transition("scene8_sub2","scene8_sub3");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
