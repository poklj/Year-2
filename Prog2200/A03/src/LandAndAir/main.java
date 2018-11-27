package LandAndAir;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

import LandAndAir.LandVehicle;
import LandAndAir.Steer.Steering_wheel;
import LandAndAir.Steer;

import java.util.Random;
public class main {

	public static void main(String[] args) {
		double Bounds = 87;
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		//LandVehicle Car1 = new LandVehicle("Car1", Bounds);
		//AirVehicle Plane1 = new AirVehicle("Plane1", Bounds);
		/*
		Car1.setGasPedal_percent(80);
		Plane1.setPropeller_Speed(60);
		Plane1.setSteeringWheelPosition(Steering_wheel.CENTER);
		Car1.setSteeringWheelPosition(Steering_wheel.LEFT);
		*/
		Random r = new Random();
		for (int i=0; i != 3; i++) {
			vehicles.add(new LandVehicle("Car"+(i+1), Bounds, (double) r.nextInt(100),(double) r.nextInt(100), Steer.random(), (double) r.nextInt(360)));
			vehicles.add(new AirVehicle("Plane"+(i+1), Bounds, (double) r.nextInt(100), Steer.random(),Steer.random1(), (double) r.nextInt(360)));
		}
		
	while (true){
		for (Vehicle p : vehicles) {
			p.Update();
			System.out.println(p.Location());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		}
	}

}
