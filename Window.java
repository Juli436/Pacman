
import java.awt.*;

public class Window extends Frame{

    private Canvas canvas;

    public Window(){
        super("Pacman");
        this.setSize(640,640);
        initComponents();
        initListeners();


    }
    private void initComponents(){
        canvas = new Canvas();
        add(canvas);

    }

    private void initListeners(){}


}