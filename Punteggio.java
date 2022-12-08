import java.awt.Rectangle;
import javax.swing.*;
public class Punteggio extends Thread {
    private JLabel l;
    public Rectangle p;
    private int x,y,w,h;
    public Punteggio(){
        x=100;
        y=100;
        w=100;
        h=100;
        p=new Rectangle(x,y,w,h);
        l=new JLabel("0");
    }
    public void run(){
       //l.setLocation(x, y); non serve(è già settato in Gioco) 

    }
    public JLabel getL(){
        return l;
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

}
