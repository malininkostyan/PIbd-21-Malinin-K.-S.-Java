
import java.awt.Graphics;
import javax.swing.JPanel;

public class PanelParking extends JPanel{

	public  Parking<ITransport> parking;
	public Parking<ITransport> getParking() {

		return parking;
	}

	public PanelParking() {
		
		parking = new Parking<>(20, 615, 603);
	}

	@Override 
	public void paint(Graphics g) { 
		super.paint(g); 
		if(parking != null) {
				
			parking.Draw(g);
		}
	}
}