import javax.swing.*;
import java.util.*;

public class HackTheNorth {
    public static void main(String[] args) {
        JFrame f = new JFrame("Game Title");
        f.setSize(1000,622);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HashMap<String,Scene> arr = new HashMap<>();
        arr.put("intro", new Intro());
        arr.put("instructions", new Instructions());
        
        arr.put("scene1_sub0", new Scene1_Sub0());
        arr.put("scene1_sub1", new Scene1_Sub1());
        arr.put("scene1_sub2", new Scene1_Sub2());
        arr.put("scene1_sub3", new Scene1_Sub3());
        arr.put("scene1_sub4", new Scene1_Sub4());
        arr.put("scene1_sub5", new Scene1_Sub5());
        arr.put("scene1_sub6", new Scene1_Sub6());
        arr.put("scene1_sub7", new Scene1_Sub7());
        
        arr.put("scene2_sub1", new Scene2_Sub1());
        arr.put("scene2_sub2", new Scene2_Sub2());
        arr.put("scene2_sub3", new Scene2_Sub3());
        arr.put("scene2_sub4", new Scene2_Sub4());
        arr.put("scene2_sub5", new Scene2_Sub5());
        arr.put("scene2_sub6", new Scene2_Sub6());
        
        arr.put("scene3_sub0", new Scene3_Sub0());
        arr.put("scene3_sub1", new Scene3_Sub1());
        arr.put("scene3_sub2", new Scene3_Sub2());
        arr.put("scene3_sub4", new Scene3_Sub4());

        arr.put("scene4_sub0", new Scene4_Sub0());
        arr.put("scene4_sub1", new Scene4_Sub1());
        arr.put("scene4_sub2", new Scene4_Sub2());
        
        arr.put("scene5_sub0", new Scene5_Sub0());
        arr.put("scene5_sub1", new Scene5_Sub1());
        arr.put("scene5_sub2", new Scene5_Sub2());
        arr.put("scene5_sub3", new Scene5_Sub3());
        arr.put("scene5_sub4", new Scene5_Sub4());
        arr.put("scene5_sub5", new Scene5_Sub5());
        arr.put("scene5_sub6", new Scene5_Sub6());
        arr.put("scene5_sub7", new Scene5_Sub7());
        arr.put("scene5_sub8", new Scene5_Sub8());
        
        arr.put("scene6_sub0", new Scene6_Sub0());
        arr.put("scene6_sub1", new Scene6_Sub1());
        arr.put("scene6_sub2", new Scene6_Sub2());
        arr.put("scene6_sub3", new Scene6_Sub3());
        arr.put("scene6_sub4", new Scene6_Sub4());
        
        arr.put("scene7_sub0", new Scene7_Sub0());
        arr.put("scene7_sub1", new Scene7_Sub1());
        arr.put("scene7_sub2", new Scene7_Sub2());
        arr.put("scene7_sub3", new Scene7_Sub3());
        arr.put("scene7_sub4", new Scene7_Sub4());
        arr.put("scene7_sub5", new Scene7_Sub5());
        
        arr.put("scene8_sub0", new Scene8_Sub0());
        arr.put("scene8_sub1", new Scene8_Sub1());
        arr.put("scene8_sub2", new Scene8_Sub2());
        arr.put("scene8_sub3", new Scene8_Sub3());
        arr.put("scene8_sub4", new Scene8_Sub4());
        arr.put("scene8_sub5", new Scene8_Sub5());
        
        for(String s:arr.keySet()) {
            arr.get(s).map = arr;
            arr.get(s).f = f;
        }
        ((Scene1_Sub3)arr.get("scene1_sub3")).initialize();
        ((Scene5_Sub3)arr.get("scene5_sub3")).initialize();
        ((Scene5_Sub6)arr.get("scene5_sub6")).initialize();
        f.add(arr.get("scene8_sub5"));
        f.setVisible(true);
        
    }
}
