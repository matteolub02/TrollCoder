package troll;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.jupiter.api.Test;

class TrollCoderTest {
	
	public ArrayList<StringBuilder> codici = CreatoreCodici.creaCodici(); //Codici da controllare
	
	@Test
	void test() {
		boolean giusto = true;
		for (int i = 0; i < codici.size(); i++) {
			ArrayList<Integer> sequenza = creaSequenza(codici.get(i).toString().length(), 0);
			int cifreCorrette = cifreCorrette(sequenza, codici.get(i).toString());
			if (cifreCorrette < codici.get(i).toString().length()/2) sequenza = creaSequenza(codici.get(i).toString().length(), 1);
			for (int j = 0; j < codici.get(i).toString().length(); j++) {
				if (sequenza.get(j) == 0) sequenza.set(j, 1);
		        else if (sequenza.get(j) == 1) sequenza.set(j, 0);
				int tmp = cifreCorrette(sequenza, codici.get(i).toString());
				if (tmp != codici.get(i).toString().length()) {
					if (tmp > cifreCorrette) cifreCorrette = tmp;
					else {
						if (sequenza.get(j) == 0) sequenza.set(j, 1);
				        else if (sequenza.get(j) == 1) sequenza.set(j, 0);
					}
				}
				else {
					System.out.println("A " + sequenza.toString());
					if (!checkCodice(sequenza, codici.get(i).toString())) giusto = false;
				}
			}
		}
		
		assertTrue(giusto);
	}
	
	
	public static ArrayList<Integer> creaSequenza (int lunghezza, int val) {
		ArrayList<Integer> seq = new ArrayList<Integer>();
	    for (int i = 0; i < lunghezza; i++) seq.add(val);
	    return seq;
	}
	
	public static int cifreCorrette (ArrayList<Integer> seq, String codice) {
		int cifre = 0;
		for (int i = 0; i < codice.length(); i++) {
			if (seq.get(i) == Character.getNumericValue(codice.charAt(i))) cifre++;
		}
		return cifre;
	}
	
	public static boolean checkCodice (ArrayList<Integer> seq, String codice) {
		for (int i = 0; i < codice.length(); i++) {
			if (seq.get(i) != Character.getNumericValue(codice.charAt(i))) return false;
		}
		return true;
	}

}
