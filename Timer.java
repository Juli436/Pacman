import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Timer.

/**
 * Beschreiben Sie hier die Klasse Timer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Timer extends Thread
{
    private Pacman pacman;
    
    private long lastTime;
    private int deltaTime;
    public Timer(Pacman pacman){
        this.pacman = pacman;
        
        lastTime = Calendar.getInstance().getTimeInMillis();
    }

    public void run() {
        
        while(true){
            try{
            
            deltaTime = (int)(Calendar.getInstance().getTimeInMillis() - lastTime);
            lastTime = Calendar.getInstance().getTimeInMillis();
            

            pacman.PacmanBewegen(deltaTime);
            pacman.fressen();
            sleep(20);

        }
        catch(InterruptedException e){
        System.out.println("exception");}
      
    }
    }
}

