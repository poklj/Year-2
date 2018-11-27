package Hashmap2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class main {

	public static void main(String[] args) {
		RandomGraphic randGraphic = new RandomGraphic();
		
		Set<Graphic> graphicSet = new HashSet<Graphic>();
		for (int i = 0; i < 20; i++) {
			graphicSet.add(randGraphic.MakeRandom());
		}
		System.out.println(graphicSet);
	}

}
