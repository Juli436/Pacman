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
    private int timeR;

    private World world;
    private Boolean rchanged;

    public static final int radius = 15;
    public Tile tile;
    public Tile lastTile;

    public int points;

    public static final double speed = 0.0045;

    public static final int pointsdot = 10;

    /**
     * Constructor for objects of class Pacman
     */
    public Pacman(double x, double y,  Tile tile, World world) {
        this.x = x;
        this.y = y;
        this.r = 1;
        this.world = world;
        //oben = 1, im Uhrzeigersinn
        this.tile = tile;
        lastTile = world.tiles[(int)x][(int)y+1];
        timeR = 0;
        rchanged = false;

    }

    public void Draw(Graphics graphics){
        graphics.setColor(Color.YELLOW);
        graphics.fillOval((int)(x*Double.valueOf(Tile.size)+ (Tile.size-radius)/2), (int)(y*Double.valueOf(Tile.size) +(Tile.size-radius)/2), radius, radius);
    }

    public void PacmanBewegen(int deltaTime) {
        Boolean[] b = toBinary(tile.type);
        if((!(b[2]&& r==1)) && (!(b[4]&& r==3)))
        {

            if(!IstWand()) {
                rchanged = false;
                if(b[3] && r == 2){
                    x= 0 + x%1;
                    
                }
                if(b[5] && r == 4){
                    x= World.getInstance().x - x%1;
                }
                move(deltaTime);
            }
            else{
                if(rchanged){
                    tile = lastTile;
                    x = tile.x;
                    y = tile.y;
                    rchanged = false;
                    move(deltaTime);
                }

            }
        }
        tile = getTile();
        timeR = timeR+ deltaTime;
        if((timeR*speed)> 1){
            int prevr = r;
            r = World.getInstance().lastKey;
            if(prevr != r){
                rchanged = true;
            }
            timeR = timeR - (int)(1/speed);
        }
    }

    private void move(int deltaTime){
        if(r == 3) {
            y = y+(deltaTime*speed);
        }
        else
        {
            if(r == 1) {
                y = y-(deltaTime*speed);
            }
            else
            {
                if(r== 2) {
                    x = x+(deltaTime*speed);
                }
                else
                {
                    x = x-(deltaTime*speed);
                }
            }
        }

    }

    public Tile getTile(){
        Tile t = tile;
        tile = World.getInstance().tiles[(int)Math.round(x)][(int)Math.round(y)];

        if(t != tile){
            lastTile = t;
        }
        return tile; 
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
