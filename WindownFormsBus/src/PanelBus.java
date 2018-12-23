
import javax.swing.JPanel;
import java.awt.Graphics;

public class PanelBus extends JPanel {
	public static StandartBus bus;
	public static boolean initialization = false;
	
	public void paint(Graphics g) { 
		super.paint(g); 
		if(initialization) {
			bus.DrawBus(g);
		}
	}
}
