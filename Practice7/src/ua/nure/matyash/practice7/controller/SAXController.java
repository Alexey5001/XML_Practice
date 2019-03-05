package ua.nure.matyash.practice7.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.matyash.practice7.constants.Constants;
import ua.nure.matyash.practice7.constants.XML;
import ua.nure.matyash.practice7.entity.Ammunition;
import ua.nure.matyash.practice7.entity.Chars;
import ua.nure.matyash.practice7.entity.Parametrs;
import ua.nure.matyash.practice7.entity.Plane;
import ua.nure.matyash.practice7.entity.Planes;
import ua.nure.matyash.practice7.entity.Prise;
import ua.nure.matyash.practice7.entity.Type;


/**
 * Controller for SAX parser.
 * 
 * @author D.Kolesnikov
 * 
 */
public class SAXController extends DefaultHandler {
	
	private String xmlFileName;

	// current element name holder
	private String currentElement;

	// main container
	private Planes planes;
	
	private Plane plane;
	
	private Chars chars;
	
	private Ammunition amm;
	
	private Parametrs param;
	

	

	public SAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema. With
	 *            this parameter it is possible make parser validating.
	 */
	public void parse(boolean validate) throws  ParserConfigurationException {
		
		// obtain sax parser factory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// XML document contains namespaces
		factory.setNamespaceAware(true);
		
		// set validation
		if (validate) {
			try {
				factory.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);
				factory.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
			} catch (SAXNotRecognizedException|SAXNotSupportedException  e) {
				e.printStackTrace();
			}

		}

		SAXParser parser;
		try {
			parser = factory.newSAXParser();
			parser.parse(xmlFileName, this);
		} catch (SAXException|IOException e) {
			e.printStackTrace();
		}
	}

	// ///////////////////////////////////////////////////////////
	// ERROR HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	@Override
	public void error(org.xml.sax.SAXParseException e) throws SAXException {
		// if XML document not valid just throw exception
		throw e;
	}

	public Planes getPlanes() {
		return planes;
	}

	// ///////////////////////////////////////////////////////////
	// CONTENT HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////


	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {

		currentElement = localName;

		if (XML.PLANES.equalsTo(currentElement)) {
			planes = new Planes();
		}
		
		if (XML.PLANE.equalsTo(currentElement)) {
			plane = new Plane();
		}


		if (XML.AMMUNITION.equalsTo(currentElement)) {
			amm = new Ammunition();
		}
		
	

		if (XML.CHARS.equalsTo(currentElement)) {
			chars = new Chars();
		}
		
		if (XML.PARAMETRS.equalsTo(currentElement)) {
			param = new Parametrs();
		}
		
		if (XML.PRISE.equalsTo(currentElement)) {
			Prise prise = new Prise();
			String convert =  attributes.getValue("convert");
			String value =  attributes.getValue("value");
			prise.setConvert(convert);
			prise.setValue(Integer.parseInt(value));
			plane.setPrise(prise);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) {

		String elementText = new String(ch, start, length).trim();

		// return if content is empty
		if (elementText.isEmpty()) { 
			return;
		}

		if (XML.MODEL.equalsTo(currentElement)) {
			plane.setModel(elementText);

		}

		if (XML.ORIGINL.equalsTo(currentElement)) {
			plane.setOriginl(elementText);

		}
		
		if (XML.TYPE.equalsTo(currentElement)) {
			Type t =  Type.fromValue(elementText);
			chars.setType(t);

		}
		

		if (XML.SITS.equalsTo(currentElement)) {
			chars.setSits(Integer.parseInt(elementText));

		}
		
		if (XML.ROKETS.equalsTo(currentElement)) {
			amm.setRokets(Integer.parseInt(elementText));
			chars.setAmmunition(amm);

		}
		
		if (XML.RADAR.equalsTo(currentElement)) {
			chars.setRadar(Boolean.parseBoolean(elementText));
			plane.setChars(chars);

		}
		
		if (XML.LENGHT.equalsTo(currentElement)) {
			param.setLenght(Integer.parseInt(elementText));

		}
		
		if (XML.WIDTH.equalsTo(currentElement)) {
			param.setWidth(Integer.parseInt(elementText));

		}
		
		if (XML.HEIGHT.equalsTo(currentElement)) {
			param.setHeight(Integer.parseInt(elementText));
			plane.setParametrs(param);

		}
	
	}

	@Override
	public void endElement(String uri, String localName, String qName) {

		if (XML.PLANE.equalsTo(localName)) {
			// just add question to container
			planes.getPlane().add(plane);
			return;
		}

	}

	public static void main(String[] args) throws Exception {
		final String local = "====================================";
		// try to parse valid XML file (success)
		SAXController saxContr = new SAXController(Constants.VALID_XML_FILE);
		
		// do parse with validation on (success)
		saxContr.parse(true);
		
		// obtain container
		Planes test = saxContr.getPlanes();

		// we have Test object at this point:
		System.out.println(local);
		System.out.print("Here is the test: \n" + test);
		System.out.println(local);

		// now try to parse NOT valid XML (failed)
		saxContr = new SAXController(Constants.VALID_XML_FILE);
			// do parse with validation on (failed)
			saxContr.parse(true);


		// and now try to parse NOT valid XML with validation off (success)


		// we have Test object at this point:
		System.out.println(local);
		System.out.print("Here is the test: \n" + saxContr.getPlanes());
		System.out.println(local);
	}
}