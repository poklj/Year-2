package com.example.russ.m08_net_01.common;

import java.awt.Color;

public enum NetColor  {
	
	BLUE(22,33,44),
	RED(55,44,11),
	GREEN(66,88,99),
	WHITE(255,255,255),
	BLACK(0,0,0);
	
	private final int c_red;
	private final int c_green;
	private final int c_blue;
	
	NetColor(){
		this.c_red = 250;
		this.c_green = 200;
		this.c_blue = 33;
	}

	NetColor(int r, int g, int b){
		this.c_red = r;
		this.c_green = g;
		this.c_blue = b;
	}
	
	/**
	 * AWT version
	 * @return
	 */
	public Color getColor(){
		return new Color(c_red, c_blue, c_green);
	}
	
	
}
