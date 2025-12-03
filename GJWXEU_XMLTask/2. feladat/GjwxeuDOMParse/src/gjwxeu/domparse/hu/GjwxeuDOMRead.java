package gjwxeu.domparse.hu;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;


public class GjwxeuDOMRead {
	public static void main(String argv[]) throws SAXException,
	IOException, ParserConfigurationException
	{
		//Az alap deklaráció.
		PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
		File xmlFile = new File("Gjwxeu_XML.xml");
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		Document GJWXEU_Szerviz = dBuilder.parse(xmlFile);
		GJWXEU_Szerviz.getDocumentElement().normalize();
		System.out.println("Gyökér elem: " + GJWXEU_Szerviz.getDocumentElement().getNodeName());
		NodeList ugyfelList = GJWXEU_Szerviz.getElementsByTagName("ügyfél");
		NodeList autoList = GJWXEU_Szerviz.getElementsByTagName("autó");
		NodeList javitasList = GJWXEU_Szerviz.getElementsByTagName("javítás");
		NodeList szereloList = GJWXEU_Szerviz.getElementsByTagName("szerelő");
		NodeList alkatreszList = GJWXEU_Szerviz.getElementsByTagName("alkatrész");
		NodeList vegziList = GJWXEU_Szerviz.getElementsByTagName("végzi");
		NodeList felhasznalList = GJWXEU_Szerviz.getElementsByTagName("felhasznál");
		
		
		
		//Ügyfél feldolgozása.
		for (int i = 0; i < ugyfelList.getLength(); i++) 
		{
			Node ugyfelNode = ugyfelList.item(i);
			System.out.println("\nAktuális elem: " + ugyfelNode.getNodeName());
			writer.println("Aktuális elem: " + ugyfelNode.getNodeName());
			if (ugyfelNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) ugyfelNode;
				
				String ugyfelid = elem.getAttribute("ügyfél_Id");
				
				//Az első node gyerekeinek a kiírása.
				Node node1 = elem.getElementsByTagName("név").item(0);
				NodeList gyerekek1 = node1.getChildNodes();
					Node node11 = gyerekek1.item(0);
					Node node12 = gyerekek1.item(1);
					if (node11.getNodeType() == Node.ELEMENT_NODE && node12.getNodeType() == Node.ELEMENT_NODE) {
						String keresztnev = node11.getTextContent();
						String vezeteknev = node12.getTextContent();
						System.out.println("Ügyfél keresztnéve: " + keresztnev);
						System.out.println("Ügyfél vezetéknéve: " + vezeteknev);
						writer.println("Ügyfél keresztnéve: " + keresztnev);
						writer.println("Ügyfél vezetéknéve: " + vezeteknev);
					}
				
				//A második node gyerekeinek a kiírása.
				Node node2 = elem.getElementsByTagName("cím").item(0);
				NodeList gyerekek2 = node2.getChildNodes();
					Node node21 = gyerekek2.item(0);
					Node node22 = gyerekek2.item(1);
					Node node23 = gyerekek2.item(2);
					if (node21.getNodeType() == Node.ELEMENT_NODE && node22.getNodeType() == Node.ELEMENT_NODE && node23.getNodeType() == Node.ELEMENT_NODE) {
						String varos = node21.getTextContent();
						String utca = node22.getTextContent();
						String hazszam = node23.getTextContent();
						System.out.println("Ügyfél keresztnéve: " + varos);
						System.out.println("Ügyfél vezetéknéve: " + utca);
						System.out.println("Ügyfél vezetéknéve: " + hazszam);
						writer.println("Ügyfél keresztnéve: " + varos);
						writer.println("Ügyfél vezetéknéve: " + utca);
						writer.println("Ügyfél vezetéknéve: " + hazszam);
					}
				
				//A többértékű telefonszámok kiírása.
				NodeList nodeList3 = elem.getElementsByTagName("telefonszám");
				for (int j = 0; j < nodeList3.getLength(); j++) {
					Node node3 = nodeList3.item(j);
					if (node3.getNodeType() == Node.ELEMENT_NODE) {
						String telefonszam = node3.getTextContent();
						System.out.println("Ügyfél telefonszáma: " + telefonszam);
						writer.println("Ügyfél telefonszáma: " + telefonszam);
					}
				}
				
				//A negyedik node kiírása.
				Node node4 = elem.getElementsByTagName("életkor").item(0);
				String eletkor = node4.getTextContent();
				
				System.out.println("Ügyfél id: " + ugyfelid);
				System.out.println("Ügyfél életkora: " + eletkor);
				writer.println("Ügyfél id: " + ugyfelid);
				writer.println("Ügyfél életkora: " + eletkor);
			}	
		}
		
		
		
