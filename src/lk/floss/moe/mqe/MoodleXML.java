package lk.floss.moe.mqe;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import lk.floss.moe.mqe.quiz.Question;
import lk.floss.moe.mqe.quiz.Question.QuestionType;
import lk.floss.moe.mqe.quiz.Quiz;
import lk.floss.moe.mqe.quiz.ShortAnswerQuestion;
import lk.floss.moe.mqe.quiz.TrueFalseQuestion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public abstract class MoodleXML {
	
	/**
	 * Generates the XML document from a quiz.
	 * <p>
	 * 
	 * <quiz>
	 * 	<question type="truefalse">
	 * 		<name>
	 * 			<text>The Name of the Question</text>
	 * 		</name>
	 * 	</question>
	 * </quiz>
	 * 
	 * </p>
	 * @param quiz Quiz object to generate the XML
	 * @return Generated XML document
	 * @throws ParserConfigurationException 
	 */
	public static Document generateXML(Quiz quiz) throws ParserConfigurationException {
		
		//Document Builder Factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		//Document Builder
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//XML Document
		Document document = builder.newDocument();
		
		//Quiz element the root of the DOM
		Element root = document.createElement("quiz");
		
		//For each question handle the question depending on it's type
		for (Question question : quiz.getQuestions()) {
			Element q = document.createElement("NoElement");
			if(question.getType()==QuestionType.TrueFalse) {
				q = trueFalse((TrueFalseQuestion)question, document);
			} else if(question.getType()==QuestionType.ShortAnswer) {
                            q = shortAnswer((ShortAnswerQuestion)question, document);
                        }
                        else {
				continue;
			}
			
			//Append question to the root node which is <quiz>
			root.appendChild(q);
		}
		
		//Construct the document
		document.appendChild(root);
		return document;
	}
	
	
	private static Element shortAnswer(ShortAnswerQuestion question, Document document) {
		//Common elements to all question types
		Element q = document.createElement("question");
		q.setAttribute("type", "shortanswer");
		Element name = document.createElement("name");
		Element name_text = document.createElement("text");
		Text name_text_text = document.createTextNode(question.getName());
		
		name_text.appendChild(name_text_text);
		name.appendChild(name_text);
		q.appendChild(name);
		
		Element qtext = document.createElement("questiontext");
		qtext.setAttribute("format", "html");
		Element qtext_text = document.createElement("text");
		Text qtext_text_text = document.createTextNode(question.getQuestionText());
		qtext_text.appendChild(qtext_text_text);
		qtext.appendChild(qtext_text);
		q.appendChild(qtext);
		
		for (ShortAnswerQuestion.ShortAnswer answer : question.getAnswers()) {
			Element res = document.createElement("answer");
			res.setAttribute("fraction", String.valueOf(answer.getAmount()));
			Element text = document.createElement("text");
			Text text_text = document.createTextNode(answer.getAnswer());
			Element fb = document.createElement("feedback");
			Element fb_text = document.createElement("text");
			Text fb_text_text = document.createTextNode(answer.getFeedback());
			fb_text.appendChild(fb_text_text);
			fb.appendChild(fb_text);
			text.appendChild(text_text);
			res.appendChild(text);
			res.appendChild(fb);
			q.appendChild(res);
		}
		return q;
	}
	
	
	/**
	 * Handle TrueFalse Question
	 * @param question Question to parse to XML
	 * @param document XML Document Object to use as the base
	 * @return Question as an XML element
	 */
	private static Element trueFalse(TrueFalseQuestion question, Document document) {
		//Common elements to all question types
		Element q = document.createElement("question");
		q.setAttribute("type", "truefalse");
		Element name = document.createElement("name");
		Element name_text = document.createElement("text");
		Text name_text_text = document.createTextNode(question.getName());
		
		name_text.appendChild(name_text_text);
		name.appendChild(name_text);
		q.appendChild(name);
		
		Element qtext = document.createElement("questiontext");
		qtext.setAttribute("format", "html");
		Element qtext_text = document.createElement("text");
		Text qtext_text_text = document.createTextNode(question.getQuestionText());
		qtext_text.appendChild(qtext_text_text);
		qtext.appendChild(qtext_text);
		q.appendChild(qtext);
		
		Element restrue = document.createElement("answer");
		restrue.setAttribute("fraction", ((TrueFalseQuestion)question).isCorrect()?"100":"0");
		Element truetext = document.createElement("text");
		Text truetext_text = document.createTextNode("true");
		Element truefb = document.createElement("feedback");
		Element truefb_text = document.createElement("text");
		Text truefb_text_text = document.createTextNode(question.getFbTrue());
		truefb_text.appendChild(truefb_text_text);
		truefb.appendChild(truefb_text);
		truetext.appendChild(truetext_text);
		restrue.appendChild(truetext);
		restrue.appendChild(truefb);
		q.appendChild(restrue);
		Element resfalse = document.createElement("answer");
		resfalse.setAttribute("fraction", ((TrueFalseQuestion)question).isCorrect()?"0":"100");
		Element falsetext = document.createElement("text");
		Text falsetext_text = document.createTextNode("false");
		Element falsefb = document.createElement("feedback");
		Element falsefb_text = document.createElement("text");
		Text falsefb_text_text = document.createTextNode(question.getFbTrue());
		falsefb_text.appendChild(falsefb_text_text);
		falsefb.appendChild(falsefb_text);
		falsetext.appendChild(falsetext_text);
		resfalse.appendChild(falsetext);
		resfalse.appendChild(falsefb);
		q.appendChild(resfalse);
		return q;
		
	}
	
	
}
