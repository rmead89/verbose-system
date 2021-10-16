//Raymond Mead
//COP 2800
//FinalProject

import java.util.Random;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.event.EventHandler;

public class MainClass extends Application
{
	//Data Members
	Pane p;
	Bounds bounds;
	Image bucketImg;
	Image bgImg;
	Bucket bucket;
	Text bucketLetter;
	Text rainLetter;
	RainDrop one;
	RainDrop two;
	RainDrop three;
	Path path;
	Label test;
	Scene scene;
	Scene scene2;
	Pane p2;
	VBox v2;
	Timer t;
	Text wrongLetterOne;
	Text wrongLetterTwo;
	Text winner;
	Text loser;
	Text winsNumber;
	Button restart;
	int wins;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	public void start(Stage stage)
	{
		initImages();
		game(randomLetter());
		setScene(stage);
		t = new Timer(p, bucket, two, rainLetter, bucketLetter, winner, loser);
		t.start();
	}
	
	public void initImages()
	{
		bucketImg = new Image("bucket.png");
		bgImg = new Image("bg.jpg");
	}
	
	public boolean inBounds(Circle bucket)
	{
	
		bounds = p.getLayoutBounds();
		
		if((bucket.getCenterX() <= (bucket.getRadius() / 2 + bounds.getMinX())))
		{
			return false;
		}

		if(bucket.getCenterX() >= (bounds.getMaxX()-20 - bucket.getRadius() / 2))
		{
			return false;
		}
		
		else 
		{
			return true;
		}
	}
		
	public void middlePath(RainDrop r)
	{
		path = new Path();
		LineTo l = new LineTo(300, 800);
		MoveTo m = new MoveTo(300, 75);
		path.getElements().addAll(m,l);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setNode(r);
		pt.setPath(path);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		pt.play();		
	}
	
	public void middlePathText(Text t)
	{
		path = new Path();
		LineTo l = new LineTo(300, 800);
		
		MoveTo m = new MoveTo(300, 75);
		path.getElements().addAll(m,l);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setNode(t);
		pt.setPath(path);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		pt.play();
	}
	
	public void leftPath(RainDrop r)
	{
		path = new Path();
		LineTo l = new LineTo(100, 800);
		MoveTo m = new MoveTo(100, 100);
		path.getElements().addAll(m,l);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setNode(r);
		pt.setPath(path);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		pt.play();		
	}
	
	public void leftPathText(Text t)
	{
		path = new Path();
		LineTo l = new LineTo(100, 800);
		MoveTo m = new MoveTo(100, 100);
		path.getElements().addAll(m,l);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setNode(t);
		pt.setPath(path);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		pt.play();
	}
	
	public void rightPath(RainDrop r)
	{
		path = new Path();
		LineTo l = new LineTo(500, 800);
		MoveTo m = new MoveTo(500, 82);
		path.getElements().addAll(m,l);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setNode(r);
		pt.setPath(path);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		pt.play();		
	}
	
	public void rightPathText(Text t)
	{
		path = new Path();
		LineTo l = new LineTo(500, 800);
		MoveTo m = new MoveTo(500, 82);
		path.getElements().addAll(m,l);
		
		PathTransition pt = new PathTransition();
		pt.setDuration(Duration.seconds(20));
		pt.setNode(t);
		pt.setPath(path);
		pt.setCycleCount(1);
		pt.setAutoReverse(false);
		pt.play();
		
	}
	
