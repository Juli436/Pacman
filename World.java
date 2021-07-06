import javax.swing.*;
import java.awt.*;

/**
 * Write a description of class Game here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class World
{

    public Tile[][] tiles;
    public static final int x = 30, y = 30; 

    public static World instance;

    public World(){
        tiles = new Tile[x][y];
        for(int i=0; i < tiles.length; i++){
            for(int j=0; j < tiles.length; j++){
                tiles[i][j]= new Tile(i, j, 0);

            }
        }

    }

    public static World getInstance(){
        if(instance == null){
            instance = new World();
        }
        return instance;

    }

    public void Draw(Graphics graphics){
        for(int i=0; i < tiles.length; i++){
            for(int j=0; j < tiles.length; j++){
                graphics.setColor(new Color(100, 100, 100));
                graphics.fillRect(i*Tile.size, j*Tile.size, Tile.size, Tile.size);

            }

        }
    }

}
