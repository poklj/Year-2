/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author Zach-Win
 */
public class SAM extends Vehicle{
    public SAM(String vehicleName, float x, float y, double direction){
        this.setSpeed(2);
        this.setType("SAM");
        this.setDirection(direction);
        this.setVehicleName(vehicleName);
        this.setSteeringWheelPosition(Steer.Steering_wheel.CENTER);
    }
    
    public void Move(){
        this.setVelocityZ(this.getSpeed());
        this.setVelocityX(Math.cos(this.getDirection()) * this.getSpeed()/2);
        this.setVelocityY(Math.sin(this.getDirection()) * this.getSpeed()/2);

        
        this.setPositionX(this.getPositionX() + this.getVelocityX());
        this.setPositionY(this.getPositionY() + this.getVelocityY());
        this.setPositionZ(this.getPositionZ() + this.getVelocityZ());
    }
}