	public void game(int letter)
	{
		bucket = new Bucket(320,375,120);
		bucketLetter = new Text((Character.toString(bucket.upperCase[letter])));
		bucketLetter.setFill(Color.WHITE); 
		bucketLetter.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 100)); 
		bucketLetter.setStrokeWidth(2); 
		bucketLetter.setStroke(Color.BLACK); 
		bucketLetter.setX(bucket.getCenterX() - 30 );
		bucketLetter.setY(bucket.getCenterY() + 30);
		
		one = new RainDrop(100,50,48);
		two = new RainDrop(300,75,58);
		three = new RainDrop(500,82,52);
		
		rainLetter = new Text((Character.toString(bucket.upperCase[letter]).toLowerCase()));	
		rainLetter.setFill(Color.WHITE); 
		rainLetter.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 75)); 
		rainLetter.setStrokeWidth(2); 
		rainLetter.setStroke(Color.BLACK); 
		rainLetter.setX(two.getCenterX() - two.getRadius()/2);
		rainLetter.setY(two.getCenterY() + two.getRadius()/2);
		
		wrongLetterOne = new Text(randomWrongLetter(rainLetter));
		wrongLetterOne.setFill(Color.WHITE); 
		wrongLetterOne.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 75)); 
		wrongLetterOne.setStrokeWidth(2); 
		wrongLetterOne.setStroke(Color.BLACK); 
		wrongLetterOne.setX(one.getCenterX() - one.getRadius()/2);
		wrongLetterOne.setY(one.getCenterY() + one.getRadius()/2);
		
		wrongLetterTwo = new Text(randomWrongLetter(rainLetter));
		wrongLetterTwo.setFill(Color.WHITE); 
		wrongLetterTwo.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 75)); 
		wrongLetterTwo.setStrokeWidth(2); 
		wrongLetterTwo.setStroke(Color.BLACK); 
		wrongLetterTwo.setX(three.getCenterX() - three.getRadius()/2);
		wrongLetterTwo.setY(three.getCenterY() + three.getRadius()/2);
		
		winner = new Text("Correct! \n" + "   " + rainLetter.getText() + " = " + bucketLetter.getText());
		winner.setFill(Color.WHITE); 
		winner.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 75)); 
		winner.setStrokeWidth(2); 
		winner.setStroke(Color.BLACK); 		
		winner.setX(160);
		winner.setY(140);
		
		loser = new Text("   Oh No! \nYou missed! \n" + "    " + rainLetter.getText() + " = " + bucketLetter.getText());
		loser.setFill(Color.WHITE); 
		loser.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 75)); 
		loser.setStrokeWidth(2); 
		loser.setStroke(Color.BLACK); 		
		loser.setX(100);
		loser.setY(140);
		
		winsNumber = new Text();
		winsNumber.setFill(Color.WHITE); 
		winsNumber.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD,25)); 
		winsNumber.setStrokeWidth(1); 
		winsNumber.setStroke(Color.BLACK); 		
		winsNumber.setX(200);
		winsNumber.setY(30);
		
		leftPath(one);
		middlePath(two);
		middlePathText(rainLetter);
		rightPath(three);
		leftPathText(wrongLetterOne);
		rightPathText(wrongLetterTwo);
	}
	
	public void setScene(Stage stage)
	{
		restart = new Button("New Letter");
		restart.setFont(Font.font("Comic Sans", FontWeight.EXTRA_BOLD, 20));
		restart.setFocusTraversable(false);
		restart.setOnAction(e -> 
		{
				try
				{
					if (t.wins != 0)
					{
						wins += t.wins;
					}
					else
					{
						wins = 0;
					}
					p.getChildren().removeAll(one, two, three, rainLetter, wrongLetterOne, wrongLetterTwo, bucket, bucketLetter,t.winnerText,winner,loser,winsNumber);
					stage.setScene(scene);
					game(randomLetter());
					p.getChildren().addAll(bucket, bucketLetter, one, two, three, rainLetter, wrongLetterOne, wrongLetterTwo, winsNumber);
					
					winsNumber.setText("Number of Matches: " + wins);
					t = new Timer(p, bucket, two, rainLetter, bucketLetter, winner, loser);
					t.start();
				}
				catch(Exception ex)
				{
					p.getChildren().removeAll(one, two, three, rainLetter, wrongLetterOne, wrongLetterTwo, bucket, bucketLetter,winner,loser,t.winnerText,t.loser);
				}
		});
		p = new Pane();
		p.setMinSize(640, 480);
		p.setBackground(new Background(new BackgroundFill(Color.rgb(180, 185, 180),null,null)));
		p.setPadding(new Insets(50,0,0,0));
		
		p.getChildren().addAll(restart,winsNumber,bucket, bucketLetter);
		p.getChildren().addAll(one, two, three, rainLetter, wrongLetterOne, wrongLetterTwo);
	 	BackgroundSize backgroundSize = new BackgroundSize(600, 480, true, true, true, true);
	 	BackgroundImage backgroundImage = new BackgroundImage(bgImg, 
			                                                  BackgroundRepeat.NO_REPEAT, 
			                                                  BackgroundRepeat.REPEAT, 
			                                                  BackgroundPosition.CENTER, 
			                                                  backgroundSize);
	 	p.setBackground(new Background(backgroundImage));
		
		VBox vb = new VBox();
		vb.setBackground(new Background(new BackgroundFill(Color.rgb(80, 85, 80),null,null)));
		vb.getChildren().addAll(p); 
		vb.setSpacing(10);
		
		scene = new Scene(vb);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			public void handle(KeyEvent event)
			{
				bounds = p.getLayoutBounds();
				switch(event.getCode())
				{
				case RIGHT:
					if(inBounds(bucket))
					{
						bucket.setCenterX(bucket.getCenterX() + 5); 		
						bucketLetter.setX(bucket.getCenterX() - 30);
		      			break;
		      		}
					else
					{
						bucket.setCenterX((bounds.getMaxX() - 25) - (bucket.getRadius()));
						bucketLetter.setX(bucket.getCenterX() - 30);
						break;
					}
					
	        	case LEFT:
	        		if(inBounds(bucket))
					{
	        			bucket.setCenterX(bucket.getCenterX() - 5); 
	        			bucketLetter.setX(bucket.getCenterX() - 30);
		      			break;
		      		}
	        		else
	        		{
						bucket.setCenterX(bounds.getMinX() + bucket.getRadius());
						bucketLetter.setX(bucket.getCenterX() - 30);
						break;
	        		}
	        		
		     	default:			
			      		// No default
		     			break;
				}
			}
		});
		stage.setScene(scene);
		stage.setTitle("Match the Letters!");
		stage.setWidth(640.0);
		stage.setHeight(480.0);
		stage.show();
	}
	
	public int randomLetter()
	{
		Random rnd = new Random(System.nanoTime());
		return(rnd.nextInt(26));
	}
	
	public String randomWrongLetter(Text t)
	{
		String letter = t.toString();
		
		while((letter.equalsIgnoreCase(rainLetter.getText())));
		{
			letter = (Character.toString(bucket.upperCase[randomLetter()]).toLowerCase());
			if((letter.equalsIgnoreCase(rainLetter.getText())))
			{
				letter = (Character.toString(bucket.upperCase[randomLetter()]).toLowerCase());
			}
			if((letter.equalsIgnoreCase(rainLetter.getText())))
			{
				letter = (Character.toString(bucket.upperCase[randomLetter()]).toLowerCase());
			}
			if((letter.equalsIgnoreCase(rainLetter.getText())))
			{
				letter = (Character.toString(bucket.upperCase[randomLetter()]).toLowerCase());
			}
		}
		
		return letter;
	}
}