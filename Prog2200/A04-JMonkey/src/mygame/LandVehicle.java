package mygame;

import mygame.Steer.Steering_wheel;

public class LandVehicle extends Vehicle {

	private double GasPedal_percent;
	private double BreakPedal_percent;
	private static double MAX_PERCENT = 100.0;
	private static double MIN_PERCENT = 0.0;
	protected static String type = "Land";

	public LandVehicle(String VehicleName, double Bounds) {
		this.setVehicleName(VehicleName);
		this.setBounds(Bounds);
	}
	
	public LandVehicle(String VehicleName, String type, double Bounds, 
			double GasPedal, double BreakPedal, Steering_wheel wheel, double Direction) {
		this.setVehicleName(VehicleName);
		this.setBounds(Bounds);
                this.setType(type);
		this.setGasPedal_percent(GasPedal);
		this.setBreakPedal_percent(BreakPedal);
		this.setSteeringWheelPosition(wheel);
		this.setDirection(Direction);
	}
	public LandVehicle(int x, int y, int z) {
		this.setPositionX(x);
		this.setPositionY(y);
		this.setPositionZ(z);
	}

	@Override
	public void Move() {
		this.setSpeed((double) (this.getGasPedal_percent() - this.getBreakPedal_percent()/85));
		this.setVelocityX(Math.cos(this.getDirection()) * this.getSpeed());
		this.setVelocityY(Math.sin(this.getDirection()) * this.getSpeed());
		
		this.setPositionX(this.getPositionX() + this.getVelocityX());
		this.setPositionY(this.getPositionY() + this.getVelocityY());
	}
	
	public double getGasPedal_percent() {
		return GasPedal_percent;
	}

	public double getBreakPedal_percent() {
		return BreakPedal_percent;
	}
        

	public void setGasPedal_percent(double gasPedal_percent) {
		if (gasPedal_percent <= MAX_PERCENT && gasPedal_percent >= MIN_PERCENT) {
			GasPedal_percent = gasPedal_percent;
		} else if (gasPedal_percent > MAX_PERCENT) {
			GasPedal_percent %= MAX_PERCENT;
		} else if (gasPedal_percent < MIN_PERCENT) {
			GasPedal_percent %= MIN_PERCENT;
		}
	}

	public void setBreakPedal_percent(double breakPedal_percent) {
		if (breakPedal_percent <= MAX_PERCENT && breakPedal_percent >= MIN_PERCENT) {
			BreakPedal_percent = breakPedal_percent;
		} else if (breakPedal_percent > MAX_PERCENT) {
			BreakPedal_percent %= MAX_PERCENT;
		} else if (breakPedal_percent < MIN_PERCENT) {
			BreakPedal_percent %= MIN_PERCENT;
		}
	}

}
