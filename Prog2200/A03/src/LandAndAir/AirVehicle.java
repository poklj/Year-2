package LandAndAir;

import LandAndAir.Steer.Steering_wheel;
import LandAndAir.Steer.Wing;

public class AirVehicle extends Vehicle {
	
	private double height;
	private double Propeller_Speed;
	
	private Wing wing;
	
	
	private double MAX_SPEED = 100.0;
	private double MIN_SPEED = 0.0;
	private double LEVEL_FLIGHT = 50.0;
	
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
		this.setWing(wing); // This plane is out of control, the Wings don't work Aaaaa
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
		double modul = 0;
		
		switch (wing){
		case UP: modul = 1;
				break;
		case DOWN: modul = -1;
				break;
		case STRAIGHT: break;
		}
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
