
import java.awt.Color;
import java.awt.Graphics;

public class StandartBus extends Vehicle{
	protected  int busWidth = 100;
    protected  int busHeight = 60;
    
    public StandartBus(int maxSpeed, float weight, Color mainColor)
    {
        MaxSpeed = maxSpeed;
        Weight = weight;
        MainColor = mainColor;
    }
   
    public  void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Right:
                if (_startPosX + step < _pictureWidth - busWidth)
                {
                    _startPosX += step;
                }
                break;
            case Left:
                if (_startPosX - step > 0)
                {
                    _startPosX -= step;
                }
                break;
            case Up:
                if (_startPosY - step - 10 > 0)
                {
                    _startPosY -= step;
                }
                break;
            case Down:
                if (_startPosY + step < _pictureHeight - busHeight)
                {
                    _startPosY += step;
                }
                break;
        }
    }
    public void DrawBus(Graphics g)
    {
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
    }
}
