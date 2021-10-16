//Raymond Mead
//COP 2800
//FinalProject

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class RainDrop extends Circle
{
	Image rainDrop;
	
	public RainDrop(double x, double y, double radius)
	{
		super(x,y,radius);
		rainDrop = new Image("raindrop.png");
		super.setStroke(null);
		super.setFill(new ImagePattern(rainDrop));
	}
}
