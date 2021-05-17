package fr.epita.data.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestReadFromXML {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = documentBuilder.parse(new File("C:/tmp/data-structuration/menu.xml"));
		Element documentElement = document.getDocumentElement();
		NodeList names = documentElement.getElementsByTagName("name");

		for (int i = 0; i < names.getLength(); i++) {
			System.out.println(names.item(i).getTextContent());
		}


	}
}
