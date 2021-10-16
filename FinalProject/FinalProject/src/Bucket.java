//Raymond Mead
//COP2800
//Final Project

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Bucket extends Circle
{
	Circle c;
	int x;
	int y;
	double radius;
	Image bucketImg;
	char[] upperCase;
	
	public Bucket(int x, int y, double radius)
	{
		super(x, y, radius);
		bucketImg = new Image("bucket.png");		
		upperCase = new char[26];
		fillUpperCase(upperCase);
		super.setStroke(null);
		super.setFill(new ImagePattern(bucketImg));
	}
	
	public void fillUpperCase(char[] ary)
	{
		int i = 0;
		char A = 'A';
		
		while(i < 26)
		{
			ary[i] = A;
			A++;
			i++;
		}
	}
	
	public void initImages()
	{
		bucketImg = new Image("bucket.png");
	}
	
	public boolean collide(Bucket b, RainDrop r)
	{
		Shape intersect = Shape.intersect(b,r);
		return(intersect.getBoundsInLocal().getWidth() != -1); 
	}
}
