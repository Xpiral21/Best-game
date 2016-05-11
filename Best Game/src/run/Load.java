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
						String heroName = heroAttributes.item(0).getTextContent();
						int maxLife = Integer.parseInt(heroAttributes.item(2).getTextContent());
						int accuracy = Integer.parseInt(heroAttributes.item(3).getTextContent());
						int armor = Integer.parseInt(heroAttributes.item(5).getTextContent());
						int maxDamage = Integer.parseInt(heroAttributes.item(6).getTextContent());
						int minDamage = Integer.parseInt(heroAttributes.item(7).getTextContent());
						int evasion = Integer.parseInt(heroAttributes.item(8).getTextContent());
						h = new Hero(heroName, maxLife, accuracy, armor, maxDamage, minDamage, evasion);
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
