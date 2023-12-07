package GenericLibrary;

import java.util.Random;

public class JavaLibrary {
	
	public int getRandomInt() {
		Random ran = new Random();
		int number = ran.nextInt(1000);
		return number;
	}

}
