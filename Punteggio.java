import java.awt.Rectangle;
import javax.swing.*;
public class Punteggio{
    private JLabel l;
    public Rectangle p;
    private int x,y,w,h;
    private String score = "0";
    public Punteggio(){
        x=500;
        y=100;
        w=100;
        h=100;
        p=new Rectangle(x,y,w,h);
        l=new JLabel(score);
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
    public String getScore() {
        return score;
    }
    public void setScore(String score) {
        this.score = score;
        l.setText(score);
    }
}