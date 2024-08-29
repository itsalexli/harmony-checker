import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException {
        System.out.println("hello");

        File xmlFile = new File("/Users/alexli/Downloads/score1.musicxml");

        // Create a DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        try{
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the XML file
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();


            //Access measures by tag name











            // Access Note by tag name
            NodeList noteList = document.getElementsByTagName("note");
            for (int i = 0; i < noteList.getLength(); i++) {
                Element noteElement = (Element) noteList.item(i);
                int staff = Integer.parseInt(getElementTextContent(noteElement, "staff"));
                String step = getElementTextContent(noteElement, "step");
                int octave = Integer.parseInt(getElementTextContent(noteElement, "octave"));
                int duration = Integer.parseInt(getElementTextContent(noteElement, "duration"));
                String type = getElementTextContent(noteElement, "type");
                String voice = getElementTextContent(noteElement, "voice");
                String stem = getElementTextContent(noteElement, "stem");

                //Store into Note obj
                Note newNote = new Note(staff, step, octave, duration, type, voice, stem);
                System.out.println(newNote);
            }
        }
        catch (ParserConfigurationException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }
    private static String getElementTextContent(Element parentElement, String tagName) {
        NodeList nodeList = parentElement.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "No " + tagName + " information";
    }
}