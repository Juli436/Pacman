
/**
 * Write a description of class Tile here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tile
{
    public final static int size= 20;
    public int x;
    public int y;
    public int type;
    
    // type = 0: Empty Tile
    // type = 1: Tile with "Food"
    // type = 2: Wall
    // type = 4: Top Border
    // type = 8: Right Border
    // type = 16: Bottom Border
    // type = 32: Left Border
    // Can be added together
    

    public Tile(int x, int y, int type){
    this.x = x;
    this.y = y;
    this.type = type;
    
    }
    
    public void setType(int type){
    this.type = type;
    }
   
}
