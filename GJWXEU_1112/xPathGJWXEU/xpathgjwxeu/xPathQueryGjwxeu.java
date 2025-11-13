package xPathGJWXEU.xpathgjwxeu;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xPathQueryGjwxeu {
    public static void main(String argv[]) throws SAXException,
    IOException, ParserConfigurationException
    {
        File inputFile = new File("C:\Users\Takács Bálint\Desktop\Egyetem\2025-2026 I.félév\Webes adakezelés\Gyakorlat\GJWXEU_1112\xPathGJWXEU\xpathgjwxeu\\studentGJWXEU.xml");

        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();

        DocumentBuilder docBuilder = docfactory.newDocumentBuilder();

        Document doc = docBuilder.parse(inputFile);

        doc.getDocumentElement().normalize();

        //az XPath készítése
        XPath xPath = XPathFactory.newInstance().newXPath();

        //String gjwxeu = "/class/student";
        //String gjwxeu = "//student[@id='02']";
        //String gjwxeu = "//student";
        //String gjwxeu = "/class/student[2]";
        //String gjwxeu = "/class/student[last()]";
        //String gjwxeu = "/class/student[last()-1]";
        //String gjwxeu = "/root/student[position()<=2]";
        //String gjwxeu = "/class/*";
        //String gjwxeu = "//student[@*]";
        //String gjwxeu = "//*";
        //String gjwxeu = "/class/student[kor>20]";
        //String gjwxeu = "//student/keresztnev | //student/vezeteknev";

        NodeList Gjewxeu = (NodeList) xPath.compile(gjwxeu).evaluate(doc, XPathConstants.NODESET);

        for (int i = 0; i < Gjewxeu.getLength(); i++) {
            Node node = Gjewxeu.item(i);

            System.out.println("\nAktuális elem: " + node.getNodeName());

            //Meg kell vizsgálni a csomópontot, tesztelni kell a subelement
            if (node.getNodeType() == Node.ELEMENT_NODE && node.getNodeName().equals("student")) {
                Element element = (Element) node;

                System.out.println("Halgató ID: " + element.getAttribute("id"));

                System.out.println("Hallgató keresztnév: " + element.getElementsByTagName("keresztnev").item(0).getTextContent());
            
                System.out.println("Hallgató vezetéknév: " + element.getElementsByTagName("vezeteknev").item(0).getTextContent());
            
                System.out.println("Hallgató becenév: " + element.getElementsByTagName("becenev").item(0).getTextContent());

                System.out.println("Hallgató kor: " + element.getElementsByTagName("kor").item(0).getTextContent());
            }
        }
    }
}
