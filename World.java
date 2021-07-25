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
    
    public static final int offset = 1;

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

        for(int i=0; i < 30; i++)
        {
            tiles[i][0].type = tiles[i][0].type -1 +2;
            tiles[i][29].type = tiles[i][29].type -1 +2;
        }

        for(int i=0; i < 30; i++)
        {
            tiles[0][i].type = tiles[0][i].type -1 +2;
            tiles[29][i].type = tiles[29][i].type -1 +2;
        }
        //Block left middle
        for(int i=2; i < 5;  i++)
        {
            tiles[i][2].type = tiles[i][2].type -1 +2;
        }

        for(int i=2; i < 5;  i++)
        {
            tiles[i][3].type = tiles[i][3].type -1 +2;
        }

        for(int i=2; i < 5;  i++)
        {
            tiles[i][4].type = tiles[i][4].type -1 +2;
        }

        //Block middle middle
        for(int i=7; i < 12;  i++)
        {
            tiles[i][2].type = tiles[i][2].type -1 +2;
        }

        for(int i=7; i < 12;  i++)
        {
            tiles[i][3].type = tiles[i][3].type -1 +2;
        }

        for(int i=7; i < 12;  i++)
        {
            tiles[i][4].type = tiles[i][4].type -1 +2;
        }

        //block middle right
        // for(int i=2; i < 5;  i++)
        // {
            // tiles[13][i].type = tiles[13][i].type -1 +2;
        // }

        //collum middle high
        for(int i=1; i < 5;  i++)
        {
            tiles[15][i].type = tiles[15][i].type -1 +2;
        }

        //collum low middle above Spawn
        for(int i=7; i < 1;  i++)
        {
            tiles[15][i].type = tiles[15][i].type -1 +2;
        }

        //collum high middle under Spawn
        for(int i=18; i < 24;  i++)
        {
            tiles[15][i].type = tiles[15][i].type -1 +2;
        }

        //collum low middle under spawn
        for(int i=25; i < 30;  i++)
        {
            tiles[15][i].type = tiles[15][i].type -1 +2;
        }

        //long collum left to spawn
        for(int i=10; i < 18;  i++)
        {
            tiles[10][i].type = tiles[10][i].type -1 +2;
        }

        for(int i=7; i < 12;  i++)
        {
            tiles[22][i].type = tiles[22][i].type -1 +2;
        }

        for(int i=17; i < 24;  i++)
        {
            tiles[22][i].type = tiles[22][i].type -1 +2;
        }

        for(int i=8; i < 15;  i++)
        {
            tiles[18][i].type = tiles[18][i].type -1 +2;
        }

        //penis shaft 1
        for(int i=13; i < 21;  i++)
        {
            tiles[8][i].type = tiles[8][i].type -1 +2;
        }

        //penis shaft 2
        for(int i=13; i < 21;  i++)
        {
            tiles[7][i].type = tiles[7][i].type -1 +2;
        }

        //penis balls 1
        for(int i=19; i < 21;  i++)
        {
            tiles[6][i].type = tiles[6][i].type -1 +2;
        }

        //penis balls 2
        for(int i=19; i < 21;  i++)
        {
            tiles[9][i].type = tiles[9][i].type -1 +2;
        }

        for(int i=25; i < 28;  i++)
        {
            tiles[13][i].type = tiles[13][i].type -1 +2;
        }

        for(int i=25; i < 28;  i++)
        {
            tiles[17][i].type = tiles[17][i].type -1 +2;
        }

        for(int i=2; i < 5;  i++)
        {
            tiles[13][i].type = tiles[13][i].type -1 +2;
        }

        for(int i=2; i < 5;  i++)
        {
            tiles[17][i].type = tiles[17][i].type -1 +2;
        }
        //cum
        tiles[8][11].type = tiles[8][11].type -1 +2;
        tiles[7][9].type = tiles[7][10].type -1 +2;
        tiles[7][10].type = tiles[7][9].type -1 +2;

        for(int i=19; i < 21;  i++)
        {
            tiles[9][i].type = tiles[9][i].type -1 +2;
        }

        for(int i=2; i < 6;  i++)
        {
            tiles[i][26].type = tiles[i][26].type -1 +2;
            tiles[i][27].type = tiles[i][27].type -1 +2;
            tiles[i][25].type = tiles[i][25].type -1 +2;
        }

        for(int i=7; i < 12;  i++)
        {
            tiles[i][26].type = tiles[i][26].type -1 +2;
            tiles[i][27].type = tiles[i][27].type -1 +2;
            tiles[i][25].type = tiles[i][25].type -1 +2;
        }

        for(int i=19; i < 24;  i++)
        {
            tiles[i][26].type = tiles[i][26].type -1 +2;
            tiles[i][27].type = tiles[i][27].type -1 +2;
            tiles[i][25].type = tiles[i][25].type -1 +2;
        }

        for(int i=25; i < 28;  i++)
        {
            tiles[i][26].type = tiles[i][26].type -1 +2;
            tiles[i][27].type = tiles[i][27].type -1 +2;
            tiles[i][25].type = tiles[i][25].type -1 +2;
        }

        for(int i=27; i < 29;  i++)
        {
            tiles[i][23].type = tiles[i][23].type -1 +2;
            tiles[i][6].type = tiles[i][6].type -1 +2;
        }

        for(int i=25; i < 29;  i++)
        {
            tiles[i][15].type = tiles[i][15].type -1 +2;
            tiles[i][13].type = tiles[i][13].type -1 +2;
        }

        for(int i=1; i < 5;  i++)
        {
            tiles[i][15].type = tiles[i][15].type -1 +2;
            tiles[i][13].type = tiles[i][13].type -1 +2;
        }

        for(int i=2; i < 5;  i++)
        {
            tiles[i][10].type = tiles[i][10].type -1 +2;
            tiles[i][11].type = tiles[i][11].type -1 +2;
            tiles[i][17].type = tiles[i][17].type -1 +2;
            tiles[i][18].type = tiles[i][18].type -1 +2;
            tiles[i][20].type = tiles[i][20].type -1 +2;
            tiles[i][21].type = tiles[i][21].type -1 +2;
        }

        for(int i=24; i < 28;  i++)
        {
            tiles[i][10].type = tiles[i][10].type -1 +2;
            tiles[i][11].type = tiles[i][11].type -1 +2;
            tiles[i][17].type = tiles[i][17].type -1 +2;
            tiles[i][18].type = tiles[i][18].type -1 +2;
            tiles[i][20].type = tiles[i][20].type -1 +2;
            tiles[i][21].type = tiles[i][21].type -1 +2;
        }

        for(int i=18; i < 21;  i++)
        {
            tiles[i][14].type = tiles[i][14].type -1 +2;
            tiles[i][15].type = tiles[i][15].type -1 +2;
            tiles[i][8].type = tiles[i][8].type -1 +2;
        }

        for(int i=20; i < 22;  i++)
        {
            tiles[i][10].type = tiles[i][10].type -1 +2;
        }

        tiles[22][12].type = tiles[22][12].type -1 +2;
        tiles[20][12].type = tiles[20][12].type -1 +2;
        tiles[20][11].type = tiles[20][11].type -1 +2;

        for(int i=24; i < 28;  i++)
        {
            tiles[i][8].type = tiles[i][8].type -1 +2;
        }

        for(int i=24; i < 28;  i++)
        {
            tiles[i][3].type = tiles[i][3].type -1 +2;
            tiles[i][2].type = tiles[i][2].type -1 +2;
            tiles[i][4].type = tiles[i][4].type -1 +2;
        }

        for(int i=19; i < 23;  i++)
        {
            tiles[i][3].type = tiles[i][3].type -1 +2;
            tiles[i][2].type = tiles[i][2].type -1 +2;
            tiles[i][4].type = tiles[i][4].type -1 +2;
        }

        for(int i=10; i < 14;  i++)
        {
            tiles[i][8].type = tiles[i][8].type -1 +2;
        }

        for(int i=1; i < 3;  i++)
        {
            tiles[i][23].type = tiles[i][23].type -1 +2;
        }

        for(int i=4; i < 5;  i++)
        {
            tiles[i][23].type = tiles[i][23].type -1 +2;
        }

        for(int i=6; i < 8;  i++)
        {
            tiles[i][23].type = tiles[i][23].type -1 +2;
        }

        for(int i=10; i < 14;  i++)
        {
            tiles[i][23].type = tiles[i][23].type -1 +2;
        }

        for(int i=17; i < 20;  i++)
        {
            tiles[i][23].type = tiles[i][23].type -1 +2;
        }

        for(int i=20; i < 23;  i++)
        {
            tiles[i][21].type = tiles[i][21].type -1 +2;
        }

        for(int i=18; i < 21;  i++)
        {
            tiles[i][17].type = tiles[i][17].type -1 +2;
        }

        for(int i=17; i < 20;  i++)
        {
            tiles[20][i].type = tiles[20][i].type -1 +2;
        }

        for(int i=19; i < 20;  i++)
        {
            tiles[18][i].type = tiles[18][i].type -1 +2;
        }

        for(int i=19; i < 22;  i++)
        {
            tiles[13][i].type = tiles[13][i].type -1 +2;
            tiles[12][i].type = tiles[12][i].type -1 +2;
        }

        for(int i=7; i < 12;  i++)
        {
            tiles[15][i].type = tiles[15][i].type -1 +2;
        }

        //Spawn block (optional):
        
        // for(int i=14; i < 17;  i++)
        // {
            // tiles[i][14].type = tiles[i][14].type -1 +2;
            // tiles[i][15].type = tiles[i][14].type -1 +2;
            // tiles[i][13].type = tiles[i][14].type -1 +2;
            // tiles[i][16].type = tiles[i][16].type -1 +2;
        // }

        for(int i=2; i < 5;  i++)
        {
            tiles[i][6].type = tiles[i][6].type -1 +2;
            tiles[i][8].type = tiles[i][7].type -1 +2;
            tiles[i][7].type = tiles[i][8].type -1 +2;
        }

        for(int i=7; i < 12;  i++)
        {
            tiles[i][6].type = tiles[i][6].type -1 +2;
        }

        tiles[23][14].type = tiles[23][14].type -1 +2;
        tiles[22][14].type = tiles[22][14].type -1 +2;
        tiles[13][6].type = tiles[13][6].type -1 +2;
        tiles[15][6].type = tiles[15][6].type -1 +2;
        tiles[17][6].type = tiles[17][6].type -1 +2;

        for(int i=19; i < 21;  i++)
        {
            tiles[i][6].type = tiles[i][6].type -1 +2;
        }

        for(int i=24; i < 26;  i++)
        {
            tiles[i][6].type = tiles[i][6].type -1 +2;
        }

        for(int i=10; i < 14;  i++)
        {
            tiles[12][i].type = tiles[12][i].type -1 +2;
        }

        for(int i=15; i < 18;  i++)
        {
            tiles[12][i].type = tiles[12][i].type -1 +2;
        }
        
        //tell me why this fixes the food problem lol. 
        //I have no clue why this fixes it
        //my best guess is it changes the value of every
        //tile to the one of tile 0;0
        tiles[0][0].type--;
        //tiles[15][0].type = tiles[15][0].type;
        tiles[29][0].type--;
        tiles[0][29].type--;
        tiles[15][29].type--;
        tiles[29][29].type--;
        tiles[9][19].type--;
        tiles[9][20].type--;
        tiles[22][21].type--;
        tiles[20][17].type--;
        tiles[18][14].type--;
        tiles[18][8].type--;
        tiles[2][7].type--;
        tiles[3][7].type--;
        tiles[4][7].type--;
        tiles[7][10].type--;
        tiles[13][3].type--;
        tiles[13][2].type--;
        tiles[13][4].type--;
        
        
        tiles[0][14].type = tiles[0][14].type -2;
        tiles[29][14].type = tiles[29][14].type -2;
        
        System.out.println(tiles[0][14].type);
        
        
        
        Tile start = tiles[15][15];
        pacman = new Pacman(start.x, start.y, start, this);
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
                

                graphics.fillRect(i*Tile.size + offset, j*Tile.size + offset, Tile.size- offset*2, Tile.size - offset*2);
                if(b[0]){
                    graphics.setColor(new Color(250, 250, 250));
                    graphics.fillOval(i*Tile.size + (Tile.size/2 - 1), j*Tile.size + (Tile.size/2 - 1), 2, 2);
                
                }


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
