
import javax.swing.JPanel;
import java.awt.Graphics;

public class PanelBus extends JPanel {
	public static ITransport bus;
	public static boolean initialization = false;
	
	void setBus(ITransport transport) {
        bus = transport;
    }
	
	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
		if(initialization) {
			bus.DrawBus(g);
		}
	}
}
