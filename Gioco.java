//import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gioco extends JFrame implements ActionListener,KeyListener
{
    Player p = new Player();
    private int x = p.getX();
    private int y = p.getY();
    public Gioco(){
        init();
    }
    
    public void init(){
        setLayout(null);
        setSize(1920,1080);
        this.addKeyListener(this);
        p.getL().setLocation(p.getX(),p.getY());
        p.getL().setSize(p.getW(),p.getH());
        add(p.getL());
        setFocusable(true);
        setVisible(true);
        p.start();
    }
    public void actionPerformed(ActionEvent e){}
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            y = p.getY();
            p.interrupt();
            y-=40;
            p.setY(y);
            p.getL().setLocation(x,y);
            try{
                Thread.sleep(10);
            }
            catch(Exception yeet){}
            p.start();
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}
}