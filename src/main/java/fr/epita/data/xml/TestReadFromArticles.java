package fr.epita.data.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.stream.Stream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TestReadFromArticles {

	public static final String DELIM = ";";
	public static final String ESCAPE = "\"";

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
		File dir = new File("src/main/resources/ml/ml/metadata");

		String header = "month"+DELIM+ " year"+DELIM+  "title"+DELIM+" topic" + "\n";
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		for (File file : 		dir.listFiles()) {

			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);

			String month = getStringFromXpath(document, "/article/front/article-meta/pub-date/month");
			String year = getStringFromXpath(document, "/article/front/article-meta/pub-date/year");
			String title = getStringFromXpath(document, "/article/front/article-meta/title-group/article-title");
			String topic = "ML";

			Stream.of( month,year,title
			).map( value -> ESCAPE + value + ESCAPE + DELIM)
			.forEach(sb::append);

			sb.append(topic + "\n");
			Files.write(new File("S:\\tmp\\test.xml").toPath(), docToString(document).getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);

		}
		Files.write(new File("S:\\tmp\\testCSV.csv").toPath(), (sb.toString()).getBytes(StandardCharsets.UTF_8), StandardOpenOption.TRUNCATE_EXISTING);



	}

	// from https://stackoverflow.com/questions/5456680/xml-document-to-string
	private static String docToString(Document doc){
		String result = "";
		try {
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			StringWriter writer = new StringWriter();
			transformer.transform(new DOMSource(doc), new StreamResult(writer));
			result = writer.getBuffer().toString().replaceAll("\n|\r", "");
		}catch(Exception e){
			//TODO deal with exception
		}
		return result;

	}

	private static String getStringFromXpath(Document document,String expression) throws XPathExpressionException {
		XPathFactory xpathFactory = XPathFactory.newInstance();
		String stringContent = (String) xpathFactory.newXPath()
				.compile(expression)
				.evaluate(document, XPathConstants.STRING);
		return stringContent.trim();
	}
}
