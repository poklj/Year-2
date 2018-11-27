package LandAndAir;

import java.util.*;

public class Steer {
	
	public enum Steering_wheel {
		LEFT, CENTER, RIGHT
	}
	public enum Wing{
		UP, DOWN, STRAIGHT
	}
	
	public static Steering_wheel random(){
		return Steering_wheel.values()
				[new Random().nextInt(Steering_wheel.values().length)];	
	}
	
	public static Wing random1(){
		return Wing.values()
				[new Random().nextInt(Steering_wheel.values().length)];	
	}
}