package myspring.bean;

import java.util.ArrayList;
import java.util.List;

public class Bean {

	public final String id;

	public final String cls;

	public String ctrArg;

	public List<Property> properties = new ArrayList<>();

	public Bean(String id, String cls) {
		this.id = id;
		this.cls = cls;
	}

	public void addProperty(Property property) {
		properties.add(property);
	}

}