		//Az autók feldolgozása.
		for (int i = 0; i < autoList.getLength(); i++) {
			Node autoNode = autoList.item(i);
			System.out.println("\nAktuális elem: " + autoNode.getNodeName());
			writer.println("Aktuális elem: " + autoNode.getNodeName());
			if (autoNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) autoNode;
				
				String autoid = elem.getAttribute("autó_Id");
				String u_au = elem.getAttribute("ü_au");
				
				Node node1 = elem.getElementsByTagName("márka").item(0);
				String marka = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("tipus").item(0);
				String tipus = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("évjárat").item(0);
				String evjarat = node3.getTextContent();
				Node node4 = elem.getElementsByTagName("motor").item(0);
				String motor = node4.getTextContent();
				Node node5 = elem.getElementsByTagName("alvázszám").item(0);
				String alvazszam = node5.getTextContent();
				
				System.out.println("Autó id: " + autoid);
				System.out.println("Autó FK: " + u_au);
				System.out.println("Autó márkája: " + marka);
				System.out.println("Autó tipusa: " + tipus);
				System.out.println("Autó évjárata: " + evjarat);
				System.out.println("Autó motorja: " + motor);
				System.out.println("Autó alvázszáma: " + alvazszam);
				writer.println("Autó id: " + autoid);
				writer.println("Autó FK: " + u_au);
				writer.println("Autó márkája: " + marka);
				writer.println("Autó tipusa: " + tipus);
				writer.println("Autó évjárata: " + evjarat);
				writer.println("Autó motorja: " + motor);
				writer.println("Autó alvázszáma: " + alvazszam);
			}
		}
		
		
		
		//A javítások feldolgozása.
		for (int i = 0; i < javitasList.getLength(); i++) {
			Node javitasNode = javitasList.item(i);
			System.out.println("\nAktuális elem: " + javitasNode.getNodeName());
			writer.println("Aktuális elem: " + javitasNode.getNodeName());
			if (javitasNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) javitasNode;
				
				String javitasid = elem.getAttribute("javita_Id");
				String au_j = elem.getAttribute("au_j");
				
				Node node1 = elem.getElementsByTagName("ára").item(0);
				String ara = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("időhossz").item(0);
				String idohossz = node2.getTextContent();
				NodeList nodeList3 = elem.getElementsByTagName("hiba");
				for (int j = 0; j < nodeList3.getLength(); j++) {
					Node node3 = nodeList3.item(j);
					if (node3.getNodeType() == Node.ELEMENT_NODE) {
						String hiba = node3.getTextContent();
						System.out.println("Javítás hibája: " + hiba);
						writer.println("Javítás hibája: " + hiba);
					}
				}
				
				Node node4 = elem.getElementsByTagName("dátum").item(0);
				String datum = node4.getTextContent();
				
				System.out.println("Javítás id: " + javitasid);
				System.out.println("Javítás FK: " + au_j);
				System.out.println("Javítás ára: " + ara);
				System.out.println("Javítás időhossza: " + idohossz);
				System.out.println("Javítás dátuma: " + datum);
				writer.println("Javítás id: " + javitasid);
				writer.println("Javítás FK: " + au_j);
				writer.println("Javítás ára: " + ara);
				writer.println("Javítás időhossza: " + idohossz);
				writer.println("Javítás dátuma: " + datum);
			}
		}
		
		
		
		//A szerelők feldolgozása.
		for (int i = 0; i < szereloList.getLength(); i++) {
			Node szereloNode = szereloList.item(i);
			System.out.println("\nAktuális elem: " + szereloNode.getNodeName());
			writer.println("Aktuális elem: " + szereloNode.getNodeName());
			if (szereloNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) szereloNode;
				
				String szereloid = elem.getAttribute("szerelő_Id");
				
				Node node1 = elem.getElementsByTagName("név").item(0);
				NodeList gyerekek1 = node1.getChildNodes();
					Node node11 = gyerekek1.item(0);
					Node node12 = gyerekek1.item(1);
					if (node11.getNodeType() == Node.ELEMENT_NODE && node12.getNodeType() == Node.ELEMENT_NODE) {
						String keresztnev = node11.getTextContent();
						String vezeteknev = node12.getTextContent();
						System.out.println("Szerelő keresztnéve: " + keresztnev);
						System.out.println("Szerelő vezetéknéve: " + vezeteknev);
						writer.println("Szerelő keresztnéve: " + keresztnev);
						writer.println("Szerelő vezetéknéve: " + vezeteknev);
					}
					
				Node node2 = elem.getElementsByTagName("életkor").item(0);
				String eletkor = node2.getTextContent();
				NodeList nodeList3 = elem.getElementsByTagName("végzettség");
				for (int j = 0; j < nodeList3.getLength(); j++) {
					Node node3 = nodeList3.item(j);
					if (node3.getNodeType() == Node.ELEMENT_NODE) {
						String vegzettseg = node3.getTextContent();
						System.out.println("Szerelő végzettsége: " + vegzettseg);
						writer.println("Szerelő végzettsége: " + vegzettseg);
					}
				}

				System.out.println("Szerelo id: " + szereloid);
				System.out.println("Szerelő életkora: " + eletkor);
				writer.println("Szerelo id: " + szereloid);
				writer.println("Szerelő életkora: " + eletkor);
			}
		}
		
		
		
		//Az alkatrészek feldolgozása.
		for (int i = 0; i < alkatreszList.getLength(); i++) {
			Node alkatreszNode = alkatreszList.item(i);
			System.out.println("\nAktuális elem: " + alkatreszNode.getNodeName());
			writer.println("Aktuális elem: " + alkatreszNode.getNodeName());
			if (alkatreszNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) alkatreszNode;
				
				String alkatreszid = elem.getAttribute("alkatrész_Id");
				
				Node node1 = elem.getElementsByTagName("név").item(0);
				String nev = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("cikkszám").item(0);
				String cikkszam = node2.getTextContent();
				Node node3 = elem.getElementsByTagName("minőség").item(0);
				String minoseg = node3.getTextContent();
				Node node4 = elem.getElementsByTagName("ár").item(0);
				String ar = node4.getTextContent();
				
				System.out.println("Alkatrész id: " + alkatreszid);
				System.out.println("Alkatrész név: " + nev);
				System.out.println("Alkatrész cikkszám: " + cikkszam);
				System.out.println("Alkatrész minőség: " + minoseg);
				System.out.println("Alaktrész ár: " + ar);
				writer.println("Alkatrész id: " + alkatreszid);
				writer.println("Alkatrész név: " + nev);
				writer.println("Alkatrész cikkszám: " + cikkszam);
				writer.println("Alkatrész minőség: " + minoseg);
				writer.println("Alaktrész ár: " + ar);
			}
		}
		
		
		
		//A végzés feldolgozása.
		for (int i = 0; i < vegziList.getLength(); i++) {
			Node vegziNode = vegziList.item(i);
			System.out.println("\nAktuális elem: " + vegziNode.getNodeName());
			writer.println("Aktuális elem: " + vegziNode.getNodeName());
			if (vegziNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) vegziNode;
				
				String j_v = elem.getAttribute("j_v");
				String sz_v = elem.getAttribute("sz_v");
				
				Node node1 = elem.getElementsByTagName("munkaórák").item(0);
				String munkaorak = node1.getTextContent();
				Node node2 = elem.getElementsByTagName("feladat").item(0);
				String feladat = node2.getTextContent();
				
				System.out.println("Végzés FK j_v: " + j_v);
				System.out.println("Végzés FK sz_v: " + sz_v);
				System.out.println("Végzés munkaórái: " + munkaorak);
				System.out.println("Végzés feladata: " + feladat);
				writer.println("Végzés FK j_v: " + j_v);
				writer.println("Végzés FK sz_v: " + sz_v);
				writer.println("Végzés munkaórái: " + munkaorak);
				writer.println("Végzés feladata: " + feladat);
			}
		}
		
		
		
		//A felhasználás felsolgozása.
		for (int i = 0; i < felhasznalList.getLength(); i++) {
			Node felhasznalNode = felhasznalList.item(i);
			System.out.println("\nAktuális elem: " + felhasznalNode.getNodeName());
			writer.println("Aktuális elem: " + felhasznalNode.getNodeName());
			if (felhasznalNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) felhasznalNode;
				
				String j_f = elem.getAttribute("j_f");
				String al_f = elem.getAttribute("al_f");
				
				Node node1 = elem.getElementsByTagName("mennyiség").item(0);
				String mennyiseg = node1.getTextContent();

				System.out.println("Felhasználás FK j_f: " + j_f);
				System.out.println("Felhasználás FK al_f: " + al_f);
				System.out.println("Felhasznált alkatrészek mennyisége: " + mennyiseg);
				writer.println("Felhasználás FK j_f: " + j_f);
				writer.println("Felhasználás FK al_f: " + al_f);
				writer.println("Felhasznált alkatrészek mennyisége: " + mennyiseg);
			}
		}
		
		writer.close();
	}
}

