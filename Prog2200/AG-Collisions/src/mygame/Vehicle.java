package mygame;

import mygame.Steer.Steering_wheel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vehicle {

	private double PositionX = 100;
	private double PositionY = 100;
	private double PositionZ = 0;
	private double speed;
	private double direction;
	private static final double MAX_DIRECTION = 360.0;
	private static final double MIN_DIRECTION = 0.0;
	
	private double VelocityX;
	private double VelocityY;
	private double VelocityZ;
	
        private double prevPositionX;
        private double prevPositionY;
        private double prevPositionZ;
	private double Bounds;
        
        private final int boundingBox = 2; //Size of the bounding box, is a perfect cube
        private final List<Integer> BoundingList = (List<Integer>) Arrays.asList(1+(1-this.boundingBox), -1+(1-this.boundingBox));
        private boolean Crashed = false;
	private boolean Represented = false;
        private String type;
        
	private Steering_wheel SteeringWheelPosition;
	
	private String VehicleName;

	public Vehicle() {
		this.speed = 1.3;
	}
	
	public void Update() {
		this.Turn();
		this.Move();
		this.Rebound();
		
	}
	
	public void Rebound() {
		if(this.PositionX < 0) {
			this.direction = this.direction-180;
		} else if (this.PositionX > this.Bounds) {
			this.direction = this.direction+180;
		}
		
		if(this.PositionY < 0) {
			this.direction = this.direction+180;
		} else if (this.PositionY > this.Bounds) {
			this.direction = this.direction-180;
		}
	}
	
	public void Move() {
		this.VelocityX = (Math.cos(this.direction) * this.speed);
		this.VelocityY = (Math.sin(this.direction) * this.speed);
		this.setPositionZ(this.PositionZ + this.VelocityZ);
		this.setPositionX(this.PositionX + this.VelocityX);
		this.setPositionY(this.PositionY + this.VelocityY);
		
	}
	
        public boolean checkCollide(Vehicle target){
            if(target == this){
                return false;
            }
            boolean intersect = IntersectThis(target.getPositionX(), target.getPositionY(), target.getPositionZ(), target.getBoundingBox());
            
            if (intersect) {
            	System.out.println(intersect);
                if("Air".equals(type)) {
                	this.Crashed = true;
                }
                if("Land".equals(type)) {
                	this.Rebound();
                }
                
            }
            
            return intersect;
        }
        
        public boolean IntersectThis(double x, double y, double z, int Bounding){
            return (this.getPositionX() - this.getBoundingBox() <= x + Bounding && this.getPositionX() + this.getBoundingBox()  >= x - Bounding) &&
                   (this.getPositionY() - this.getBoundingBox() <= y + Bounding && this.getPositionY() + this.getBoundingBox() >= y - Bounding)&&
                   (this.getPositionZ() - this.getBoundingBox() <= z + Bounding && this.getPositionZ() + this.getBoundingBox() >= z - Bounding);
        }
        
	public void Turn() {
		switch(SteeringWheelPosition) {
		case LEFT:	this.setDirection(this.direction - 50);
					break;
		case RIGHT: this.setDirection(this.direction  + 50);
					break;
					
		case CENTER: break;
		default: break;
		}
	}
	
	public String Location() {
		String returnable = "";
		
		returnable += "Name:"+ this.VehicleName +" ";
		returnable += "<" +this.getPositionX() +"," + this.getPositionY() + "," + this.getPositionZ() +">";
		return returnable;
		
	}
        public boolean getRepresented(){
            return Represented;
        }
        public void setRepresented(boolean i){
            this.Represented = i;
        }
        public void setCrashed(boolean b){
            this.Crashed = b;
        }
        public boolean getCrashed(){
            return this.Crashed;
        }
	public double getPositionX() {
		return PositionX;
	}

	public double getPositionY() {
		return PositionY;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDirection() {

		return direction;
	}

	public double getPositionZ() {
		return PositionZ;
	}

	public String getVehicleName() {
		return VehicleName;
	}
	public int getBoundingBox(){
            return boundingBox;
        }
	public Steering_wheel getSteeringWheelPosition() {
		return SteeringWheelPosition;
	}
        public String getType(){
            return this.type;
        }
        public void setType(String type){
            this.type = type;
        }
	
	public void setPositionX(double positionX) {
		PositionX = positionX;
	}

	public void setPositionY(double positionY) {
		PositionY = positionY;
	}
	
	public void setPositionZ(double positionZ) {
		PositionZ = positionZ;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void setDirection(double direction) { // Make this a wrapping function
		// Max f360.0 | min f0.0
		if (direction <= MAX_DIRECTION && direction >= MIN_DIRECTION) {
			this.direction = direction;
		} else if (direction > MAX_DIRECTION) { 
			//this.direction = MIN_DIRECTION + (MAX_DIRECTION - direction);
			this.direction %= MIN_DIRECTION ;
			if (Double.isNaN(this.direction)) {
				this.direction = MIN_DIRECTION;
			}
		} else if (direction < MIN_DIRECTION) {
			//this.direction = MAX_DIRECTION - (MIN_DIRECTION + direction);
			this.direction %= MAX_DIRECTION;
			if (Double.isNaN(this.direction)) {
				this.direction = MAX_DIRECTION;
			}
		} //else if (direction)
		
	}

	

	public void setVehicleName(String vehicleName) {
		VehicleName = vehicleName;
	}

	

	public void setSteeringWheelPosition(Steering_wheel steeringWheelPosition) {
		SteeringWheelPosition = steeringWheelPosition;
	}

	public double getVelocityX() {
		return VelocityX;
	}

	public void setVelocityX(double velocityX) {
		VelocityX = velocityX;
	}

	public double getVelocityY() {
		return VelocityY;
	}

	public void setVelocityY(double velocityY) {
		VelocityY = velocityY;
	}

	public double getVelocityZ() {
		return VelocityZ;
	}

	public void setVelocityZ(double velocityZ) {
		VelocityZ = velocityZ;
	}

	public double getBounds() {
		return Bounds;
	}

	public void setBounds(double bounds) {
		Bounds = bounds;
	}
	
}
