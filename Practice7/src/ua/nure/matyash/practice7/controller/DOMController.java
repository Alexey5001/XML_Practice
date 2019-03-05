package ua.nure.matyash.practice7.controller;


import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
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
 *
 * 
 */
public class DOMController {

	private String xmlFileName;

	// main container
	private Planes planes;

	public DOMController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public Planes getPlanest() {
		return planes;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate
	 *            If true validate XML document against its XML schema.
	 */
	public void parse(boolean validate) throws ParserConfigurationException {

		// obtain DOM parser 
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory
		
		// XML document contains namespaces

		
		// make parser validating
		if (validate) {
			// turn validation on
			dbf.setFeature(Constants.FEATURE_TURN_VALIDATION_ON, true);

			// turn on xsd validation
			dbf.setFeature(Constants.FEATURE_TURN_SCHEMA_VALIDATION_ON, true);
		}

		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();


		// set error handler
		db.setErrorHandler(new DefaultHandler() {
			@Override
			public void error(SAXParseException e) throws SAXException {
				// throw exception if XML document is NOT valid
				throw e;
			}
		});

		// parse XML document
		Document document = null;
		try {
			document = db.parse(xmlFileName);
		} catch (SAXException|IOException e) {
			e.printStackTrace();
		}
		// get root element
		Element root;
		NodeList questionNodes = null;
		if (document != null) {
			root = document.getDocumentElement();
			questionNodes = root.getElementsByTagName(XML.PLANE.value());
		}

		// create container
		planes = new Planes();

		// obtain questions nodes


		// process questions nodes
		if(questionNodes!=null) {
			for (int j = 0; j < questionNodes.getLength(); j++) {
				Plane question = getQuestion(questionNodes.item(j));
				// add question to container
				planes.getPlane().add(question);
			}
		}
	}

	/**
	 * Extracts question object from the question XML node.
	 * 
	 * @param qNode
	 *            Question node.
	 * @return Question object.
	 */
	private static Plane getQuestion(Node qNode) {
		Plane question = new Plane();
		Element qElement = (Element) qNode;

		// process question text
		Node qtNode = qElement.getElementsByTagName(XML.MODEL.value()).item(0);
		// set question text

		question.setModel(qtNode.getTextContent());
		
		Node qtNode2 = qElement.getElementsByTagName(XML.ORIGINL.value()).item(0);
		// set question text

		question.setOriginl(qtNode2.getTextContent());
		
		
		// set question text
		question.setChars (getChars(qElement.getElementsByTagName(XML.CHARS.value()).item(0)));

		Node qtNode3 =  qElement.getElementsByTagName(XML.PARAMETRS.value()).item(0);
		question.setParametrs(getParametrs(qtNode3));

		Prise prise = new Prise();
		Element kElement = (Element) qElement.getElementsByTagName(XML.PRISE.value()).item(0);
		prise.setConvert((kElement.getAttribute("convert")));
		prise.setValue(Integer.parseInt(kElement.getAttribute("value")));
		question.setPrise(prise);
		// process answers
	
		return question;
	}


	private static Parametrs getParametrs(Node vNode) {
		Parametrs param = new Parametrs();
		Element kElement = (Element) vNode;
		Node wNode3 = kElement.getElementsByTagName(XML.LENGHT.value()).item(0);
		param.setLenght(Integer.parseInt(wNode3.getTextContent()));

		Node wNode2 = kElement.getElementsByTagName(XML.WIDTH.value()).item(0);
		param.setWidth(Integer.parseInt(wNode2.getTextContent()));
		
		
		Node wNode = kElement.getElementsByTagName(XML.HEIGHT.value()).item(0);
		param.setHeight(Integer.parseInt(wNode.getTextContent()));
		
		return param;
	}

	private static Chars getChars(Node vNode) {
			Chars visual = new Chars();
			Element kElement = (Element) vNode;
			
			Node hNode = kElement.getElementsByTagName(XML.TYPE.value()).item(0);
			
			visual.setType((getType(hNode)));
			
			Node mNode = kElement.getElementsByTagName(XML.SITS.value()).item(0);
			visual.setSits(Integer.parseInt(mNode.getTextContent()));

			visual.setAmmunition(getAmmunitionN(kElement.getElementsByTagName(XML.AMMUNITION.value()).item(0)));
			
			Node wNode = kElement.getElementsByTagName(XML.RADAR.value()).item(0);
			visual.setRadar(Boolean.parseBoolean(wNode.getTextContent()));


			return visual;
		    }
	 
	private static Type getType(Node hNode) {
		return Type.fromValue(hNode.getTextContent());
	}

	private static Ammunition getAmmunitionN(Node vNode) {
		Element amElement = (Element) vNode;
		Node mNode = amElement.getElementsByTagName(XML.ROKETS.value()).item(0);
		Ammunition am = new Ammunition();
		am.setRokets(Integer.parseInt(mNode.getTextContent()));
		
		return am;
	}


	// //////////////////////////////////////////////////////
	// Static util methods
	// //////////////////////////////////////////////////////

	/**
	 * Creates and returns DOM of the Test container.
	 * 
	 * @param test
	 *            Test object.
	 * @throws ParserConfigurationException 
	 */
	public static Document getDocument(Planes test) throws ParserConfigurationException {
	
		// obtain DOM parser
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// set properties for Factory

		// XML document contains namespaces
		dbf.setNamespaceAware(true);

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// create root element
		Element pElement = document.createElement("p7:"+XML.PLANES.value());

		pElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
		pElement.setAttribute("xmlns:p7", "http://nure.ua/matyash/practice7");
		pElement.setAttribute("xsi:schemaLocation", "http://nure.ua/matyash/practice7 input.xsd");
		// add root element
		document.appendChild(pElement);
		

		// add questions elements
		for (Plane plane : test.getPlane()) {

			// add question
			Element qElement = document.createElement(XML.PLANE.value());
			pElement.appendChild(qElement);

			// add question text
			Element modelElement = document.createElement(XML.MODEL.value());
			modelElement.setTextContent(plane.getModel());
			qElement.appendChild(modelElement);
			
			Element qtElent2 = document.createElement(XML.ORIGINL.value());
			qtElent2.setTextContent(plane.getOriginl());
			qElement.appendChild(qtElent2);
			
			Element charsElement = document.createElement(XML.CHARS.value());
				Element typeElement = document.createElement(XML.TYPE.value());
				typeElement.setTextContent("" + plane.getChars().getType().value());
				charsElement.appendChild(typeElement);
				
				Element sitsElement = document.createElement(XML.SITS.value());
				sitsElement.setTextContent("" + plane.getChars().getSits());
				charsElement.appendChild(sitsElement);
				
				Element ammElement = document.createElement(XML.AMMUNITION.value());
				Element rElement = document.createElement(XML.ROKETS.value());
				rElement.setTextContent(String.valueOf(plane.getChars().getAmmunition().getRokets()));
				ammElement.appendChild(rElement);
				charsElement.appendChild(ammElement);
				
				Element radElement = document.createElement(XML.RADAR.value());
				radElement.setTextContent("" + plane.getChars().isRadar());
				charsElement.appendChild(radElement);

			qElement.appendChild(charsElement);

			Element paramElement = document.createElement(XML.PARAMETRS.value());
				Element lenghtElement = document.createElement(XML.LENGHT.value());
				lenghtElement.setTextContent("" + plane.getParametrs().getLenght());
				paramElement.appendChild(lenghtElement);

				Element widthElement = document.createElement(XML.WIDTH.value());
				widthElement.setTextContent("" + plane.getParametrs().getWidth());
				paramElement.appendChild(widthElement);

				Element heightElement = document.createElement(XML.HEIGHT.value());
				heightElement.setTextContent("" + plane.getParametrs().getHeight());
				paramElement.appendChild(heightElement);

			qElement.appendChild(paramElement);

			Element priseElement = document.createElement(XML.PRISE.value());
				priseElement.setAttribute("convert",plane.getPrise().getConvert());
				priseElement.setAttribute("value", String.valueOf(plane.getPrise().getValue()));

			qElement.appendChild(priseElement);
		}

		return document;		
	}
	
	/**
	 * Saves Test object to XML file.
	 * 
	 * @param test
	 *            Test object to be saved.
	 * @param xmlFileName
	 *            Output XML file name.
	 */

}
