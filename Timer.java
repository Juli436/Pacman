
/**
 * Beschreiben Sie hier die Klasse Timer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Timer extends Thread
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    
    public void run() {
        
        try
        { while(true){
            sleep(1000);
            //System.out.println("Hello World!");  
        }
        }
        catch (InterruptedException ex) {}
    }
}
