public class PersonRunner {
	public static void main(String[] args) {
		Person person = new Person("Bob", "Jackson", "23.09.1995");
		System.out.println(
			person.getFirstName() + " " + 
			person.getLastName() + " " + 
			person.getBirthDate());
	}
}