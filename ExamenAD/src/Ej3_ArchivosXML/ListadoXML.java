/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej3_ArchivosXML;
import Recursos.Alojamiento;
import java.io.File;
import java.util.ArrayList;
import javax.xml.XMLConstants;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.security.KeyStore;
import java.util.ArrayList;

/**
 *
 * @author Usuario DAM 2
 */
public class ListadoXML {
    private ArrayList<Alojamiento> listaAloj = new ArrayList<>();


    public void addAlojamiento(Alojamiento a) {
        listaAloj.add(a);
    }
       public void importarXML() { //coge UN xml con solo UN objeto y lo traslada a java

        JAXBContext jc;
        try {

            jc = JAXBContext.newInstance(Alojamiento.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File xml = new File("src/Ej3_ArchivosXML/personasId_1.xml");
            Alojamiento test = (Alojamiento) unmarshaller.unmarshal(xml);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            listaAloj.add(test);

        } catch (JAXBException ex) {

        } 
    } 
    public void exportarXML() { //crea un documento xml por cada uno de los elementos de una clase
        try {
            for (int i = 0; i < listaAloj.size(); i++) {
                File fichero = new File("src/Ej3_ArchivosXML/archivo_" + listaAloj.get(i).getNombre() + ".xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(Alojamiento.class);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
                jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "eschema.xsd");
                jaxbMarshaller.marshal(listaAloj.get(i), fichero);
            }
        } catch (JAXBException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void escrbirXML(String ruta, ArrayList<Alojamiento> artista) throws IOException { //guarda en un xml todos lo elementos de una clase pero hay que modificar el metodo

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Alojamiento", null); //crea objeto Document con nodo raiz
            document.setXmlVersion("1.0"); //asignamos la version de nuestro xml

            Element raiz = document.getDocumentElement(); //nodo alojamiento;
            for (int i = 0; i < artista.size(); i++) {
                Element itemAloj = document.createElement("Alojamiento");

                CrearElemento("Nombre", listaAloj.get(i).getNombre(), itemAloj, document);
                CrearElemento("Localidad",listaAloj.get(i).getLocalidad(), itemAloj, document);
                CrearElemento("Tipo Alojamiento", listaAloj.get(i).getNombre(), itemAloj, document);
                CrearElemento("Valoracion", Double.toString(listaAloj.get(i).getValoracion()),itemAloj, document);

                raiz.appendChild(itemAloj);

            }// fin del for que recorre el fichero

            Source source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(ruta));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.transform(source, result);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

    }

    private void CrearElemento(String nombreElemento, String textoString, Element padre, Document document) {
        Element elemento = document.createElement(nombreElemento);
        Text texto = document.createTextNode(textoString);
        elemento.appendChild(texto);
        padre.appendChild(elemento);
    } //submetido para usar en escribirXML

    class GestionContenido extends DefaultHandler {

        public GestionContenido() {
            super();
        }

        @Override
        public void startDocument() {
            System.out.println("Comienzo del Documento XML");
        }

        @Override
        public void endDocument() {
            System.out.println("Final del Documento XML");
        }

        public void startElement(String uri, String nombre, String nombreC, KeyStore.Entry.Attribute atts) {
            System.out.printf("\tPrincipio Elemento: %s %n", nombre);
        }

        @Override
        public void endElement(String uri, String nombre, String nombreC) {
            System.out.printf("\tFin Elemento: %s %n", nombre);
        }

        @Override
        public void characters(char[] ch, int inicio, int longitud) throws SAXException {
            String car = new String(ch, inicio, longitud);
            //quitar saltos de línea
            car = car.replaceAll("[\t\n]", "");
            System.out.printf("\t%s %n", car);
        }
    }
}
