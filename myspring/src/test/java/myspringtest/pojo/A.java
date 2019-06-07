package myspringtest.pojo;

public class A {

	private static int counter = 0;

	private int id;

	public A() {
		id = counter++;
	}

	public String toString() {
		return "{A " + id + "}"; 
	}

}