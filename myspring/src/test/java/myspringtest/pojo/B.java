package myspringtest.pojo;

public class B {

	private A a1;

	private A a2;

	private String s = "Not string";

	public B(String s) {
		this.s = s;
	}

	public B(A a1) {
		this.a1 = a1;
	}

	public void setS(String s) {
		this.s = s;
	}

	public void setA1(A a1) {
		this.a1 = a1;
	}

	public void setA2(A a2) {
		this.a2 = a2;
	}

	public String toString() {
		return "{B s=" + s + ", a1=" + 
			(a1 == null ? "null" : a1.toString()) + ", a2=" +
			(a2 == null ? "null" : a2.toString()) + "}";
	}

}