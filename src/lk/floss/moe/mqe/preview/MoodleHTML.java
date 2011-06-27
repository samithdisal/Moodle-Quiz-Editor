/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.floss.moe.mqe.preview;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lk.floss.moe.mqe.quiz.Question;
import lk.floss.moe.mqe.quiz.Quiz;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author sam
 */
public abstract class MoodleHTML {

    /**
     * Generates the HTML preview of the quiz
     * @param quiz Quiz to generate the HTML preview for
     * @return The generated HTML document
     */
    //Document Builder Factory access only thr getFactory()
    private static DocumentBuilderFactory factory = null;
    //Document Builder access only thr getBuilder()
    private static DocumentBuilder builder = null;

    protected static DocumentBuilderFactory getFactory() {
        if(factory==null)
            factory = DocumentBuilderFactory.newInstance();
        return factory;
    }

    protected static DocumentBuilder getBuilder() throws ParserConfigurationException {
        if(builder==null)
            builder = getFactory().newDocumentBuilder();
        return builder;
    }
    
    
    
    

    public static Document generateHTML(Quiz quiz) throws ParserConfigurationException {

        //XML Document
        Document document = getBuilder().newDocument();

        //Quiz element the root of the DOM
        Element t_html = document.createElement("html");
        Element t_head = document.createElement("head");
        
        //<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/> 
        Element t_meta_utf = document.createElement("meta");
        t_meta_utf.setAttribute("http-equiv", "Content-type");
        t_meta_utf.setAttribute("content", "text/html; charset=UTF-8");
        
        t_head.appendChild(t_meta_utf);
        t_html.appendChild(t_head);
        
        Element t_body = document.createElement("body");
        for (Question question : quiz.getQuestions()) {
            t_body.appendChild(genQuestion(question, document));
        }
        t_html.appendChild(t_body);
        document.appendChild(t_html);
        return document;
    }

    private static Element genQuestion(Question question, Document document) {
        Element q = document.createElement("div");
        q.setAttribute("class", "question_div");
        q.setAttribute("id", String.format("div_%s",question.getName().replace(" ", "_")));
        Element t_header = document.createElement("h3");
        t_header.appendChild(
                document.createTextNode(
                String.format("Question: %1$s of type %2$s",
                question.getName(),
                question.getType().getName())));
        q.appendChild(t_header);
        Element t_q_text = document.createElement("div");
        t_q_text.setAttribute("class", "question_text_div");
        
        Element t_q_text_p = document.createElement("p");
        t_q_text_p.appendChild(document.createTextNode(question.getQuestionText()));
        t_q_text.appendChild(t_q_text_p);
        q.appendChild(t_q_text);
        
        return q;
    }
}
