package LandAndAir;

import LandAndAir.Steer.Wing;

public interface IAirVehicle {
	public double getHeight() ;

	public void setHeight(double height);

	public double getPropeller_Speed();

	public void setPropeller_Speed(double propeller_Speed);

	public Wing getWing();
	public void setWing(Wing wing);
}
