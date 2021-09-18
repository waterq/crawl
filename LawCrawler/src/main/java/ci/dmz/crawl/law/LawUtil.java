/**
 * 
 */
package ci.dmz.crawl.law;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author 이동훈
 *
 */
public class LawUtil {

	public static Document loadXML(String strURL) throws ParserConfigurationException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document document = null;

		try {
			builder = factory.newDocumentBuilder();
			document = builder.parse(strURL);
			document.getDocumentElement().normalize();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return document;
	}

	public static int getTotalCnt(String url) throws ParserConfigurationException, SAXException {
		Document document = LawUtil.loadXML(url);
		Element root = document.getDocumentElement();
		NodeList nodes = root.getChildNodes();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("totalCnt")) {
				return Integer.parseInt(node.getFirstChild().getNodeValue());
			}
		}

		return 0;
	}

	public static String replaceText(String value) {
		if (value == null) {
			return value;
		}

		if (value.startsWith("\n")) {
			value = value.substring(1, value.length());
			value = replaceText(value);
		}

		if (value.endsWith("\n")) {
			value = value.substring(0, value.length() - 1);
			value = replaceText(value);
		}
		if (value != null && value.trim().equals("null")) {
			value = null;
		}

		return value;
	}

	public static String extractText(Node node) {
		StringBuilder builder = new StringBuilder();

		NodeList childNodes = node.getChildNodes();
		for (int j = 0; j < childNodes.getLength(); j++) {
			Node item = childNodes.item(j);
			if (item.getNodeValue() != null && !item.getNodeValue().trim().equals("")) {
				builder.append(item.getNodeValue().trim()).append("\n");
			}
		}

		return LawUtil.replaceText(builder.toString());
	}

}
