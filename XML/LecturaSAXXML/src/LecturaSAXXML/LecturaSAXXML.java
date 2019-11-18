/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LecturaSAXXML;

/**
 *
 * @author Usuario DAM 2
 */

import java.io.*;
import java.security.KeyStore.Entry.Attribute;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class LecturaSAXXML{
	public static void main(String[] args)throws FileNotFoundException, IOException, SAXException{
		XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
		GestionContenido gestor = new GestionContenido();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource("alumnos.xml");
		procesadorXML.parse(fileXML);
	}
}

class GestionContenido extends DefaultHandler{
	public GestionContenido(){
		super();
	}
	public void startDocument(){
		System.out.println("Comienzo del Documento XML");
	}
	public void endDocument(){
		System.out.println("Final del Documento XML");
	}
	public void startElement (String uri, String nombre, String nombreC, Attribute atts){
		System.out.printf("\tPrincipio Elemento: %s %n", nombre);
	}
	public void endElement(String uri, String nombre, String nombreC){
		System.out.printf("\tFin Elemento: %s %n", nombre);
	}
	public void characters (char[] ch, int inicio, int longitud) throws SAXException{
		String car = new String (ch, inicio, longitud);
		//quitar saltos de línea
		car = car.replaceAll("[\t\n]","");
		System.out.printf("\tCaracteres: %s %n", car);
	}
}
