package LandAndAir;

import LandAndAir.Steer.Steering_wheel;

public interface IVehicle {
	public void Update();
	
	public void Rebound();
	
	public void Move();
	public void Turn();
	
	public String Location();

	public double getPositionX();

	public double getPositionY();

	public double getSpeed();

	public double getDirection();

	public double getPositionZ();

	public String getVehicleName();
	
	public Steering_wheel getSteeringWheelPosition();
	
	public void setPositionX(double positionX);

	public void setPositionY(double positionY);
	
	public void setPositionZ(double positionZ);

	public void setSpeed(double speed);

	public void setDirection(double direction);

	

	public void setVehicleName(String vehicleName);
	

	public void setSteeringWheelPosition(Steering_wheel steeringWheelPosition);

	public double getVelocityX();

	public void setVelocityX(double velocityX);

	public double getVelocityY();

	public void setVelocityY(double velocityY);

	public double getVelocityZ();

	public void setVelocityZ(double velocityZ);

	public double getBounds();

}
