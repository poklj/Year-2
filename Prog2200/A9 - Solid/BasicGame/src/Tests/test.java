package Tests;

import static org.junit.jupiter.api.Assertions.*;

import mygame.*;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class test {
	Vehicle Air1;
	Vehicle Air2;
	
	Vehicle Ground1;
	Vehicle Ground2;
	@BeforeEach
	void setUp() throws Exception {
		Air1 = new AirVehicle(0,0,0);
		Air2 = new AirVehicle(0,0,0);
		
		Ground1 = new LandVehicle(0,0,0);
		Ground2 = new LandVehicle(0,0,0);
	}

	@AfterEach
	void tearDown() throws Exception {
		Air1 = new AirVehicle(0,0,0);
		Air2 = new AirVehicle(0,0,0); 
		
		Ground1 = new LandVehicle(0,0,0);
		Ground2 = new LandVehicle(0,0,0);
	}

	@Test
	void Test_GroundGroundX() {
		Ground2.setPositionX(1);
		assertEquals(true, Ground2.checkCollide(Ground1));
		
		Ground2.setPositionX(-1);
		assertEquals(true, Ground2.checkCollide(Ground1));
		
		Ground2.setPositionX(5);
		assertEquals(false, Ground2.checkCollide(Ground1));
	}
	@Test
	void Test_GroundGroundY() {
		Ground2.setPositionY(1);
		assertEquals(true, Ground2.checkCollide(Ground1));
		Ground2.setPositionY(-1);
		assertEquals(true, Ground2.checkCollide(Ground1));
		
		Ground2.setPositionY(5);
		assertEquals(false, Ground2.checkCollide(Ground1));
		Ground2.setPositionY(-5);
		assertEquals(false, Ground2.checkCollide(Ground1));
	}
	@Test
	void Test_GroundGroundZ() {
		Ground2.setPositionZ(1);
		assertEquals(true, Ground2.checkCollide(Ground1));
		
		Ground2.setPositionZ(-1);
		assertEquals(true, Ground2.checkCollide(Ground1));
		
		Ground2.setPositionZ(5);
		assertEquals(false, Ground2.checkCollide(Ground1));
		Ground2.setPositionZ(-5);
		assertEquals(false, Ground2.checkCollide(Ground1));
	}
	@Test
	void Test_NotSelf() {
		assertEquals(false, Ground1.checkCollide(Ground1));
		assertEquals(false, Ground2.checkCollide(Ground2));
		
		assertEquals(false, Air1.checkCollide(Air1));
		assertEquals(false, Air2.checkCollide(Air2));
	}
	
	@Test
	void Test_AirAirX() {
		Air2.setPositionX(1);
		assertEquals(true, Air2.checkCollide(Air1));
		Air2.setPositionX(-1);
		assertEquals(true, Air2.checkCollide(Air1));
		
		Air2.setPositionX(5);
		assertEquals(false, Air2.checkCollide(Air1));
		Air2.setPositionX(-5);
		assertEquals(false, Air2.checkCollide(Air1));
	}
	
	@Test
	void Test_AirAirY() {
		Air2.setPositionY(1);
		assertEquals(true, Air2.checkCollide(Air1));
		Air2.setPositionY(-1);
		assertEquals(true, Air2.checkCollide(Air1));
		
		Air2.setPositionY(5);
		assertEquals(false, Air2.checkCollide(Air1));
		Air2.setPositionY(-5);
		assertEquals(false, Air2.checkCollide(Air1));
	}
	
	@Test
	void Test_AirAirZ() {
		Air2.setPositionZ(1);
		assertEquals(true, Air2.checkCollide(Air1));
		Air2.setPositionZ(-1);
		assertEquals(true, Air2.checkCollide(Air1));
		
		Air2.setPositionZ(5);
		assertEquals(false, Air2.checkCollide(Air1));
		Air2.setPositionZ(-5);
		assertEquals(false, Air2.checkCollide(Air1));
	}
	
	
	@Test
	void Test_AirGroundX() {
		Air2.setPositionX(1);
		assertEquals(true, Air2.checkCollide(Ground1));
		Air2.setPositionX(-1);
		assertEquals(true, Air2.checkCollide(Ground1));
		
		Air2.setPositionX(5);
		assertEquals(false, Air2.checkCollide(Ground1));
		Air2.setPositionX(-5);
		assertEquals(false, Air2.checkCollide(Ground1));
	}
	
	@Test
	void Test_AirGroundY() {
		Air2.setPositionY(1);
		assertEquals(true, Air2.checkCollide(Ground1));
		Air2.setPositionY(-1);
		assertEquals(true, Air2.checkCollide(Ground1));
		
		Air2.setPositionY(5);
		assertEquals(false, Air2.checkCollide(Ground1));
		Air2.setPositionY(-5);
		assertEquals(false, Air2.checkCollide(Ground1));
	}
	
	@Test
	void Test_AirGroundZ() {
		Air2.setPositionZ(1);
		assertEquals(true, Air2.checkCollide(Ground1));
		Air2.setPositionZ(-1);
		assertEquals(true, Air2.checkCollide(Ground1));
		
		Air2.setPositionZ(5);
		assertEquals(false, Air2.checkCollide(Ground1));
		Air2.setPositionZ(-5);
		assertEquals(false, Air2.checkCollide(Ground1));
	}
	
	
	
	

}
