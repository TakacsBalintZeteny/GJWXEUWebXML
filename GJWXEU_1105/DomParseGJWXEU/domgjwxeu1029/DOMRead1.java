package domgjwxeu1029;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class DOMRead1 {
    public static void main(String[] args) throws SAXException,
    IOException, ParserConfigurationException
    {
        File xmFile = new File("Gjwxeu_orarend.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder dBuilder = factory.newDocumentBuilder();

        Document gjwxeu = dBuilder.parse(xmFile);

        gjwxeu.getDocumentElement().normalize();

        System.out.println("Gyökér elem: " + gjwxeu.getDocumentElement().getNodeName());
        
        NodeList nList = gjwxeu.getElementsByTagName(("ora"));

        for (int i = 0; i < nList.getLength(); i++)
        {
            Node nNode = nList.item(i);

            System.out.println("\nAktuális elem: " + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE)
            {
                Element elem = (Element) nNode;

                String oId = elem.getAttribute("id");
                String oTipus = elem.getAttribute("tipus");

                Node node1 = elem.getElementsByTagName("targy").item(0);
                String targy = node1.getTextContent();

                

                Node node2 = elem.getElementsByTagName("helyszin").item(0);
                String helyszin = node2.getTextContent();

                Node node3 = elem.getElementsByTagName("oktato").item(0);
                String oktato = node3.getTextContent();

                Node node4 = elem.getElementsByTagName("szak").item(0);
                String szak = node4.getTextContent();
            }
        }

    }
}
