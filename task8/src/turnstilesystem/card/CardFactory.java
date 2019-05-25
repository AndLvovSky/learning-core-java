package turnstilesystem.card;

import turnstilesystem.SystemTime;

public class CardFactory {

	private static int nextId = 0;

	public static TimeCard newTimeCard(
		TimeCard.Duration duration, PersonType personType) {
		int endDate;
		if (duration == TimeCard.Duration.LONG) {
			endDate = SystemTime.getTime() + 30;
		} else {
			endDate = SystemTime.getTime() + 10;
		}
		return new TimeCard(endDate, nextId++, personType);
	}

	public static CountCard newCountCard(
		CountCard.Size size, PersonType personType) {
		int rides;
		if (size == CountCard.Size.SMALL) {
			rides = 5;
		} else {
			rides = 10;
		}
		return new CountCard(rides, nextId++, personType);
	}

	public static AccumulationCard newAccumulationCard(int balance) {
		return new AccumulationCard(balance, nextId++, PersonType.DEFAULT);
	}

}
