package myspring.bean;

import java.util.ArrayList;
import java.util.List;

public class XmlDefinition {

	public List<Bean> beans = new ArrayList<>();

	public void addBean(Bean bean) {
		beans.add(bean);
	}

	public Bean getBean(String id) {
		for (Bean bean : beans) {
			if (bean.id.equals(id)) {
				return bean;
			}
		}
		return null;
	}

	public String toString() {
		String res = "Xml definition start\n";
		for (Bean bean : beans) {
			res += bean.toString();
		}
		res += "Xml definition end\n";
		return res;
	}

}