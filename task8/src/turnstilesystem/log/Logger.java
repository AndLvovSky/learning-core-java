package turnstilesystem.log;

import turnstilesystem.card.*;
import java.util.ArrayList;

public class Logger {

	private static interface LogValidator {

		boolean isValid(CardLog cardLog);

	}

	private static Logger instance = null;

	private ArrayList<CardLog> logs;

	private Logger() {
		logs = new ArrayList<CardLog>();
	}

	public static Logger get() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}

	private ArrayList<CardLog> filterLogs(LogValidator validator) {
		ArrayList<CardLog> filtered = new ArrayList<>();
		for (int i = 0; i < logs.size(); i++) {
			CardLog cur = logs.get(i);
			if (validator.isValid(cur)) {
				filtered.add(cur.clone());
			}
		}
		return filtered;
	}

	public void log(Card card, boolean passed, int date) {
		logs.add(new CardLog(card, passed, date));
	}

	public ArrayList<CardLog> getAllLogs() {
		return filterLogs((cardLog) -> true);
	}

	public ArrayList<CardLog> getTimeCardLoggs() {
		return filterLogs((cardLog) -> cardLog.cardType == CardLog.TIME_CARD);
	}

	public ArrayList<CardLog> getCountCardLogs() {
		return filterLogs((cardLog) -> cardLog.cardType == CardLog.COUNT_CARD);
	}

	public ArrayList<CardLog> getAccumulationCardLogs() {
		return filterLogs((cardLog) -> cardLog.cardType 
			== CardLog.ACCUMULATION_CARD);
	}

	public ArrayList<CardLog> getLogsByPersonType(PersonType personType) {
		return filterLogs((cardLog) -> cardLog.personType == personType);
	}

}