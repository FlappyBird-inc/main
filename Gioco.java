//import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class Gioco extends JFrame implements KeyListener
{
    JLayeredPane layered = new JLayeredPane();
    public Player p = new Player();
    private Punteggio punti=new Punteggio();
    private Tubo t1 = new Tubo(500,600,punti);
    private Tubo t2 = new Tubo(800,600,punti);
    private Tubo t3 = new Tubo(1100,600,punti);
    private int x = p.getX();
    private int y = p.getY();
    public Gioco(){
        init();
    }
    public void init(){ //initialize 6 tubo, 2 for each object
        setLayout(null);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        this.setContentPane(layered);
        this.addKeyListener(this);
        //player
        p.getL().setLocation(p.getX(),p.getY());
        p.getL().setSize(p.getW(),p.getH());
        //tubo1
        t1.getTUp().setBounds(t1.getPos(0,"x"),t1.getPos(0,"y"),t1.getW(),t1.getH());
        t1.getTDown().setBounds(t1.getPos(1,"x"),t1.getPos(1,"y"),t1.getW(),t1.getH());
        //tubo2
        t2.getTUp().setBounds(t2.getPos(0,"x"),t2.getPos(0,"y"),t2.getW(),t2.getH());
        t2.getTDown().setBounds(t2.getPos(1,"x"),t2.getPos(1,"y"),t2.getW(),t2.getH());
        //tubo3
        t3.getTUp().setBounds(t3.getPos(0,"x"),t3.getPos(0,"y"),t3.getW(),t3.getH());
        t3.getTDown().setBounds(t3.getPos(1,"x"),t3.getPos(1,"y"),t3.getW(),t3.getH());
        //score
        punti.getL().setLocation(punti.getX(),punti.getY());
        punti.getL().setSize(punti.getW(),punti.getH());
        punti.getL().setFont(new Font("Comic Sans", Font.PLAIN, 50));

        add(t1.getTUp());
        add(t2.getTUp());
        add(t3.getTUp());
        add(t1.getTDown());
        add(t2.getTDown());
        add(t3.getTDown());
        add(punti.getL());
        layered.add(punti.getL(), 0);
        add(p.getL());
        setFocusable(true);
        setVisible(true);
        //threads
        p.start();
        t1.start();
        t2.start();
        t3.start();
    }
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_SPACE){//on spacebar pressed flappy bird flies
            y = p.getY();
            p.interrupt();
            y-=40;
            p.setY(y);
            p.getL().setLocation(x,y);
            p.start();
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}