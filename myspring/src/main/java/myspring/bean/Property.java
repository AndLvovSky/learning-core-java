package myspring.bean;

public class Property {

	public final String name;

	public final String value;

	public final boolean isRef;

	public Property(String name, String value, boolean isRef) {
		this.name = name;
		this.value = value;
		this.isRef = isRef;
	}

	public String toString() {
		String res = "property[name=" + name + ", ";
		if (isRef) res += "ref=";
		else res += "value=";
		res += value + "]";
		return res;
	}

}