package lk.floss.moe.mqe;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;


public abstract class MoodleXMLIO {
	public static boolean saveToFile(String filename, Document document) throws IOException, TransformerException{
		
		File file = new File(filename);		
		Source source = new DOMSource(document);
		Result result = new StreamResult(file);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(source, result);
		return true;
	}
}
