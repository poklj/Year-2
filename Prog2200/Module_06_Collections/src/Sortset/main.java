package Sortset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.SortedSet;

public class main {

	public static void main(String[] args) {
		/**
		 * Create a Sorted Set of Names using Treeset in SortedSet
		 */
		
		String[] nameArray = {"Jon","Mary","Sue",
							  "Jack","Welp","Crag",
							  "Paul", "Henry","Paul",
							  "Dek"};
		
		//
		SortedSet<String> sortedName = new TreeSet<String>(Arrays.asList(nameArray));
		/*
		for (int i = 0; i != nameArray.length; i++) {
			sortedName.add(nameArray[i]);
		}
		*/
		System.out.println(sortedName);
		

	}

}
