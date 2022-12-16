import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Gioco extends JFrame implements ActionListener,KeyListener
{
    public Player p = new Player();
    private Tubo t1 = new Tubo(500,600);
    private Tubo t2 = new Tubo(800,600);
    private Tubo t3 = new Tubo(1100,600);
    private Hitboxes h= new Hitboxes();
    private int x = p.getX();
    private int y = p.getY();
    public boolean inGame=true;
    private ImageIcon back =new ImageIcon("img/flappy-background.png");
    private JLabel background=new JLabel(back);
    
    public Gioco(){
        init();
    }
   
    public void init(){ //initialize 6 tubo, 2 for each object
        setLayout(null);
        background.setBounds(0,0,1920,1080);
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
        h.start();
    }
    class Hitboxes extends Thread{
        public void run(){
            while(inGame){
               System.out.println("player position "+p.player.getX()+"  "+p.player.getY()+"rectangle 1 position "+t1.hitMeBaby.getX()+"  "+t1.hitMeBabyParte2LaVendetta.getX()+t1.hitMeBaby.getY()+"  "+t1.hitMeBabyParte2LaVendetta.getY()+"rectangle 2 position "+t2.hitMeBaby.getX()+"  "+t2.hitMeBabyParte2LaVendetta.getX()+t2.hitMeBaby.getY()+"  "+t2.hitMeBabyParte2LaVendetta.getY()+"rectangle 3 position "+t3.hitMeBaby.getX()+"  "+t3.hitMeBabyParte2LaVendetta.getX()+t3.hitMeBaby.getY()+"  "+t3.hitMeBabyParte2LaVendetta.getY());
                if(p.player.intersects(t1.hitMeBaby)||p.player.intersects(t1.hitMeBabyParte2LaVendetta)||p.player.intersects(t2.hitMeBaby)||p.player.intersects(t2.hitMeBabyParte2LaVendetta)||p.player.intersects(t3.hitMeBaby)||p.player.intersects(t3.hitMeBabyParte2LaVendetta)){
                    inGame=false;
                    p.GameOver();
                    p.interrupt();
                }
            }
        }
    }
    public void keyPressed(KeyEvent e){
        if (inGame==true){  
            if (e.getKeyCode() == KeyEvent.VK_SPACE){//on spacebar pressed flappy bird flies
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
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}

    public void actionPerformed(ActionEvent e) {
        
        
    }
}