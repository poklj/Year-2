package LandAndAir;

import LandAndAir.Steer.Steering_wheel;
import LandAndAir.Steer.Wing;

public class AirVehicle implements IVehicle, IAirVehicle {
	
	private double height;
	private double Propeller_Speed;
	
	private Wing wing;
	
	
	private double MAX_SPEED = 100.0;
	private double MIN_SPEED = 0.0;
	private double LEVEL_FLIGHT = 50.0;
	private double PositionX;
	private double PositionY;
	private double PositionZ;
	private double speed;
	private double direction;
	private static double MAX_DIRECTION = 360.0;
	private static double MIN_DIRECTION = 0.0;
	
	private double VelocityX;
	private double VelocityY;
	private double VelocityZ;
	
	private double Bounds;
	
	private Steering_wheel SteeringWheelPosition;
	
	private String VehicleName;
	
	public AirVehicle(String VehicleName, double Bounds) {
		this.setVehicleName(VehicleName);
		this.setSpeed(1);
		this.setBounds(Bounds);
	}
	
	public AirVehicle(String VehicleName, double Bounds, double prop, Steering_wheel wheel, Wing wing, double Direction) {
		this.setVehicleName(VehicleName);
		this.setBounds(Bounds);
		this.setPropeller_Speed(prop);
		this.setSteeringWheelPosition(wheel);
		this.setDirection(Direction);
		this.setWing(wing);
		this.setSpeed(1);// This plane is out of control, the Wings don't work Aaaaa
		//I Noticed the Pull steering wheel... Just imagine this works oooooOOooo
	}
	
	@Override
	public void Move() {
		this.setVelocityZ((this.Propeller_Speed - this.LEVEL_FLIGHT)/this.getSpeed());
		this.setVelocityX(Math.cos(this.getDirection()) * this.getSpeed());
		this.setVelocityY(Math.sin(this.getDirection()) * this.getSpeed());
		
		this.setPositionX(this.getPositionX() + this.getVelocityX());
		this.setPositionY(this.getPositionY() + this.getVelocityY());
		this.setPositionZ(this.getPositionZ() + this.getVelocityZ());
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
	
	
	public void Turn() {
		switch(SteeringWheelPosition) {
		case LEFT:	this.setDirection(this.direction - 25);
					break;
		case RIGHT: this.setDirection(this.direction  + 25);
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
	
	public Steering_wheel getSteeringWheelPosition() {
		return SteeringWheelPosition;
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
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getPropeller_Speed() {
		return Propeller_Speed;
	}

	public void setPropeller_Speed(double propeller_Speed) {
		double modul = 1;
		
//		switch (wing){
//		case UP: modul = 1;
//				break;
//		case DOWN: modul = -1;
//				break;
//		case STRAIGHT: break;
//		}
		if (propeller_Speed >= this.MIN_SPEED && propeller_Speed <= this.MAX_SPEED) {
			this.Propeller_Speed = propeller_Speed + modul;
		} else if (propeller_Speed < this.MIN_SPEED){
			this.Propeller_Speed = this.MIN_SPEED;
		} else if (propeller_Speed > this.MAX_SPEED) {
			this.Propeller_Speed = this.MAX_SPEED;
		}
	}

	public Wing getWing() {
		return wing;
	}

	public void setWing(Wing wing) {
		this.wing = wing;
	}
	
}
