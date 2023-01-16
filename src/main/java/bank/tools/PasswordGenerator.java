package bank.tools;

import java.util.ArrayList;
import java.util.Arrays;

public class PasswordGenerator {

	
	public String saltGen(int length) {

		String r = "";
		Character[] upper = new Character[26];
		for (int i = 0; i < 26; i++) {
			upper[i] = (char) (65 + i);
		}
		Character[] lower = new Character[26];
		for (int i = 0; i < 26; i++) {
			lower[i] = (char) (97 + i);
		}
		Character[] number = new Character[10];
		for (int i = 0; i < 10; i++) {
			number[i] = (char) (48 + i);
		}
		ArrayList<Character> all = new ArrayList<>();
		all.addAll(Arrays.asList(upper));
		all.addAll(Arrays.asList(lower));
		all.addAll(Arrays.asList(number));

		for (int i = 0; i < length; i++) {
			r += all.get((int) (Math.floor(Math.random() * 62)));
		}
		return r;
	}
	
	public String verifyGen(int length) {
		String r = "";
		for (int i = 0; i < length; i++) {
			r += (int) Math.floor(Math.random() * 10);
		}
		return r;
	}
	
}
