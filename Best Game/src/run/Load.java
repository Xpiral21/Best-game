package run;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Load {
	public Load(Hero h) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder buider = factory.newDocumentBuilder();
				
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			}


	}

}
