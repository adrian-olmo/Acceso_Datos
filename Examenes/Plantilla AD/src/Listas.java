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


public class Listas {
    private ArrayList<Persona> listaPersonas = new ArrayList<>();
    private ArrayList<Oficina> listaOficina = new ArrayList<>();

    public Listas() {
    }

    public void addPersona(Persona p) {
        listaPersonas.add(p);
    }

    public void exportarXML() {
        try {
            for (int i = 0; i < listaPersonas.size(); i++) {
                File fichero = new File("src/Archivos/archivo_" + listaPersonas.get(i).getId() + ".xml");
                JAXBContext jaxbContext = JAXBContext.newInstance(Persona.class);

                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI);
                jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
                jaxbMarshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "eschema.xsd");
                jaxbMarshaller.marshal(listaPersonas.get(i), fichero);
            }
        } catch (JAXBException ex) {
            System.err.println(ex.getMessage());
        }
    }   //crea un documento xml por cada uno de los elementos de una clase (editar la clase primero)

    public void importarXML() {

        JAXBContext jc;
        try {

            jc = JAXBContext.newInstance(Persona.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            File xml = new File("src/Ficheros/personasId_1.xml");
            Persona tests = (Persona) unmarshaller.unmarshal(xml);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            listaPersonas.add(tests);

        } catch (JAXBException ex) {

        }
    }   //coge UN xml con solo UN objeto y lo traslada a java

    public void importarOBJ() {
        ObjectInputStream lecturaObjetos = null;
        try {

            lecturaObjetos = new ObjectInputStream(new FileInputStream("src/Archivos/oficinas.obj"));
            listaOficina = (ArrayList<Oficina>) lecturaObjetos.readObject();
            lecturaObjetos = new ObjectInputStream(new FileInputStream("src/Archivos/personas.obj"));
            listaPersonas = (ArrayList<Persona>) lecturaObjetos.readObject();



        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } finally {
            try {
                lecturaObjetos.close();
            } catch (IOException ex) {
                System.out.println("Te faltan los permisos necesario");
            } catch (NullPointerException n) {
                System.out.println("El fichero no se ha cerrado porque puede estar nulo");
            }
        }
    }   //guarda en un array list los objetos

    public void exportarOBJ(String ruta, Object lista) {    //metes la ruta de guardado y el arraylist de donde sacar los datos y los guarda en objetos
        ObjectOutputStream escrituraObjetos = null;
        try {
            escrituraObjetos = new ObjectOutputStream(new FileOutputStream(ruta));
            escrituraObjetos.writeObject(lista);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        } finally {
            try {
                escrituraObjetos.close();
            } catch (IOException ex) {
                System.out.println("Te faltan los permisos necesario");
            } catch (NullPointerException n) {
                System.out.println("Problemas con la instanciacion del fichero");
            }
        }
    } //guarda en un fichero.obj la lista agregando al metodo la ruta de guardado y la lista que guardar

    public void leerXML(String ruta) {
        XMLReader procesadorXML = null;
        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
            procesadorXML.setContentHandler(new GestionContenido());
            InputSource fileXML = new InputSource(ruta);
            procesadorXML.parse(fileXML);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    } //solo te muestra por sout el xml puesto en la ruta

    public void escrbirXML(String ruta, ArrayList<Persona> artista) throws IOException {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            Document document = implementation.createDocument(null, "Artistas", null); //crea objeto Document con nodo raiz
            document.setXmlVersion("1.0"); //asignamos la version de nuestro xml

            Element raiz = document.getDocumentElement(); //nodo empleado;
            for (int i = 0; i < artista.size(); i++) {
                Element itemPersona = document.createElement("Artista");

                CrearElemento("id", Integer.toString(listaPersonas.get(i).getId()), itemPersona, document);
                CrearElemento("sueldo", Double.toString(listaPersonas.get(i).getSueldo()), itemPersona, document);
                CrearElemento("nombre", listaPersonas.get(i).getNombre(), itemPersona, document);
                CrearElemento("apellido", listaPersonas.get(i).getApellido(), itemPersona, document);

                raiz.appendChild(itemPersona);

            }// fin del for que recorre el fichero

            Source source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(ruta));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();

            transformer.transform(source, result);

        } catch (Exception e) {
            System.err.println("Error: " + e);
        }

    } //guarda en un xml todos lo elementos de una clase pero hay que modificar el metodo

    private void CrearElemento(String nombreElemento, String textoString, Element padre, Document document) {
        Element elemento = document.createElement(nombreElemento);
        Text texto = document.createTextNode(textoString);
        elemento.appendChild(texto);
        padre.appendChild(elemento);
    } //submetido para usar en escribirXML (no modificar)

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
    }   //(no modificar)

    public void exportarTXT(String ruta, String[] lineas) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);

            for (int i = 0; i < lineas.length; i++)
                pw.println(lineas[i]);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    } //metes la ruta del guardado del txt, pasar string[] con las lineas a escribir

    public String[] importarTXT(String ruta) {
        String[] strLineas = null;
        ArrayList<String> lineas = new ArrayList<>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(new File(ruta));
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }

            strLineas = new String[lineas.size()];
            for (int i = 0; i < lineas.size(); i++) {
                strLineas[i] = lineas.get(i);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return strLineas;
    } //saca del txt y lo guarda en un string[] lo que lee de la ruta de un fichero .txt

    public ArrayList<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    public ArrayList<Oficina> getListaOficina() {
        return listaOficina;
    }

    public void setListaOficina(ArrayList<Oficina> listaOficina) {
        this.listaOficina = listaOficina;
    }


}

