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

public class DomModify1Gjwxeu {
	public static void main(String argv[]) throws SAXException,
    IOException, ParserConfigurationException
    {
        try {

        File inputFile = new File("C:\\Users\\Takács Bálint\\eclipse-workspace\\DomParseGJWXEU\\domgjwxeu1105\\Gjwxeu_orerend.xml");

        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docfactory.newDocumentBuilder();

        Document doc = docBuilder.parse(inputFile);
        

        NodeList oraList = doc.getElementsByTagName("ora");
        
        Element elsoOra = (Element) oraList.item(0);

        Element oraado = doc.createElement("oraado");
        oraado.setTextContent("Dr. Kovács Béla");

        elsoOra.appendChild(oraado);

        for (int i = 0; i < oraList.getLength(); i++)
        {
            Node node = oraList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element element = (Element) node;

                if (element.hasAttribute("tipus"))
                {
                	String tipus = element.getAttribute("tipus");
                    if ("gyakorlat".equals(tipus))
                    {
                        element.setAttribute("tipus", "elmelet");
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
