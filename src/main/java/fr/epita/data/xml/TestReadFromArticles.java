package fr.epita.data.xml;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestReadFromArticles {

	public static final String DELIM = ";";

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
		File dir = new File("src/main/resources/ml/ml/metadata");

		String header = "month"+DELIM+ " year"+DELIM+  "title"+DELIM+" topic";
		String fileContent = header;
		for (File file : 		dir.listFiles()) {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

			String month = getStringFromXpath(document, "/article/front/article-meta/pub-date/month");
			String year = getStringFromXpath(document, "/article/front/article-meta/pub-date/year");
			String title = getStringFromXpath(document, "/article/front/article-meta/title-group/article-title");
			String topic = "ML";

			fileContent +=  month + DELIM + year + DELIM + title + DELIM + topic + "\n";
		}
		Files.write(new File("S:\\tmp\\testCSV.csv").toPath(), (fileContent).getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);


	}

	private static String getStringFromXpath(Document document,String expression) throws XPathExpressionException {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		String stringContent = (String) xpathFactory.newXPath()
				.compile(expression)
				.evaluate(document, XPathConstants.STRING);
		return stringContent.trim();
	}
}
