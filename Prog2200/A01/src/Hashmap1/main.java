package Hashmap1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.SortedSet;

public class main {

	public static void main(String[] args) {
		/**
		 * HashMap: Write a Java program to store the car model, year, colour, and price of cars on a used car lot.   Print the results.
		 */
		
		List<Map<String, String>> Cars = new ArrayList<Map<String, String>>();
		
		Map<String, String> Car = new HashMap<String, String>();
		Car.put("Model", "Focus");
		Car.put("Year", "1998");
		Car.put("Color", "Blue");
		Car.put("Price", "170000");
		
		Cars.add(Car);
		
		Map<String, String> Car2 = new HashMap<String, String>();
		Car2.put("Model", "Hatchback");
		Car2.put("Year", "1995");
		Car2.put("Color", "Red");
		Car2.put("Price", "1337");
		
		Cars.add(Car2);
		
		System.out.println(Cars);
		

	}

}
