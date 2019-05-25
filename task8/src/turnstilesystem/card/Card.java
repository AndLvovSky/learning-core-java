package turnstilesystem.card;

public abstract class Card {

	protected int id;

	protected PersonType personType;

	public int getId() {
		return id;
	} 

	public PersonType getPersonType() {
		return personType;
	}

	Card(int id, PersonType personType) {
		this.id = id;
		this.personType = personType;
	}

}
