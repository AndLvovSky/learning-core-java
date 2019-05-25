package turnstilesystem.system;

import turnstilesystem.card.*;
import turnstilesystem.log.Logger;

public class Turnstile {

	private boolean passTimeCard(TimeCard card) {
		int now = SystemInfo.time();
		boolean passed = now <= card.getEndDate();
		Logger.get().log(card, passed, now);
		return passed;
	}

	private boolean passCountCard(CountCard card) {
		boolean passed = false;
		if (card.getRides() > 0) {
			card.useRide();
			passed = true;
		} 
		Logger.get().log(card, passed, SystemInfo.time());
		return passed;
	}

	private boolean passAccumulationCard(AccumulationCard card) {
		int ridePrice = SystemInfo.ridePrice(card.getPersonType());
		boolean passed = false;
		if (card.getBalance() >= ridePrice) {
			card.withdraw(ridePrice);
			passed = true;
		}
		Logger.get().log(card, passed, SystemInfo.time());
		return passed;
	}

	public boolean pass(Card card) {
		if (card instanceof TimeCard) {
			return passTimeCard((TimeCard)card);
		} else if (card instanceof CountCard) {
			return passCountCard((CountCard)card);
		} else if (card instanceof AccumulationCard) {
			return passAccumulationCard((AccumulationCard)card);
		}
		Logger.get().log(card, false, SystemInfo.time());
		return false;
	}

}
