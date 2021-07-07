import javax.swing.*;
import java.awt.*;

public class Gui extends JPanel{
    public static final int width = 625, height = 650;
    
    public JFrame frame;

    public Gui() {
        frame = new JFrame("Pacman");
        frame.setSize(width - 12, height - 12);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        this.setBounds(0, 0, width - 12, height - 12);
        this.setVisible(true);
        frame.add(this);
        
        frame.addKeyListener(new KeyHandler());

        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

       
        graphics.setColor(new Color(0, 0, 0));
        graphics.fillRect(0, 0, Gui.width, Gui.height);

        World.getInstance().Draw(graphics);

        
        repaint();
    }
}
