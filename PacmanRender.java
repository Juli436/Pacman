import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PacmanRender
{ 
    private static PacmanRender instance;
    
    private static BufferedImage right;
    private static BufferedImage left;
    private static BufferedImage up;
    private static BufferedImage down;
    private static BufferedImage ate;
  
    private char spriteType;//used for different sprites of pacman: 
                            //'n'orth, 'e'ast, 'w'est, 's'outh, 'a'te (after pacman ate)
    private int numberAfterAteAnimation = 40;//keeps the "ate" frame for a moment
    
    public PacmanRender(){
        try
        {
            right = ImageIO.read(new File("Graphics/right.png"));
            left  = ImageIO.read(new File("Graphics/left.png"));
            up    = ImageIO.read(new File("Graphics/up.png"));
            down  = ImageIO.read(new File("Graphics/down.png"));
            ate   = ImageIO.read(new File("Graphics/ate.png"));
        }
        catch (IOException e)
        {
            System.out.println("at least one file not found");
        }
        spriteType = 'e';
    }
    
    public static PacmanRender getInstance(){
        if(instance == null){
            instance = new PacmanRender();
        }
        return instance;
    }
    
    public void setSpriteType(char type)
    {
        if(numberAfterAteAnimation == 40)
        {
            if(type == 'a')
                numberAfterAteAnimation = 0;
            spriteType = type;
        }
        else
        {
            numberAfterAteAnimation++;
        }
    }
    
    //called from Pacman
    public void Draw(Graphics graphics, int x, int y){
            switch(spriteType)
            {
                case('n'):
                    graphics.drawImage(up,x,y,null);
                    break;
                
                case('e'):
                    graphics.drawImage(right,x,y,null);
                    break;
                
                case('s'):
                    graphics.drawImage(down,x,y,null);
                    break;
                
                case('w'):
                    graphics.drawImage(left,x,y,null);
                    break;
                
                case('a'):
                    graphics.drawImage(ate,x,y,null);
                    break;
            }
    }

}
