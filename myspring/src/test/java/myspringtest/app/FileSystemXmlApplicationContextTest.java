package myspringtest.app;

import myspring.app.*;
import myspring.bean.*;
import myspringtest.parser.XmlParserTest;
import myspringtest.pojo.*;

public class FileSystemXmlApplicationContextTest {

	public static void main(String[] args) {
		testSmall();
	}

	private static void testSmall() {
		ConfigurableApplicationContext context =
			new FileSystemXmlApplicationContext(
			XmlParserTest.getFilename("small.xml"));
		BeanFactory factory = context.getBeanFactory();
		Object bean = factory.getBean("greetingService");
		if (bean == null) {
			System.out.println("No such bean");
			return;
		}
		GreetingService greetingService = (GreetingService)bean;
		greetingService.greet();
	}

}