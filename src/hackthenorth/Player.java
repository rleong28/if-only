import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Player {
    private Image[] left;
    private Image[] right;
    private Image[] down;
    private Image[] up;
    public String dir;
    public int x;
    public int y;
    private int walkCnt = 1;
    private long timer;
    public int[] x1 = {}, y1 = {}, x2 = {}, y2 = {};    
    private int walkSpeed = 7;
    private long timer2;
    
    
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        down = new Image[4];
        left = new Image[7];
        right = new Image[7];
        up = new Image[4];
        try {
            for(int i=0; i<4; i++) {
                down[i] = ImageIO.read(new File("image/player/down_"+(i+1)+".png"));
                up[i] = ImageIO.read(new File("image/player/up_"+(i+1)+".png"));
            }
            for(int i=0; i<=6; i++) {
                left[i] = ImageIO.read(new File("image/player/left_"+i+".png"));
                right[i] = ImageIO.read(new File("image/player/right_"+i+".png"));
            }
        } catch (IOException e) {}
        dir = "down_stop";
    }
    
    public void drawPlayer(Graphics2D g2d) {
        if(dir.equals("down")) {
            g2d.drawImage(down[walkCnt],x,y,null);
            if(System.currentTimeMillis() - timer2 > 20) {
                tryMove(x,y+walkSpeed);
                timer2 = System.currentTimeMillis();
            }
            if(System.currentTimeMillis() - timer > 130) {
                walkCnt++;
                walkCnt %= 4;
                timer = System.currentTimeMillis();
            }
        } else if(dir.equals("right")) {
            g2d.drawImage(right[walkCnt],x,y,null);
            if(System.currentTimeMillis() - timer2 > 20) {
                tryMove(x+walkSpeed,y);
                timer2 = System.currentTimeMillis();
            }
            if(System.currentTimeMillis() - timer > 130) {
                walkCnt++;
                walkCnt %= 7;
                timer = System.currentTimeMillis();
            }
        } else if(dir.equals("left")) {
            g2d.drawImage(left[walkCnt],x,y,null);
            if(System.currentTimeMillis() - timer2 > 20) {
                tryMove(x-walkSpeed,y);
                timer2 = System.currentTimeMillis();
            }
            if(System.currentTimeMillis() - timer > 130) {
                walkCnt++;
                walkCnt %= 7;
                timer = System.currentTimeMillis();
            }
        } else if(dir.equals("up")) {
            g2d.drawImage(up[walkCnt],x,y,null);
            if(System.currentTimeMillis() - timer2 > 20) {
                tryMove(x,y-walkSpeed);
                timer2 = System.currentTimeMillis();
            }
            if(System.currentTimeMillis() - timer > 130) {
                walkCnt++;
                walkCnt %= 4;
                timer = System.currentTimeMillis();
            }
        } else if(dir.equals("down_stop")) {
            g2d.drawImage(down[0],x,y,null);
            walkCnt = 1;
            timer = System.currentTimeMillis();
        } else if(dir.equals("right_stop")) {
            g2d.drawImage(right[0],x,y,null);
            walkCnt = 1;
            timer = System.currentTimeMillis();
        } else if(dir.equals("left_stop")) {
            g2d.drawImage(left[0],x,y,null);
            walkCnt = 1;
            timer = System.currentTimeMillis();
        } else if(dir.equals("up_stop")) {
            g2d.drawImage(up[0],x,y,null);
            walkCnt = 1;
            timer = System.currentTimeMillis();
        } 
    }
    
    private boolean tryMove(int newx, int newy) {
        for(int i=0; i<x1.length; i++) {
            if(newx >= x1[i] && newx <= x2[i] && newy >= y1[i] && newy <= y2[i]) return false;
            if(newx + 128 >= x1[i] && newx + 128 <= x2[i] && newy >= y1[i] && newy <= y2[i]) return false;
            if(newx >= x1[i] && newx <= x2[i] && newy + 256 >= y1[i] && newy + 256 <= y2[i]) return false;
            if(newx + 128 >= x1[i] && newx + 128 <= x2[i] && newy + 256 >= y1[i] && newy + 256 <= y2[i]) return false;
        }
        x = newx;
        y = newy;
        return true;
    }
}
