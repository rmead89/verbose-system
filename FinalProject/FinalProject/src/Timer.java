//Raymond Mead
//COP 2800
//Final Project

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Timer extends AnimationTimer
{
	int counter;
	Bucket bucket;
	RainDrop drop;
	Pane p;
	Text winnerText;
	Text rainLetter;
	Text bucketLetter;
	Text loser;
	int wins;
	
	public Timer(Pane _p, Bucket _bucket, RainDrop _drop, Text _rainLetter, Text _bucketLetter, Text _winnerText, Text _loser)
	{
		p = _p;
		bucket = _bucket;
		drop = _drop;
		drop = _drop;
		rainLetter = _rainLetter;
		bucketLetter = _bucketLetter;
		winnerText = _winnerText;
		loser = _loser;
	}
	
	public void handle(long now)
	{
		counter++;
		if(bucket.collide(bucket,drop))
		{ 
			if(match(rainLetter, bucketLetter))
			{
				p.getChildren().add(winnerText);
				wins++;
				stop();
			}
		}
		
		else if(counter >= 1200)
		{
			p.getChildren().add(loser);
			wins = 0;
			stop();
		}
	}
	
	public boolean match(Text rainLetter, Text bucketLetter)
	{
		return(rainLetter.getText().contains(bucketLetter.getText().toLowerCase()));
	}
}
