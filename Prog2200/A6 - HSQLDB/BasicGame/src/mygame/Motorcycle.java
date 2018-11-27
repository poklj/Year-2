/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 * Motorcycle Subclass
 * @author Zach-Win
 */
public class Motorcycle extends Vehicle{
    
    private int dropSpeed = 25;
    /**
     *  Motorcycle Constructor
     * @param VehicleName Name of the Vehicle
     * @param wheel The Position of the Wheel
     * @param Speed How Fast The Object should be
     * @param bounds The Area the object should be constrained to
     * @param Direction The Initial direction the object should move in
     */
    public Motorcycle(String VehicleName, Steer.Steering_wheel wheel, int Speed, double bounds, double Direction){
        this.setVehicleName(VehicleName);
        this.setBounds(bounds);
        this.setType("Motorcycle");
        this.setSteeringWheelPosition(wheel);
        this.setDirection(Direction);
        
        //I understand that this is Wrong, I should not directly set the Speed
        this.setSpeed(Speed/3);
    }
    /**
     * Override Move from Superclass
     */
    public void Move(){
        
        this.setVelocityX(Math.cos(this.getDirection()) * this.getSpeed());
        this.setVelocityY(Math.sin(this.getDirection()) * this.getSpeed());
        
        if(this.getCrashed()){
            System.out.println(this.getVehicleName() + " Crashed");
            this.setVelocityX(0);
            this.setVelocityY(0);
            return;
        }
        this.setPositionX(this.getPositionX() + this.getVelocityX());
        this.setPositionY(this.getPositionY() + this.getVelocityY());
        
        
    }
    
    
}
