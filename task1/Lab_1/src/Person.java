public class Person {
	private String firstName;
	private String lastName;
	private String birthDate;
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getBirthDate() {
		return this.birthDate;
	}
	
	public Person(String firstName, String lastName, String birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}
}
