package run;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Load {

	public static Hero loadHero(String name) {
		Hero h = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("hero.xml");
			NodeList heroList = doc.getElementsByTagName("hero");
			for (int i = 0; i < heroList.getLength(); i++) {
				Node hero = heroList.item(i);
				if (hero.getNodeType() == Node.ELEMENT_NODE) {
					Element eHero = (Element) hero;
					NodeList heroAttributes = eHero.getChildNodes();
					if (heroAttributes.item(1).getTextContent().equals(name)) {
						Element maxLifeNode = (Element) heroAttributes.item(0);
						Element heroNameNode  = (Element) heroAttributes.item(2);
						Element heroAccuracyNode  = (Element) heroAttributes.item(3);
						Element heroArmorNode  = (Element) heroAttributes.item(5);
						Element heroMaxDamageNode  = (Element) heroAttributes.item(6);
						Element heroMinDamageNode  = (Element) heroAttributes.item(7);
						Element heroEvasionNode = (Element)hero.getAttributes().item(8);
						String heroName = heroNameNode.getTextContent();
						String maxLife = maxLifeNode.getTextContent();
						String accuracy =heroAccuracyNode.getTextContent();
						String armor = heroArmorNode.getTextContent();
						String maxDamage = heroMaxDamageNode.getTextContent();
						String minDamage = heroMinDamageNode.getTextContent();
						String evasion = heroEvasionNode.getTextContent();
						//h = new Hero(heroName, maxLife, accuracy, armor, maxDamage, minDamage, evasion);
					}

				}

			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		System.out.println("Load Succesfull!");
		return h;

	}

}
