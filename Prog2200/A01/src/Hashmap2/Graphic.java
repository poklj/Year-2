package Hashmap2;

import java.util.Random;

import Hashmap2.RandomGraphic.color;
import Hashmap2.RandomGraphic.shape;

public class Graphic {

	enum shape {
		SQUARE, TRIANGLE, CIRCLE
	}
	enum color{
		RED, GREEN, BLUE
	}
	shape Shape;
	int Size;
	color Color;
	int PositionX;
	int PositionY;
	
	public static shape getRandomShape() {
		Random random = new Random();
		return shape.values()[random.nextInt(shape.values().length)];
	}
	public static color getRandomColor() {
		Random random = new Random();
		return color.values()[random.nextInt(color.values().length)];
	}
	
	public Graphic(shape Shape, int Size,  color Color, int PositionX, int PositionY) {
		this.Shape = Shape;
		this.Size = Size;
		this.Color = Color;
		this.PositionX = PositionX;
		this.PositionY = PositionY;
	}
	
	@Override
	public String toString() {
		return "Graphic [Shape=" + Shape + ", Size=" + Size + ", Color=" + Color + ", PositionX=" + PositionX
				+ ", PositionY=" + PositionY + "]";
	}
}
