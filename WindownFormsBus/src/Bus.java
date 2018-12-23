
import java.awt.Color;
import java.awt.Graphics;

public class Bus {
	private float _startPosX;
	
	private float _startPosY;
	
	private int _pictureWidth;
	
	private int _pictureHeight;
	
	private int shipWidth = 100;
	
	private int shipHeight = 60;
	
	private int MaxSpeed;
	
	public int getMaxSpeed(){
		return MaxSpeed;
	}
	private void setMaxSpeed(int value){
		MaxSpeed = value;
	}
	private float Weight;
	
	public float getWeight(){
		return Weight;
	}	
	private void setWeight(float value){
	Weight = value;
	}
	
	private Color MainColor;
	
	public Color getMainColor(){
		return MainColor;
	}
	private void setMainColor(Color value){
	MainColor = value;
	}
	
	private Color DopColor;
	
	public Color getDopColor(){
		return DopColor;
	}
	private void setDopColor(Color value){
	DopColor = value;
	}
	
	private boolean Toner ;
	
	public boolean getToner(){
		return Toner;
	}
	private void setToner(boolean value){
		Toner = value;
	}
	
    private boolean Garm ;
    
    public boolean getGarm(){
		return Garm;
	}
    private void setGarm(boolean value){
		Garm = value;
	}
    
	public Bus(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean garm,boolean toner) {
		setMaxSpeed (maxSpeed);
		setWeight(weight);
		setMainColor(mainColor);
		setDopColor (dopColor);
		setGarm(garm);
		setToner(toner);		
	}
	
	public void SetPosition(int x, int y, int width, int height) {
		_startPosX = x;
		_startPosY = y;
		_pictureWidth = width;
		_pictureHeight = height;
	}

	public void MoveTransport(Direction direction) {
		float step = getMaxSpeed() * 200 / getWeight();
		switch (direction) {
		case Right:
			if (_startPosX + step < _pictureWidth - shipWidth-25) {
				_startPosX += step;
			}
			break;
		case Left:
			if (_startPosX - step > 0-8) {
				_startPosX -= step;
			}
			break;
		case Up:
			if (_startPosY - step - 10 > 0) {
				_startPosY -= step;
			}
			break;
		case Down:
			if (_startPosY + step < _pictureHeight - shipHeight+30) {
				_startPosY += step;
			}
			break;
		}
	}
	public final void DrawBus(Graphics g){
		g.setColor(MainColor);
		g.fillRect((int)_startPosX + 10, (int)_startPosY - 6, 70, 30);
		
		g.setColor(Color.BLACK);
		g.fillOval((int) _startPosX + 63, (int)_startPosY + 15, 15, 15);
		g.fillRect( (int)_startPosX + 13, (int)_startPosY, 8, 8);
		g.fillOval( (int)_startPosX + 25, (int)_startPosY + 15, 15, 15);

		g.setColor(Color.BLUE);
		g.fillRect( (int)_startPosX + 62,(int) _startPosY, 7, 7);
		g.fillRect( (int)_startPosX + 72,(int) _startPosY, 7, 7);
		g.fillRect( (int)_startPosX + 43,(int) _startPosY, 7, 7);
		g.fillRect((int)_startPosX + 33, (int)_startPosY, 7, 7);
		g.fillRect((int) _startPosX + 23,(int) _startPosY, 7, 7);
		g.fillRect( (int)_startPosX + 52, (int)_startPosY, 7, 7);
			
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
