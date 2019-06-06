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
			if (bean.id == id) {
				return bean;
			}
		}
		return null;
	}

}