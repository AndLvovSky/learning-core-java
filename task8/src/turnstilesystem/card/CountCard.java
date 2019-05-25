package turnstilesystem.card;

public class CountCard extends Card {

	public static enum Size {

		SMALL,
		BIG

	}

	private int rides;

	public int getRides() {
		return rides;
	}

	public void useRide() {
		rides--;
	}

	CountCard(int rides, int id, PersonType personType) {
		super(id, personType);
		this.rides = rides;
	}

}
