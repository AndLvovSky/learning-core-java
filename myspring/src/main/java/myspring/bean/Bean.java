package myspring.bean;

import java.util.ArrayList;
import java.util.List;

public class Bean {

	public final String id;

	public final String cls;

	public ConstructorArgument ctrArg;

	public List<Property> properties = new ArrayList<>();

	public Bean(String id, String cls) {
		this.id = id;
		this.cls = cls;
	}

	public void addProperty(Property property) {
		properties.add(property);
	}

	public String toString() {
		String res = String.format("bean[id=%s, class=%s]\n", id, cls);
		if (ctrArg != null) {
			res += ctrArg.toString() + "\n";
		}
		for (Property property : properties) {
			res += property.toString() + "\n";
		}
		res += "[end bean]\n";
		return res;
	}

}