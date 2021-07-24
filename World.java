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
    public Pacman pacman;
    public Timer timer;
    public int lastKey;
    public static final int x = 30, y = 30; 
    public int numfood;

    public static World instance;

    public World(){

        tiles = new Tile[x][y];
        for(int i=0; i < tiles.length; i++){
            for(int j=0; j < tiles.length; j++){
                tiles[i][j]= new Tile(i, j, 1);
                //adding borders
                if(i == 0){
                    tiles[i][j].type = tiles[i][j].type +32;
                }
                if(j == 0){
                    tiles[i][j].type = tiles[i][j].type +4;
                }
                if(i == tiles.length-1){
                    tiles[i][j].type = tiles[i][j].type +8;
                }
                if(j == tiles.length-1){
                    tiles[i][j].type = tiles[i][j].type +16;
                }

            }
        }

        //adding a test wall
        // for(int i=5; i < 26; i++){
            // tiles[i][15].type = tiles[i][15].type -1 +2;

        // }
        Tile start = tiles[15][15];
        pacman = new Pacman(start.x, start.y, 1, start);
        numfood = 0;
        for(int i=0; i < tiles.length; i++){
            for(int j=0; j < tiles.length; j++){
                Boolean[] b = toBinary(tiles[i][j].type);
                if(b[0]){
                    numfood ++;
                }

            }
        }
        timer = new Timer(pacman);
        timer.start();
       
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
                Boolean[] b = toBinary(tiles[i][j].type);
                graphics.setColor(new Color(100,100, 100));
                // For Testing: Make Borders visible
                // if(b[2]){
                // graphics.setColor(new Color(250, 0, 0));
                // }
                // if(b[3]){
                // graphics.setColor(new Color(0, 250, 0));
                // }
                // if(b[4]){
                // graphics.setColor(new Color(0, 0, 250));
                // }
                // if(b[5]){
                // graphics.setColor(new Color(0, 0, 0));
                // }
                if(b[1]){
                    graphics.setColor(new Color(0, 0, 250));
                }

                graphics.fillRect(i*Tile.size, j*Tile.size, Tile.size, Tile.size);


            }

        }
        pacman.Draw(graphics);
       
    }

    public void keyInput(int key){
        lastKey = key;
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
