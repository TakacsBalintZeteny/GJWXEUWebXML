package gjwxeu.domparse.hu;

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


public class GjwxeuDOMQuery {
	public static void main(String argv[]) throws SAXException,
	IOException, ParserConfigurationException
	{
		//Az alap deklaráció.
		File xmlFile = new File("Gjwxeu_XML.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(xmlFile);
		document.getDocumentElement().normalize();
		
		//Az első lekérdezés: az ügyfelek nevei.
		NodeList ugyfelek = document.getElementsByTagName("ügyfél");
		for (int i = 0; i < ugyfelek.getLength(); i++)
		{
			Node node = ugyfelek.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				
				String keresztnev = element.getElementsByTagName("keresztnév").item(0).getTextContent();
				String vezeteknev = element.getElementsByTagName("vezetéknév").item(0).getTextContent();
				
				System.out.println("A(z) " + (i+1) + ". ügyfél vezetélneve: " + vezeteknev + ", keresztneve: " + keresztnev + ".");
			}
		}
		
		//Második lekérdezés: az ügyfelek aki 45 éves(ek) vagy idősebb(ek).
		System.out.println("\n");
		for (int i = 0; i < ugyfelek.getLength(); i++)
		{
			Node node = ugyfelek.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				
				int kor = Integer.parseInt(element.getElementsByTagName("életkor").item(0).getTextContent());
				
				if (kor >= 45)
				{
					String keresztnev = element.getElementsByTagName("keresztnév").item(0).getTextContent();
					String vezeteknev = element.getElementsByTagName("vezetéknév").item(0).getTextContent();
					
					System.out.println("A(z) " + (i+1) + ". ügyfél vezetélneve: " + vezeteknev + ", keresztneve: " + keresztnev + ", kora: " + kor +".");
				}
			}
		}
		
		//Harmadik lekérdezés: az autókat lekérdezése.
		NodeList autok = document.getElementsByTagName("autó");
		System.out.println("\n");
		for (int i = 0; i < autok.getLength(); i++)
		{
			Node node = autok.item(i);
			
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				
				String marka = element.getElementsByTagName("márka").item(0).getTextContent();
				String tipus = element.getElementsByTagName("tipus").item(0).getTextContent();
				String evjarat = element.getElementsByTagName("évjárat").item(0).getTextContent();
				String motor = element.getElementsByTagName("motor").item(0).getTextContent();
				
				System.out.println("A(z) " + (i+1) + ". autó márkája: " + marka + ", tipusa: " + tipus + ", évjárata: " + evjarat + ", motor: " + motor + ".");
			}
		}
		
		//Negyedik lekérdezés: Fordokhoz tartozó szerelések. (Egy pici hiba van benne, vagyis az XML-ben mert kettő ugyan olyan szereléssel volt szervízbe.)
		NodeList szerelesek = document.getElementsByTagName("javítás");
		System.out.println("\n");
		for (int i = 0; i < szerelesek.getLength(); i++)
		{
			Node node = szerelesek.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				
				String javitasFK = element.getAttribute("au_j");
				
				for (int j = 0; j < autok.getLength(); j++)
				{
					Node node2 = autok.item(j);
					if (node2.getNodeType() == Node.ELEMENT_NODE)
					{
						Element element2 = (Element) node2;
						String autoID = element2.getAttribute("autó_Id");
						String autoMarka = element2.getElementsByTagName("márka").item(0).getTextContent();
						
						if (autoMarka.equals("Ford") && javitasFK.equals(autoID))
						{
							NodeList hibak = element.getElementsByTagName("hiba");
							for (int k = 0; k < hibak.getLength(); k++)
							{
								Node node3 = hibak.item(k);
								if (node3.getNodeType() == Node.ELEMENT_NODE)
								{
									String hiba = node3.getTextContent();
									
									System.out.println("A hiba: " + hiba);
								}
							}
						}
					}
				}
			}
		}
	}
}
