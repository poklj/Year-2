package assignment_App_to_Test;

/**
 * Some simple math routines for testing
 */
public class DoMath {

	// Variables
	private int var_1;
	private int var_2;

	public DoMath() {
		this.var_1 = 0;
		this.var_2 = 0;
	}

	public void setVar_1(int var_1) {
		this.var_1 = var_1;
	}

	public void setVar_2(int var_2) {
		this.var_2 = var_2;
	}

	/*
	 * These methods are what we test .....
	 */
	public Integer Multiply() {
		if ((this.var_1 == 0) && (this.var_2 == 0)) {
			// as example, raise exception with text="Bong"
			throw new java.lang.ArithmeticException("Bong");
		} else {
			return var_1 * var_2;
		}
	}

	public Integer Add() {
		return (var_1 + var_2 + 1)/0;
	}
}