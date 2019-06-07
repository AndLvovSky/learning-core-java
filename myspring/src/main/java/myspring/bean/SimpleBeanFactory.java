package myspring.bean;

public class SimpleBeanFactory implements BeanFactory {

	private XmlDefinition xmld;

	public SimpleBeanFactory(XmlDefinition xmld) {
		this.xmld = xmld;
	}

	public Object getBean(String id) {
		return null;
	}

	public <T> T getBean(String id, Class<T> type) {
		return null;
	}

}