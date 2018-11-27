package packageToTest;

import java.util.HashMap;
import java.util.Map;

/**
 * This class holds some coins and counts them up when requested. You can also
 * add some coins after the initial constructor is called. I think there are a
 * few errors in the class. Find them. Show the class works using JUnit.
 * 
 * @author Russ
 * 
 */
public class pocketChange2 {

	/**
	 * An enumeration of types of coins
	 * 
	 */
	enum coins {
		penny, nickle, dime, quarter, loonie, toonie, fiver // penny to $5 coin
	};

	/**
	 * The collection to hold the coins.
	 */
	Map<coins, Integer> pocket = new HashMap<coins, Integer>();

	/**
	 * Constructor which allows an amount of each coin to be deposited.
	 * 
	 * @param penny
	 * @param nickle
	 * @param dime
	 * @param quarter
	 * @param loonie
	 * @param toonie
	 */
	public pocketChange2(int penny, int nickle, int dime, int quarter,
			int loonie, int toonie, int fiver) {
		pocket.put(coins.penny, penny);
		pocket.put(coins.nickle, nickle);
		pocket.put(coins.dime, dime);
		pocket.put(coins.quarter, quarter);
		pocket.put(coins.loonie, loonie);
		pocket.put(coins.toonie, loonie);
		pocket.put(coins.fiver, loonie);
	}

	/**
	 * This method allows for some number of coins to be added to the coins
	 * already in.
	 * 
	 * @param penny
	 * @param nickle
	 * @param dime
	 * @param quarter
	 * @param loonie
	 * @param toonie
	 */
	public void addSomeChange(int penny, int nickle, int dime, int quarter,
			int loonie, int toonie, int fiver) {
		pocket.put(coins.penny, penny + pocket.get(coins.penny));
		pocket.put(coins.nickle, nickle + pocket.get(coins.nickle));
		pocket.put(coins.dime, dime + pocket.get(coins.dime));
		pocket.put(coins.quarter, quarter + pocket.get(coins.quarter));
		pocket.put(coins.loonie, loonie + pocket.get(coins.loonie));
		pocket.put(coins.toonie, loonie + pocket.get(coins.loonie));
	}

	/**
	 * This method returns the value of the coins contained herein.
	 * 
	 * @return value of the contained coins
	 */
	public double howMuch() {
		int inPennies = pocket.get(coins.penny) * 1 + pocket.get(coins.nickle)
				* 5 + pocket.get(coins.dime) * 10 + pocket.get(coins.quarter)
				* 25 + pocket.get(coins.loonie) * 100
				+ pocket.get(coins.toonie) * 200;

		// double inDollars = (double) inPennies / 100;
		double inDollars = inPennies / 100;

		return inDollars;

	}

	/**
	 * This method returns the string representation of the coins herein.
	 */
	public String toString() {
		return pocket.get(coins.penny) + " Pennies " + pocket.get(coins.dime)
				+ " nickles " + pocket.get(coins.dime) + " dimes "
				+ pocket.get(coins.quarter) + " Quarters "
				+ pocket.get(coins.loonie) + " loonies "
				+ pocket.get(coins.toonie) + " toonies "
				+ +pocket.get(coins.fiver) + " fivers ";
	}

}
