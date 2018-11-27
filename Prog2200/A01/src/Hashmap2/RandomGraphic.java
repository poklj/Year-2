package Hashmap2;

import Hashmap2.Graphic;
import java.util.Random;
public class RandomGraphic {
	enum shape {
		SQUARE, TRIANGLE, CIRCLE;
	}
	enum color{
		RED, GREEN, BLUE;
	}
	
	
	public Graphic MakeRandom() {
		Random random = new Random();
		
		Graphic RandGraphic = new Graphic(Graphic.getRandomShape(),random.nextInt(32) ,Graphic.getRandomColor(), random.nextInt(32), random.nextInt(32));
		return RandGraphic;
	}
}
