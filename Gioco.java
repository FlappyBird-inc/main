import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Gioco extends JFrame implements KeyListener
{
    JLayeredPane layered = new JLayeredPane();
    public Player p = new Player();
    private Punteggio punti=new Punteggio();
    private Tubo t1 = new Tubo(500,600,punti);
    private Tubo t2 = new Tubo(800,600,punti);
    private Tubo t3 = new Tubo(1100,600,punti);
    private Hitboxes h= new Hitboxes();
    private int x = p.getX();
    private int y = p.getY();
    public boolean inGame=true;
    private ImageIcon back =new ImageIcon("img/background.png");
    private JLabel background=new JLabel(back);
    private JButton retry = new JButton("retry");
    
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
        punti.getL().setBounds(punti.getX(),punti.getY(),punti.getW(),punti.getH());
        punti.getL().setFont(new Font("Comic Sans", Font.PLAIN, 50));
        
        background.setBounds(0,0,1000,800);

        retry.setBounds(450,400, 100,50);
        retry.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Gioco game = new Gioco();
                dispose();
            }
        });

        add(t1.getTUp());
        add(t2.getTUp());
        add(t3.getTUp());
        add(t1.getTDown());
        add(t2.getTDown());
        add(t3.getTDown());
        add(punti.getL());
        add(retry);
        retry.setVisible(false);
        layered.add(punti.getL(), 0);
        add(p.getL());
        add(background);
        setFocusable(true);
        setVisible(true);
        //threads
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
                    retry.setVisible(true);
                }
            }
        }
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