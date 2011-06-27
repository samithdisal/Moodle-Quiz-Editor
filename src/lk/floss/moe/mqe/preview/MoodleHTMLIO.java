/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.floss.moe.mqe.preview;

import java.io.StringWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

/**
 *
 * @author sam
 */
public abstract class MoodleHTMLIO {

    private static TransformerFactory factory;
    private static Transformer transformer;

    private static TransformerFactory getFactory() {
        if(factory==null)
            factory = TransformerFactory.newInstance();
        return factory;
    }

    private static Transformer getTransformer() throws TransformerConfigurationException {
        if(transformer==null)
            transformer = getFactory().newTransformer();
        return transformer;
    }
    
    

    public static String getHtmlPreview(Document document) throws TransformerConfigurationException, TransformerException {

        StringWriter writer = new StringWriter();

        Source source = new DOMSource(document);
        Result result = new StreamResult(writer);
        
        
        getTransformer().transform(source, result);
        
        return writer.toString();
    }
}
