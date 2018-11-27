package mygame;

import javax.persistence.Entity;

import mygame.Steer.Steering_wheel;
import mygame.Steer.Wing;
@Entity
public class AirVehicle extends Vehicle {

	private double height;
	private double Propeller_Speed;

	private Wing wing;

	private final double MAX_SPEED = 100.0;
	private final double MIN_SPEED = 0.0;
	private final double LEVEL_FLIGHT = 50.0;

	private boolean Crashed = false;

	protected static String type = "Air";

	// TODO: Implement Ground interaction
	@SuppressWarnings("OverridableMethodCallInConstructor")
	public AirVehicle(String VehicleName, double Bounds) {
		this.setVehicleName(VehicleName);
		this.setSpeed(1);
		this.setBounds(Bounds);
	}

	@SuppressWarnings("OverridableMethodCallInConstructor")
	public AirVehicle(String VehicleName, String type, double Bounds, double prop, Steering_wheel wheel, Wing wing,
			double Direction) {
		this.setVehicleName(VehicleName);
		this.setBounds(Bounds);
		this.setType(type);
		this.setPropeller_Speed(prop);
		this.setSteeringWheelPosition(wheel);
		this.setDirection(Direction);
		this.setSpeed(7);
		this.setPositionZ(10);
		this.setWing(wing); // This plane is out of control, the Wings don't work Aaaaa
		// I Noticed the Pull steering wheel... Just imagine this works oooooOOooo
	}

	@SuppressWarnings("OverridableMethodCallInConstructor")
	public AirVehicle(double x, double y, double z) {
		this.setPositionX(x);
		this.setPositionY(y);
		this.setPositionZ(z);
	}

	@Override
	public void Move() {
		this.setVelocityZ((this.Propeller_Speed - this.LEVEL_FLIGHT) / this.getSpeed());
		this.setVelocityX(Math.cos(this.getDirection()) * this.getSpeed());
		this.setVelocityY(Math.sin(this.getDirection()) * this.getSpeed());

		if (this.getPositionY() < 0) {
			this.Crashed = true;
			this.setVelocityZ(0);
			this.setVelocityY(0);
			this.setVelocityX(0);
                        return;

		}

		if (this.Crashed) {
			this.Propeller_Speed = 0;
		}
                   
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


	/**
	 *
	 * @return {String}
	 */
	@Override
	public String getType() {
		return this.type;
	}

	public double getPropeller_Speed() {
		return Propeller_Speed;
	}

	public void setPropeller_Speed(double propeller_Speed) {
		double modul = 0;

//		switch (wing){
//		case UP: modul = 1;
//				break;
//		case DOWN: modul = -1;
//				break;
//		case STRAIGHT: break;
//		}
		if (propeller_Speed >= this.MIN_SPEED && propeller_Speed <= this.MAX_SPEED) {
			this.Propeller_Speed = propeller_Speed + modul;
		} else if (propeller_Speed < this.MIN_SPEED) {
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
