package myspringtest.parser;

import myspring.parser.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.net.URL;
import java.net.URLDecoder;

public class XmlParserTest {

	public static void main(String[] args) {
		testXml("small.xml");
		testXml("medium.xml");
	}

	private static void testXml(String fileName) {
		String xml = readXml(fileName);
		System.out.println("before:");
		System.out.println(xml + "\n");
		XmlTag xmlTag = XmlParser.parseTag(xml);
		System.out.println("\nafter:");
		System.out.println(xmlTag + "\n");
	}

	private static String readXml(String fileName) {
		ClassLoader classLoader = 
			Thread.currentThread().getContextClassLoader();
		System.out.println(fileName);
        URL url = classLoader.getResource(fileName);
        try {
        	fileName = URLDecoder.decode(url.getPath(), "UTF-8");
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        System.out.println(fileName);
        String xml = "";
        try(BufferedReader reader = 
			new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				xml += line;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return xml;
	}

}