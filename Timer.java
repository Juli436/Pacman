
/**
 * Beschreiben Sie hier die Klasse Timer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Timer extends Thread
{
    private Pacman pacman;
    public Timer(Pacman pacman){
        this.pacman = pacman;
    }

    public void run() {

        try
        { while(true){
                sleep(15);
                //System.out.println("Hello World!"); 
                pacman.PacmanBewegen();
                pacman.fressen();
            }
        }
        catch (InterruptedException ex) {}
    }
}
