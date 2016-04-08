package run;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Save {

    public Save(Hero hero) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();
            // root element
            String converter;
            Element rootElement = doc.createElement("hero");
            doc.appendChild(rootElement);

            Element name = doc.createElement("Name");
            Element maxLife = doc.createElement("MaxLife");
            Element mana = doc.createElement("Mana");
            Element currentLife = doc.createElement("CurrentLife");
            Element accuracy = doc.createElement("Accuracy");
            Element armor = doc.createElement("Armor");
            Element maxDamage = doc.createElement("MaxDamage");
            Element minDamage = doc.createElement("MinDamage");
            Element evasion = doc.createElement("Evasion");
            name.setTextContent(hero.getName());
            converter = String.valueOf(hero.getMaxHitPoints());
            maxLife.setTextContent(converter);
            converter = String.valueOf(hero.getMana());
            mana.setTextContent(converter);
            converter = String.valueOf(hero.getCurrentHitPoints());
            maxLife.setTextContent(converter);
            converter = String.valueOf(hero.getAccuracy());
            accuracy.setTextContent(converter);
            converter = String.valueOf(hero.getArmor());
            armor.setTextContent(converter);
            converter = String.valueOf(hero.getMaxDamage());
            maxDamage.setTextContent(converter);
            converter = String.valueOf(hero.getMinDamage());
            minDamage.setTextContent(converter);
            converter = String.valueOf(hero.getEvasion());
            evasion.setTextContent(converter);
            rootElement.appendChild(name);
            rootElement.appendChild(maxLife);
            rootElement.appendChild(mana);
            rootElement.appendChild(currentLife);
            rootElement.appendChild(accuracy);
            rootElement.appendChild(armor);
            rootElement.appendChild(maxDamage);
            rootElement.appendChild(minDamage);
            rootElement.appendChild(evasion);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("hero.xml"));
            transformer.transform(source, result);
            // Output to console for testing
            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
