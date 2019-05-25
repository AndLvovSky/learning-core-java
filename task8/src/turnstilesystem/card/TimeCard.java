package turnstilesystem.card;

public class TimeCard extends Card {

	public static enum Duration {

		SHORT,
		LONG

	} 

	private int endDate;

	public int getEndDate() {
		return endDate;
	}

	TimeCard(int endDate, int id, PersonType personType) {
		super(id, personType);
		this.endDate = endDate;
	}

}
