package io_samples;


import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Russell Shanahan
 */
public class SerClass implements Serializable {
	/**
	 * Make Serializable to allow it to be saved to disk.
	 */
	private static final long serialVersionUID = 2384446230138363715L;
	
	// Vars
	int x;
	int y;
	String myString;

	// Getters and Setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public String getMyString() {
		return myString;
	}
	public void setMyString(String myString) {
		this.myString = myString;
	}
}
