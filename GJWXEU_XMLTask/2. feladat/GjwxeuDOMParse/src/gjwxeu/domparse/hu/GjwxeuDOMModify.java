package gjwxeu.domparse.hu;

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

public class GjwxeuDOMModify {
	public static void main(String argv[]) throws SAXException,
	IOException, ParserConfigurationException
	{
		try {

			//Az alap deklarációk.
	        File inputFile = new File("Gjwxeu_XML.xml");

	        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();

	        DocumentBuilder docBuilder = docfactory.newDocumentBuilder();

	        Document doc = docBuilder.parse(inputFile);

	        NodeList eletkorList = doc.getElementsByTagName("életkor");
	        NodeList evjaratList = doc.getElementsByTagName("évjárat");

	        //Az ügyfeleket ellenőrizük, az életkorukat és módosítjuk.
	        for (int i = 0; i < eletkorList.getLength(); i++)
	        {
	            Node node = eletkorList.item(i);

	            if (node.getNodeType() == Node.ELEMENT_NODE)
	            {
	                Element element = (Element) node;

	                if ("életkor".equals(element.getNodeName()))
	                {
	                    if ("45".equals(element.getTextContent()))
	                    {
	                        element.setTextContent("40");
	                    }
	                    
	                    if ("30".equals(element.getTextContent()))
	                    {
	                        element.setTextContent("35");
	                    }
	                }
	            }
	        }
	        
	        //Az autókat ellenőrizük, az évjáratot és a tipust és módosítjuk.
	        for (int i = 0; i < evjaratList.getLength(); i++)
	        {
	            Node node = evjaratList.item(i);

	            if (node.getNodeType() == Node.ELEMENT_NODE)
	            {
	                Element element = (Element) node;

	                if ("évjárat".equals(element.getNodeName()))
	                {
	                    if ("2005".equals(element.getTextContent()))
	                    {
	                        element.setTextContent("2010");
	                    }
	                }
	                
	                if ("évjárat".equals(element.getNodeName()))
	                {
	                    if ("2019".equals(element.getTextContent()))
	                    {
	                        element.setTextContent("2020");
	                    }
	                }
	            }
	            
	            
	        }
	    

	        //Tartalom konzolra írása.
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
