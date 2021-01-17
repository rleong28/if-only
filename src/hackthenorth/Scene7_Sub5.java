import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.*;
import java.util.*;
import javax.imageio.ImageIO;

public class Scene7_Sub5 extends Scene {
    public static class Arrow {
        public int col;
        public int y;
        public boolean visible = true;
        public Arrow(int col, int y) {
            this.col = col;
            this.y = y;
        }
    }
    private Image left, right, up, down;
    private Image lefte,righte,upe,downe;
    private long time;
    private int subcnt = 0;
    private ArrayList<Arrow> qu = new ArrayList<>();
    private long score = 0;
    public Scene7_Sub5() {
        try {
            left = ImageIO.read(new File("image/dance/left.png"));
            right = ImageIO.read(new File("image/dance/right.png"));
            up = ImageIO.read(new File("image/dance/up.png"));
            down = ImageIO.read(new File("image/dance/down.png"));
            lefte = ImageIO.read(new File("image/dance/left-empty.png"));
            righte = ImageIO.read(new File("image/dance/right-empty.png"));
            upe = ImageIO.read(new File("image/dance/up-empty.png"));
            downe = ImageIO.read(new File("image/dance/down-empty.png"));
        } catch (IOException e) { System.out.println(e.getMessage()); }
        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                for(Arrow a:qu) {
                    if(e.getKeyCode() == KeyEvent.VK_LEFT && a.col==0 && a.y < 480 && a.y >= 400 && a.visible) {
                        score += 100-(480-a.y);
                        a.visible = false;
                    } else if(e.getKeyCode() == KeyEvent.VK_UP && a.col==1 && a.y < 480 && a.y >= 400 && a.visible) {
                        score += 100-(480-a.y);
                        a.visible = false;
                    } else if(e.getKeyCode() == KeyEvent.VK_DOWN && a.col==2 && a.y < 480 && a.y >= 400 && a.visible) {
                        score += 100-(480-a.y);
                        a.visible = false;
                    } else if(e.getKeyCode() == KeyEvent.VK_RIGHT && a.col==3 && a.y < 480 && a.y >= 400 && a.visible) {
                        score += 100-(480-a.y);
                        a.visible = false;
                    }
                }
            }
        });
        for(int i=0; i<20; i++) {
            boolean[] col = new boolean[4];
            int rand= (int)(Math.random()*1)+1;
            for(int j=1; j<=rand; j++) {
                int coll = (int)(Math.random()*4);
                while(col[coll]) {
                    coll = (int)(Math.random()*4);
                }
                col[coll] = true;
                Arrow a = new Arrow(coll,-10+(-150)*i);
                qu.add(a);
            }
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,1000,600);
        g2d.setColor(Color.WHITE);
        g2d.setFont(font.deriveFont(20.0f));
        g2d.drawString("It's time to dance!",20,100);
        g2d.drawString("Press the incoming",20,130);
        g2d.drawString("arrow on your",20,160);
        g2d.drawString("keyboard when it",20,190);
        g2d.drawString("reaches the bottom.",20,220);
        g2d.drawImage(lefte,350+0*150,480,null);
        g2d.drawImage(upe,350+1*150,480,null);
        g2d.drawImage(downe,350+2*150,480,null);
        g2d.drawImage(righte,350+3*150,480,null);
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
            g2d.setFont(font.deriveFont(50.0f));
            g2d.drawString((int)(3-(System.currentTimeMillis()-time)/1000)+"",500,300);
            if(System.currentTimeMillis()-time >= 2900) {
                subcnt = 4;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==4) {
            boolean exit = true;
            for(Arrow a:qu) {
                if(!a.visible) continue;
                if(a.col==0) {
                    g2d.drawImage(left,350+a.col*150,a.y,null);
                } else if(a.col==1) {
                    g2d.drawImage(up,350+a.col*150,a.y,null);
                } else if(a.col==2) {
                    g2d.drawImage(down,350+a.col*150,a.y,null);
                } else if(a.col==3) {
                    g2d.drawImage(right,350+a.col*150,a.y,null);
                }
                a.y += 4;
                if(a.y < 700) exit = false;
            }
            if(exit) {
                subcnt = 5;
                time = System.currentTimeMillis();
            }
        } else if(subcnt==5) {
            g2d.drawString("Score: "+score+" / "+(20*100),500,300);
            if(System.currentTimeMillis() - time > 1200) {
                subcnt = 7;
                fade_stage = 2;
            }
        } else if(subcnt==7) {
            if(fade_stage == 3) {
                transition("scene7_sub5","scene8_sub0");
            }
        }
        fade(g2d);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
