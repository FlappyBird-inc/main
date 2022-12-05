import java.awt.Rectangle;
import javax.swing.*;

public class Tubo extends Thread
{
    private JLabel tUp,tDown;
    private ImageIcon up,down;
    public Rectangle hitMeBaby,hitMeBabyParte2LaVendetta;
    private int w,h;
    /*private int x2 = 500;
    private int x3 = 800;                   up   down*/
    private int[][] pos = new int[2][2];//{{x,0},{x,y}};
    public Tubo(int x,int y){
        pos[0][0] = x;
        pos[0][1] = 0;
        pos[1][0] = x;
        pos[1][1] = y;
        up = new ImageIcon("img/tuboUp.png");
        down = new ImageIcon("img/tuboDown.png");
        tUp = new JLabel(up);
        tDown = new JLabel(down);
        w = 66;
        h = 230;
        hitMeBaby = new Rectangle(pos[0][0],0,w,h); //TO-DO
        hitMeBabyParte2LaVendetta = new Rectangle(pos[1][0],y,w,h);
    }
    public void run(){
        int x = pos[0][0];
        int y = pos[0][1];
        int y1 = pos[1][1];
        while(true){
            tUp.setLocation(x,y);
            tDown.setLocation(x,y1);
            x-=2;
            if(x < 30)
                x = 1000;
            try{
                Thread.sleep(10);
            }
            catch(Exception e){}
        }
    }
    public JLabel getTUp(){
        return tUp;
    }
    public JLabel getTDown(){
        return tDown;
    }
    public int getPos(int i, String s){
        if(s == "x")
            return pos[i][0];
        else
            return pos[i][1];
    }
    public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }
}
