package turnstilesystem.card;

public class AccumulationCard extends Card {

	private int balance;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int amount) {
		balance -= amount;
	}

	AccumulationCard(int balance, int id, PersonType personType) {
		super(id, personType);
		this.balance = balance;
	}

}
