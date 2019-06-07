package myspringtest.parser;

import myspring.bean.*;
import myspring.parser.XmlDefinitionReader;

public class XmlDefinitionReaderTest {

	public static void main(String[] args) {
		testReader("small.xml");
		testReader("medium.xml");
	}

	private static void testReader(String fileName) {
		fileName = XmlParserTest.getFilename(fileName);
		XmlDefinitionReader xmldr = new XmlDefinitionReader(fileName);
		XmlDefinition xmld = xmldr.parse();
		System.out.println(xmld);
	}

}