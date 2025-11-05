package domgjwxeu1105;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;

public class DomModifyGjwxeu {

    public static void main(String argv[]) throws SAXException,
    IOException, ParserConfigurationException
    {
        try {

        File inputFile = new File("hallgatoGJWXEU.xml");

        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docfactory.newDocumentBuilder();

        Document doc = docBuilder.parse(inputFile);

        Node hallgatok = doc.getFirstChild();

        Node hallgat = doc.getElementsByTagName("hallgato").item(0);

        // hallgat attributumának lekérése

        NamedNodeMap attr = hallgat.getAttributes();
        Node nodeAttr = attr.getNamedItem("id");
        nodeAttr.setTextContent("01");

        // loop the hallgat child node

        NodeList list = hallgat.getChildNodes();

        for (int i = 0; i < list.getLength(); i++)
        {
            Node node = list.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                if ("keresztnev".equals(element.getNodeName()))
                {
                    if ("Pál".equals(element.getTextContent()))
                    {
                        element.setTextContent("Olivia");
                    }
                }

                if ("vezeteknev".equals(element.getNodeName()))
                {
                    if ("Kiss".equals(element.getTextContent()))
                    {
                        element.setTextContent("Erős");
                    }
                }
            }
        }
    

        //Tartalom konzolra írása
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transform = transformerFactory.newTransformer();


        //Ez DOMSource tartalmazza a DOM fát. Egy bemeneti forrás lérehozása egy DOM csompóponttal.
        DOMSource source = new DOMSource(doc);
        

        System.out.println("---Módosított fájl---");
        StreamResult consoleResult = new StreamResult(System.out);
        transform.transform(source, consoleResult);
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
