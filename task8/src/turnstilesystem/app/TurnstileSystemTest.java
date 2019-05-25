package turnstilesystem.app;

import turnstilesystem.card.*;
import turnstilesystem.log.*;
import turnstilesystem.system.Turnstile;
import java.util.ArrayList;

public class TurnstileSystemTest {

	private static void print(ArrayList<CardLog> cardLogs) {
		for (int i = 0; i < cardLogs.size(); i++) {
			System.out.println(cardLogs.get(i));
		}
	}

	public static void main(String[] args) {
		Turnstile turnstile = new Turnstile();
		Card[] cards = new Card[]{
			CardFactory.newTimeCard(
				TimeCard.Duration.LONG, PersonType.STUDENT),
			CardFactory.newCountCard(
				CountCard.Size.SMALL, PersonType.DEFAULT),
			CardFactory.newCountCard(
				CountCard.Size.BIG, PersonType.PUPIL),
			CardFactory.newAccumulationCard(35)
		};
		System.out.println("passed:");
		for (int i = 0; i < 6; i++) {
			System.out.println("-----");
			for (Card card : cards) {
				System.out.println(turnstile.pass(card));
			}
		}
		System.out.println();
		ArrayList<CardLog> cardLogs = Logger.get().getAllLogs();
		System.out.println("all logs:");
		print(cardLogs);
		cardLogs = Logger.get().getCountCardLogs();
		System.out.println("count card logs:");
		print(cardLogs);
		cardLogs = Logger.get().getLogsByPersonType(PersonType.STUDENT);
		System.out.println("student card logs:");
		print(cardLogs);
	}

}