package myspring.parser;

import myspring.bean.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class XmlDefinitionReader {

	private String fileName;

	public XmlDefinitionReader(String fileName) {
		this.fileName = fileName;
	}

	public XmlDefinition parse() {
		XmlDefinition def = new XmlDefinition();
		String xml = readXml();
		XmlTag beansTag = XmlParser.parseTag(xml);
		if (beansTag == null || !beansTag.name.equals("beans")) return null;
		try {
			for (XmlTag beanTag : beansTag.tags) {
				Bean bean = parseBean(beanTag);
				def.addBean(bean);
			}
		} catch (RuntimeException ex) {
			return null;
		}
		return def;
	}

	private String readXml() {
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

	private Bean parseBean(XmlTag beanTag) {
		if (!beanTag.name.equals("bean") || 
			!beanTag.hasAttribute("id") || 
			!beanTag.hasAttribute("class")) {
			throw new RuntimeException();
		}
		String id = beanTag.getAttributeValue("id");
		String cls = beanTag.getAttributeValue("class");
		Bean bean = new Bean(id, cls);
		for (XmlTag tag : beanTag.tags) {
			if (tag.name.equals("constructor-arg")) {
				bean.ctrArg = parseConstructorArgument(tag); 
			} else if (tag.name.equals("property")) {
				Property property = parseProperty(tag);
				bean.addProperty(property);
			}
		}
		return bean;
	}

	private ConstructorArgument parseConstructorArgument(XmlTag ctrArgTag) {
		if (!(ctrArgTag.hasAttribute("value") ^ 
			ctrArgTag.hasAttribute("ref"))) {
			throw new RuntimeException();
		}
		String value;
		boolean isRef;
		if (ctrArgTag.hasAttribute("value")) {
			value = ctrArgTag.getAttributeValue("value");
			isRef = false;
		} else {
			value = ctrArgTag.getAttributeValue("ref");
			isRef = true;
		}
		return new ConstructorArgument(value, isRef);
	}

	private Property parseProperty(XmlTag propertyTag) {
		if (!propertyTag.hasAttribute("name") || 
			!(propertyTag.hasAttribute("value") ^ 
			propertyTag.hasAttribute("ref"))) {
			throw new RuntimeException();
		}
		String name = propertyTag.getAttributeValue("name");
		Property property;
		if (propertyTag.hasAttribute("value")) {
			String value = propertyTag.getAttributeValue("value");
			property = new Property(name, value, false);
		} else {
			String ref = propertyTag.getAttributeValue("ref");
			property = new Property(name, ref, true);
		}
		return property;
	}

}