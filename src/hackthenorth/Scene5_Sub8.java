import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene5_Sub8 extends Scene {
    private long time;
    private int subcnt = 0;
    private long score = 0;
    private Font font2;
    private String[] word = {"action", "change", "future", "mend", "progress", "gradual", "effort", "improve", "sorry", "possible", "believe", "cherish", "family", "love", "apologize", "parents", "siblings"};
    private String[] scram = {"atncoi", "caehgn", "rtufeu", "mdne", "ersrsopg", "raagldu", "rofetf", "mepovri", "sryro", "bolpeiss", "velbiee", "hrehsic", "aiflym", "oevl", "leoazgpoi", "rneapts", "liisnbsg"};
    private String[] que = new String[3];
    private String[] ans = new String[3];
    private int cur = 0;
    private int tries;
    private String str = "";
    private Image block;
    
    public Scene5_Sub8() {
        try {
            font2 = Font.createFont(Font.TRUETYPE_FONT, new File("font/RobotoSlab.ttf"));
            font2 = font.deriveFont(30.0f);
            block = ImageIO.read(new File("image/other/block.png"));
        } catch (Exception e) {}
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                if((e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z')) {
                    str += e.getKeyChar();
                } else if(e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z') {
                    str += e.getKeyChar()-('A'-'a');
                } else if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(str.equals(ans[cur])) {
                        subcnt++;
                        score++;
                    } else {
                        subcnt += 2;
                    }
                    time = System.currentTimeMillis();
                } else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    if(str.length() > 0) str = str.substring(0,str.length()-1);
                }
            }
        });
        boolean[] use = new boolean[word.length];
        for(int i=0; i<3; i++) {
            int rand = (int)(Math.random()*word.length);
            while(use[rand]) rand = (int)(Math.random()*word.length);
            que[i] = scram[rand];
            ans[i] = word[rand];
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,1000,600);
        g2d.setColor(Color.WHITE);
        g2d.setFont(font.deriveFont(20.0f));
        g2d.drawString("Try and unscramble",20,100);
        g2d.drawString("these letters to",20,130);
        g2d.drawString("form a word!",20,160);
        if(subcnt==0) {
            start();
            subcnt = 1;
        } else if(subcnt==1) {
            if(fade_stage == 1) {
                subcnt=2;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==2) {
            if(System.currentTimeMillis()-time >= 3500) {
                subcnt =3;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==3) {
            subcnt = 4;
        } else if(subcnt==4) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[0].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[0].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
        } else if(subcnt==5) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[0].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[0].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
            g2d.drawString("Correct answer.", 80, 440);
            if(System.currentTimeMillis() - time > 2000) {
                subcnt = 7;
                cur = 1;
                tries = 0;
                str = "";
            }
        } else if(subcnt==6) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[0].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[0].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
            g2d.drawString("Incorrect answer.", 80, 440);
            if(System.currentTimeMillis() - time > 2000) {
                subcnt = 4;
                tries++;
                if(tries==3) {
                    subcnt = 7;
                    tries = 0;
                }
                str = "";
            }
        } else if(subcnt==7) {
            cur = 1;
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[1].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[1].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
        } else if(subcnt==8) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[1].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[1].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
            g2d.drawString("Correct answer.", 80, 440);
            if(System.currentTimeMillis() - time > 2000) {
                subcnt = 10;
                tries = 0;
                str = "";
            }
        } else if(subcnt==9) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[1].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[1].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
            g2d.drawString("Incorrect answer.", 80, 440);
            if(System.currentTimeMillis() - time > 2000) {
                subcnt = 7;
                tries++;
                if(tries==3) {
                    subcnt = 10;
                    tries = 0;
                }
                str = "";
            }
        } else if(subcnt==10) {
            cur = 2;
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[2].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[2].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
        } else if(subcnt==11) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[2].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[2].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
            g2d.drawString("Correct answer.", 80, 440);
            if(System.currentTimeMillis() - time > 2000) {
                subcnt = 13;
                time = System.currentTimeMillis();
                tries = 0;
                str = "";
            }
        } else if(subcnt==12) {
            g2d.setColor(new Color(105, 85, 52));
            g2d.setFont(font2.deriveFont(70.0f));
            for(int i=0; i<que[2].length(); i++) {
                g2d.drawImage(block, 80+95*i, 220, null);
                g2d.drawString(que[2].charAt(i)+"", 80+95*i+15, 280);
            }
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString("Type your answer: "+str, 80, 380);
            g2d.drawString("Tries left: "+(3-tries), 80, 405);
            g2d.drawString("Incorrect answer.", 80, 440);
            if(System.currentTimeMillis() - time > 2000) {
                subcnt = 10;
                tries++;
                if(tries==3) {
                    subcnt = 13;
                    time = System.currentTimeMillis();
                    tries = 0;
                }
                str = "";
            }
        } else if(subcnt==13) {
            g2d.drawString("Score: "+score+" / "+3,470,300);
            if(System.currentTimeMillis() - time > 1200) {
                subcnt = 14;
                fade_stage = 2;
            }
        } else if(subcnt==14) {
            if(fade_stage == 3) {
                transition("scene5_sub8","scene6_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
