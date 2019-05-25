package turnstilesystem.system;

import turnstilesystem.card.*;
import java.util.Random;

public class SystemInfo {

	private static int time = 0;

	public static int time() {
		time += new Random().nextInt(5);
		return time;
	}

	public static int ridePrice(PersonType personType) {
		switch (personType) {
			case PUPIL : return 2;
			case STUDENT : return 5;
			default : return 10;
		}
	}

}
