package myspringtest.app;

import myspring.app.*;
import myspring.bean.*;
import myspringtest.parser.XmlParserTest;
import myspringtest.pojo.*;

public class FileSystemXmlApplicationContextTest {

	public static void main(String[] args) {
		testSmall();
		testMedium();
	}

	private static void testSmall() {
		Object bean = getBean("small.xml", "greetingService");
		if (bean == null) return;
		GreetingService greetingService = (GreetingService)bean;
		greetingService.greet();
	}

	private static void testMedium() {
		BeanFactory factory = getBeanFactory("medium.xml");
		A b1 = (A)factory.getBean("b1");
		System.out.println(b1);
		A b2 = (A)factory.getBean("b2");
		System.out.println(b2);
		B b3 = (B)factory.getBean("b3");
		System.out.println(b3);
		B b4 = (B)factory.getBean("b4");
		System.out.println(b4);
	}

	private static Object getBean(String fileName, String id) {
		BeanFactory factory = getBeanFactory(fileName);
		Object bean = factory.getBean(id);
		if (bean == null) {
			System.out.println("No such bean");
			return null;
		}
		return bean;
	}

	private static BeanFactory getBeanFactory(String fileName) {
		ConfigurableApplicationContext context =
			new FileSystemXmlApplicationContext(
			XmlParserTest.getFilename(fileName));
		BeanFactory factory = context.getBeanFactory();
		return factory;
	}

}