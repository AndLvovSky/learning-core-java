package myspring.parser;

import java.util.ArrayList;
import java.util.List;

public class XmlParser {

	public static XmlTag parseTag(String xml) {
		try {
			xml = removeComments(xml);
			xml = removeVersionTag(xml);
		} catch (RuntimeException ex) {
			return null;
		}
		XmlCut cut = cutFirstTag(xml);
		return cut == null ? null : cut.tag;
	}

	private static XmlCut cutFirstTag(String xml) {
		int l1 = xml.indexOf("<");
		if (l1 == -1) return null;
		boolean onlyAttr;
		int r11 = xml.indexOf("/>"), r12 = xml.indexOf(">"), r1;
		if (r11 == -1 && r12 == -1) return null;
		if (r12 == -1 || r11 < r12) {
			onlyAttr = true;
			r1 = r11 + 1;
		} else {
			onlyAttr = false;
			r1 = r12;
		}
		String attrXml = xml.substring(l1 + 1, r1 - (onlyAttr ? 1 : 0));
		StringCut nameCut = cutName(attrXml);
		if (nameCut == null) return null;
		String name = nameCut.cut;
		XmlTag tag = new XmlTag(name);
		tag.isSingleton = onlyAttr;
		List<XmlAttribute> attrs = parseAttrs(nameCut.last);
		if (attrs == null) return null;
		tag.attrs = attrs;
		xml = xml.replace(xml.substring(l1, r1 + 1), "");
		if (onlyAttr) return new XmlCut(tag, "");
		int l2 = xml.lastIndexOf("</");
		if (l2 == -1) return null;
		int r2 = xml.lastIndexOf(">");
		if (r2 == -1) return null;
		xml = xml.replace(xml.substring(l2, r2 + 1), "");
		List<XmlTag> tags = new ArrayList<>();
		while (true) {
			XmlCut cut = cutFirstTag(xml);
			if (cut == null) break;
			tags.add(cut.tag);
			xml = cut.last;
		}
		tag.tags = tags;
		return new XmlCut(tag, xml);
	}

	private static String removeVersionTag(String xml) {
		int l = xml.indexOf("<?");
		if (l == -1) return xml;
		int r = xml.indexOf("?>", l + 2);
		if (r == -1) throw new RuntimeException();
		return xml.replace(xml.substring(l, r + 2), "");
	}

	private static String removeComments(String xml) {
		while (true) {
			int l = xml.indexOf("<!--");
			if (l == -1) break;
			int r = xml.indexOf("-->", l + 4);
			if (r == -1) break;
			xml = xml.replace(xml.substring(l, r + 3), "");
		}
		return xml;
	}

	private static StringCut cutName(String attrXml) {
		int i = 0;
		while (i < attrXml.length() && !Character.isLetter(attrXml.charAt(i))) {
			i++;
		}
		if (i == attrXml.length()) return null;
		int l = i;
		while (i < attrXml.length() && attrXml.charAt(i) != ' ') {
			i++;
		}
		int r = i - 1;
		String name = attrXml.substring(l, r + 1);
		return new StringCut(name, attrXml.replaceFirst(name, ""));
	}

	private static List<XmlAttribute> parseAttrs(String attrXml) {
		List<XmlAttribute> attrs = new ArrayList<>();
		int i = 0;
		while (true) {
			while (i < attrXml.length() && 
				!Character.isLetter(attrXml.charAt(i))) {
				i++;
			}
			if (i == attrXml.length()) break;
			int l = i;
			while (i < attrXml.length() && 
				attrXml.charAt(i) != ' ' && attrXml.charAt(i) != '=') {
				i++;
			}
			int r = i - 1;
			String name = attrXml.substring(l, r + 1);
			while (i < attrXml.length() && attrXml.charAt(i) != '=') {
				i++;
			}
			if (i == attrXml.length()) return null;
			while (i < attrXml.length() && attrXml.charAt(i) != '"') {
				i++;
			}
			if (i == attrXml.length()) return null;
			l = i + 1;
			i++;
			while (i < attrXml.length() && attrXml.charAt(i) != '"') {
				i++;
			}
			if (i == attrXml.length()) return null;
			r = i - 1;
			i++;
			String value = attrXml.substring(l, r + 1);
			attrs.add(new XmlAttribute(name, value));
		}
		return attrs;
	}

}