package ua.nure.matyash.practice7.controller;


import java.util.Iterator;



import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;


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



public class STAXController extends DefaultHandler {

	private String xmlFileName;

	// main container
	private Planes test;
	public STAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}
	public Planes getTest() {
		return test;
	}



	/**
	 * Parses XML document with StAX (based on event reader). There is no validation during the
	 * parsing.
	 */
	public void parse() throws XMLStreamException {

		Plane plane = new Plane();

		Chars chars = new Chars();

		Ammunition amm = new Ammunition();

		Parametrs param = new Parametrs();

		Prise prise;

		Type t;

		// current element name holder
		String currentElement = null;

		XMLInputFactory factory = XMLInputFactory.newInstance();

		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

		XMLEventReader reader = factory.createXMLEventReader(
				new StreamSource(xmlFileName));

		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();

			// skip any empty content
			if (event.isCharacters() && event.asCharacters().isWhiteSpace()) {
				continue;
			}

			// handler for start tags
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				currentElement = startElement.getName().getLocalPart();

				if (XML.PLANES.equalsTo(currentElement)) {
					test = new Planes();

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
					prise = new Prise();
					Iterator iter = startElement.getAttributes();
					String c = iter.next().toString();
					String subC = c.substring(9,c.length()-1);
					String value = iter.next().toString();
					String type = value.substring(7, value.length()-1);
					prise.setConvert(subC);

					prise.setValue(Integer.parseInt(type));

						plane.setPrise(prise);


				}
			}


			if (event.isCharacters()) {
				Characters characters = event.asCharacters();

				if (XML.MODEL.equalsTo(currentElement)) {

						plane.setModel(characters.getData());



				}

				if (XML.ORIGINL.equalsTo(currentElement)) {
						plane.setOriginl(characters.getData());



				}

				if (XML.TYPE.equalsTo(currentElement)) {
					t =  Type.fromValue(characters.getData());

						chars.setType(t);


				}


				if (XML.SITS.equalsTo(currentElement)) {

						chars.setSits(Integer.parseInt(characters.getData()));

				}

				if (XML.ROKETS.equalsTo(currentElement)) {

						amm.setRokets(Integer.parseInt(characters.getData()));
						chars.setAmmunition(amm);

				}

				if (XML.RADAR.equalsTo(currentElement)) {

						chars.setRadar(Boolean.parseBoolean(characters.getData()));
						plane.setChars(chars);


				}

				if (XML.LENGHT.equalsTo(currentElement)) {

						param.setLenght(Integer.parseInt(characters.getData()));

				}

				if (XML.WIDTH.equalsTo(currentElement)) {

						param.setWidth(Integer.parseInt(characters.getData()));

				}

				if (XML.HEIGHT.equalsTo(currentElement)) {

						param.setHeight(Integer.parseInt(characters.getData()));
						plane.setParametrs(param);
					}


			}

			// handler for end tags
			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String localName = endElement.getName().getLocalPart();

				if (XML.PLANE.equalsTo(localName)) {
					// just add question to container

						test.getPlane().add(plane);

				}
				if (XML.CHARS.equalsTo(localName)) {
						// just add question to container
						plane.setChars(chars);

				}

			}
		}
		reader.close();
	}

	public static void main(String[] args) throws Exception {

		// try to parse (valid) XML file (success)
		STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
		staxContr.parse();

		// obtain container
		Planes test = staxContr.getTest();

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + test);
		System.out.println("====================================");
	}
}