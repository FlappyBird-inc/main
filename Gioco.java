//import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gioco extends JFrame implements ActionListener,KeyListener
{
    Player p = new Player();
    Tubo t1 = new Tubo(500,600);
    Tubo t2 = new Tubo(800,600);
    Tubo t3 = new Tubo(1100,600);
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
        t1.getTUp().setLocation(t1.getPos(0,"x"),t1.getPos(0,"y"));
        t2.getTUp().setLocation(t2.getPos(0,"x"),t2.getPos(0,"y"));
        t3.getTUp().setLocation(t3.getPos(0,"x"),t3.getPos(0,"y"));
        t1.getTUp().setSize(t1.getW(),t1.getH());
        t2.getTUp().setSize(t2.getW(),t2.getH());
        t3.getTUp().setSize(t3.getW(),t3.getH());
        t1.getTDown().setLocation(t1.getPos(1,"x"),t1.getPos(1,"y"));
        t2.getTDown().setLocation(t2.getPos(1,"x"),t2.getPos(1,"y"));
        t3.getTDown().setLocation(t3.getPos(1,"x"),t3.getPos(1,"y"));
        t1.getTDown().setSize(t1.getW(),t1.getH());
        t2.getTDown().setSize(t2.getW(),t2.getH());
        t3.getTDown().setSize(t3.getW(),t3.getH());
        add(t1.getTUp());
        add(t2.getTUp());
        add(t3.getTUp());
        add(t1.getTDown());
        add(t2.getTDown());
        add(t3.getTDown());
        add(p.getL());
        setFocusable(true);
        setVisible(true);
        p.start();
        t1.start();
        t2.start();
        t3.start();
    }
    public void actionPerformed(ActionEvent e){}
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
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
            if(p.gameOver()){
                t1.interrupt();
                t2.interrupt();
                t3.interrupt();
            }
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e) {}
}