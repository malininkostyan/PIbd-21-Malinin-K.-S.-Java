
import java.awt.Color;
import java.awt.Graphics;

public class Bus extends StandartBus{	
	
	private Color DopColor;
	private boolean Toner ;
    private boolean Garm ;
    
	public Bus(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean  garm, boolean  toner) {      
		super(maxSpeed, weight, mainColor);
        DopColor = dopColor;
        Garm = garm;
        Toner = toner;
    }

	public void DrawBus(Graphics g) {
		super.DrawBus(g);
		if(Garm){
			g.setColor(DopColor);
			g.fillRect( (int)_startPosX + 88, (int)_startPosY - 6, 50, 30);
					
			g.setColor(Color.BLACK);
			g.fillOval((int)_startPosX + 113, (int)_startPosY + 15, 15, 15);
			g.fillRect( (int)_startPosX + 80, (int)_startPosY - 3, 8, 25);
			
			if(Toner){
				g.fillRect( (int)_startPosX + 103, (int)_startPosY, 7, 7);
				g.fillRect((int) _startPosX + 114, (int)_startPosY, 7, 7);
				g.fillRect((int) _startPosX + 125, (int)_startPosY, 7, 7);
				g.fillRect( (int)_startPosX + 92, (int)_startPosY, 7, 7);
			}
			else{
				g.setColor(Color.BLUE);
				g.fillRect( (int)_startPosX + 103, (int)_startPosY, 7, 7);
				g.fillRect((int) _startPosX + 114, (int)_startPosY, 7, 7);
				g.fillRect((int) _startPosX + 125, (int)_startPosY, 7, 7);
				g.fillRect( (int)_startPosX + 92, (int)_startPosY, 7, 7);
			}
		}	
	}
}
