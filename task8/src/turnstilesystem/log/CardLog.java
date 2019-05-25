package turnstilesystem.log;

import turnstilesystem.card.*;

public class CardLog implements Cloneable {

	static String TIME_CARD = "time-card";

	static String COUNT_CARD = "count-card";

	static String ACCUMULATION_CARD = "accumulation-card";

	static String CARD = "card";

	static String PUPIL = "pupil";

	static String STUDENT = "student";

	static String DEFAULT = "adult";

	public int date;

	public int id;

	public boolean passed;

	public String cardType;

	public PersonType personType;

	public CardLog() {
	}

	public CardLog(Card card, boolean passed, int date) {
		this.date = date;
		id = card.getId();
		this.passed = passed;
		if (card instanceof TimeCard) {
			cardType = TIME_CARD;
		} else if (card instanceof CountCard) {
			cardType = COUNT_CARD;
		} else if (card instanceof AccumulationCard) {
			cardType = ACCUMULATION_CARD;
		} else {
			cardType = CARD;
		}
		personType = card.getPersonType();
	}

	@Override
	public String toString() {
		String repr = "[date=";
		repr += Integer.toString(date) + ", id=";
		repr += Integer.toString(id) + ", passed=";
		repr += Boolean.toString(passed) + ", card-type=";
		repr += cardType + ", person-type=";
		switch(personType) {
			case PUPIL:
				repr += PUPIL;
				break;
			case STUDENT:
				repr += STUDENT;
				break;
			default:
				repr += DEFAULT;
				break;
		}
		repr += "]";
		return repr;
	}

	@Override
	public CardLog clone() {
		CardLog log = new CardLog();
		log.date = date;
		log.id = id;
		log.passed = passed;
		log.cardType = cardType;
		log.personType = personType;
		return log;
	}

}
