package ua.nure.matyash.practice7;

import org.w3c.dom.Document;
import ua.nure.matyash.practice7.controller.DOMController;
import ua.nure.matyash.practice7.controller.SAXController;
import ua.nure.matyash.practice7.controller.STAXController;
import ua.nure.matyash.practice7.entity.Planes;
import ua.nure.matyash.practice7.util.Sorter;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import static ua.nure.matyash.practice7.controller.DOMController.getDocument;


public class Main {
	public static void saveToXML(Planes test, String xmlFileName) {
		// Test -> DOM -> XML
		try {
			saveToXML(getDocument(test), xmlFileName);
		} catch (TransformerException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Save DOM to XML.
	 *
	 * @param document
	 *            DOM to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */
	public static void saveToXML(Document document, String xmlFileName)
			throws TransformerException {

		StreamResult result = new StreamResult(new File(xmlFileName));

		// set up transformation
		TransformerFactory tf = TransformerFactory.newInstance();
		javax.xml.transform.Transformer t = tf.newTransformer();
		t.setOutputProperty(OutputKeys.INDENT, "yes");

		// run transformation
		t.transform(new DOMSource(document), result);
	}
	
	public static void main(String[] args) throws Exception {

		final String local = "Output ==> ";
		String xmlFileName = "input.xml";
		System.out.println("Input ==> " + xmlFileName);
		
		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////
		
		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		Planes test = domController.getPlanest();

		// sort (case 1)
		Sorter.sortQuestionsByQuestionText(test);
		
		// save
		String outputXmlFile = "output.dom.xml";
		saveToXML(test, outputXmlFile);
		System.out.println(local + outputXmlFile);

//		////////////////////////////////////////////////////////
//		// SAX
//		////////////////////////////////////////////////////////
//		
//		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		test = saxController.getPlanes();
		
		// sort  (case 2)
		Sorter.sortQuestionsByAnswersNumber(test);
		
		// save
		outputXmlFile = "output.sax.xml";
		
		// other way: 
		saveToXML(test, outputXmlFile);
		System.out.println(local + outputXmlFile);
		
		////////////////////////////////////////////////////////
		// StAX
		////////////////////////////////////////////////////////
		
		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		test = staxController.getTest();
		
		
		outputXmlFile = "output.stax.xml";
		saveToXML(test, outputXmlFile);
		System.out.println(local + outputXmlFile);
		
	}

}