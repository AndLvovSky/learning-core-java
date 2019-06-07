package myspringtest.pojo;

public class GreetingService {

	private String msg = "Hello to everyone!";

	public GreetingService() {}

	public GreetingService(String msg) {
		this.msg = msg;
	}

	public void greet() {
		System.out.println(msg);
	}

}