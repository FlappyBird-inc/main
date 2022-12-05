import java.awt.Rectangle;
import javax.swing.*;
public class Player extends Thread 
{
    private JLabel p;
    private ImageIcon i;
    public Rectangle player;
    private int x,y;
    private int w,h;
    private boolean alive = false;
    public void run(){
        while(y != 700){
            p.setLocation(x,y);
            y+=2;
            try{
                Thread.sleep(10);
            }
            catch(Exception e){}
        }
        alive = true;
        JOptionPane.showMessageDialog(null, "you died");
        
    }

    public Player(){
        x = 100;
        y = 350;
        w = 127;
        h=80;
        i = new ImageIcon("img/flappy.png");
        player = new Rectangle(x,y,w,h);
        p = new JLabel(i);
    }
    public JLabel getL(){
        return p;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }
    public void setY(int y){
        this.y = y;
    }
    public boolean gameOver(){
        return alive;
    }
}