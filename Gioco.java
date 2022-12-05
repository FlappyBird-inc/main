import java.awt.*;
import javax.swing.*;

public class Gioco extends JFrame
{
    Player p = new Player();
    
    public Gioco(){
        init();
    }
    
    public void init(){
        setLayout(null);
        setSize(1920,1080);
        p.getL().setLocation(p.getX(),p.getY());
        p.getL().setSize(p.getW(),p.getH());
        add(p.getL());
        show();
    }
}