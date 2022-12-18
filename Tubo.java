import java.awt.Rectangle;
import javax.swing.*;

public class Tubo extends Thread
{
    private JLabel tUp,tDown;
    private ImageIcon up,down;
    public Rectangle hitMeBaby,hitMeBabyParte2LaVendetta;
    private int w,h;                      //up   down
    private int[][] pos = new int[2][2];//{{x,0},{x,y}};
    private Player p = new Player(); 
    private Punteggio score;
    public Tubo(int x,int y, Punteggio score){
        this.score = score;
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
        while(p.gameOver()){
            tUp.setLocation(x,y);
            tDown.setLocation(x,y1);
            hitMeBaby.setLocation(x,y);
            hitMeBabyParte2LaVendetta.setLocation(x,y1);
            x-=1;
            if(x == 100){
                int parse = Integer.parseInt(score.getScore())+1;
                String pass = String.valueOf(parse);
                score.setScore(pass);
            }
            if(x < -66)
                x = 1000;
                y = (int)Math.random()*100+y1;
                y1 =(int)Math.random()*100;
            try{
                Thread.sleep(5);
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
