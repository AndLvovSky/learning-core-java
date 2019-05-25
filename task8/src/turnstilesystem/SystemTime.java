package turnstilesystem;

import java.util.Random;

public class SystemTime {

	private static int time = 0;

	public static int getTime() {
		time += new Random().nextInt(5);
		return time;
	}

}