package myspring.app;

import myspring.parser.XmlDefinitionReader;
import myspring.bean.*;

public class FileSystemXmlApplicationContext 
	implements ConfigurableApplicationContext {

	private XmlDefinition xmld;

	public FileSystemXmlApplicationContext(String fileName) {
		XmlDefinitionReader xmldr = new XmlDefinitionReader(fileName);
		xmld = xmldr.parse();
	}

	public BeanFactory getBeanFactory() {
		return new SimpleBeanFactory(xmld);
	}

}