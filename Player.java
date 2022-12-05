import java.awt.Rectangle;
import javax.swing.*;
public class Player
{
    private JLabel p;
    private ImageIcon i;
    public Rectangle player;
    private int x,y;
    private int w,h;
    public Player(){
        x = 50;
        y = 50;
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
}