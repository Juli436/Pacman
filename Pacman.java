import java.awt.*;
import java.util.List;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
/**
 * Write a description of class Pacman here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pacman
{
    // instance variables - replace the example below with your own
    private double x;
    private double y;
    private int r;

    public static final int radius = 15;
    public Tile tile;

    public int points;

    public static final int pointsdot = 10;

    /**
     * Constructor for objects of class Pacman
     */
    public Pacman(double x, double y, int r, Tile tile) {
        this.x = x;
        this.y = y;
        this.r = r;
        //oben = 1, im Uhrzeigersinn
        this.tile = tile;

    }

    public void Draw(Graphics graphics){
        graphics.setColor(Color.YELLOW);
        graphics.fillOval((int)(x*Double.valueOf(Tile.size)), (int)(y*Double.valueOf(Tile.size)), radius, radius);
    }

    public void PacmanBewegen() {
        if(!IstObenoderUntenAmRand()) {
            if(!IstWand()) {
                if(r == 1) {
                    y = y+0.1;
                }
                else
                {
                    if(r == 3) {
                        y = y-0.1;
                    }
                    else
                    {
                        if(r== 2) {
                            x = x+0.1;
                        }
                        else
                        {
                            x = x-0.1;
                        }
                    }
                }
            }
        }
        tile = getTile();
    }
    
    
    public Tile getTile(){
        return World.getInstance().tiles[(int)Math.round(x)][(int)Math.round(y)];    
    }
    
    public void fressen() {
        if(IstFood()) {
            tile.type--;
            points = points + pointsdot;
        }
    }

    public boolean IstFood(){
        Boolean[] b = toBinary(tile.type);
        return b[0];
    }

    public boolean IstAmRand() {
        Boolean[] b = toBinary(tile.type);
        if(b[2]||b[3]||b[4]||b[5])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean IstObenoderUntenAmRand() {
        Boolean[] b = toBinary(tile.type);
        if(b[2]||b[4])
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean IstWand() {
        Boolean[] b = toBinary(tile.type);
        if(b[1]) {
            return true;
        }
        else
        {
            return false;
        }

    }
        
    private Boolean[] toBinary(int decimal){
        Boolean[] b = new Boolean[16];
        for(int i= 0; i< b.length; i++){
            b[i] = false;
        }
        int index = 0;    
        while(decimal > 0){    
            if(decimal%2 > 0){
                b[index] = true;
            }
            else{
                b[index] = false;
            }
            index++;
            decimal = decimal/2;    
        } 
        return b;

    }
}
