 import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private World world;
    //TODO: Replace System.out.println with Movement
    public KeyHandler(){
    world = World.getInstance();
    
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                 System.out.println("W or UP");
                 world.keyInput(1);
                 break;
            
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                 System.out.println("A or LEFT");
                 world.keyInput(4);
                 break;
            
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                 System.out.println("S or DOWN");
                 world.keyInput(3);
                 break;
            
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D: 
                 System.out.println("D or RIGHT");
                 world.keyInput(2);
                 break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}