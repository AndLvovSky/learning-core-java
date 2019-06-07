package myspring.bean;

public class ConstructorArgument {

	public final String value;

	public final boolean isRef;

	public ConstructorArgument(String value, boolean isRef) {
		this.value = value;
		this.isRef = isRef;
	}

	public String toString() {
		String res = "constructor-argument ";
		if (isRef) res += "ref=";
		else res += "value=";
		res += value;
		return res;
	}

}