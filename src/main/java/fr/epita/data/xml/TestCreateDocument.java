package fr.epita.data.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class TestCreateDocument {

	public static void main(String[] args) throws ParserConfigurationException {
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		Element  element = doc.createElement("myRootElement");

		Element myChildElement = doc.createElement("myChildElement");
		element.appendChild(myChildElement);
		myChildElement.setTextContent("this is a text content");
		myChildElement.setAttribute("attr","attrValue");



	}
}
