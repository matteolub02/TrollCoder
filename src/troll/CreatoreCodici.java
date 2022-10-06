package troll;

import java.util.ArrayList;
import java.util.Random;

public class CreatoreCodici {
	public static ArrayList<StringBuilder> creaCodici () {
		ArrayList<StringBuilder> codici = new ArrayList<>();
		Random rand = new Random();
		
		for (int i = 0; i < 10000000; i++) {
			StringBuilder s = new StringBuilder();
			int lunghezza = rand.nextInt(1, 102);
			for (int j = 0; j < lunghezza; j++) {
				s.append(rand.nextInt(2));
			}
			codici.add(s);
		}
		
		return codici;
	}
	
}
