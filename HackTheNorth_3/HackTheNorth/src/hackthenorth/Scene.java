import java.awt.*;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.util.*;

public abstract class Scene extends JPanel implements ActionListener{
    private javax.swing.Timer tm;
    public HashMap<String,Scene> map;
    public JFrame f;
    public int fade = 255;
    public int fade_stage = 0;
    public Font font;
    public int fadeRate = 15;
    
    public Scene() {
        try {
            //font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("font/ChakraPetch-Light.ttf"));
            font = Font.createFont(Font.TRUETYPE_FONT, new File("font/ChakraPetch-Light.ttf"));
            font = font.deriveFont(25.0f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void fade(Graphics2D g2d) {
        g2d.setColor(new Color(0,0,0,Math.min(255,Math.max(0,fade))));
        g2d.fillRect(0,0,1000,600);
        if(fade_stage == 0) fade -= fadeRate;
        if(fade_stage == 0 && fade <= 0) fade_stage = 1;
        if(fade_stage == 2) fade += fadeRate;
        if(fade_stage == 2 && fade >= 255) {
            fade_stage = 3;
        }
    }
    
    public void start() {
        tm = new javax.swing.Timer(20, this);
        tm.start();
        requestFocus();
        this.setVisible(true);
    }
    
    public void stop() {
        this.setVisible(false);
    }
    
    public void transition(String cur, String next) {
        f.getContentPane().add(map.get(next));
        map.get(cur).stop();
        map.get(next).start();
    }
}
