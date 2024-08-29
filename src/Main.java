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

            // Access elements by tag name
            NodeList noteList = document.getElementsByTagName("note");
            for (int i = 0; i < noteList.getLength(); i++) {
                Element noteElement = (Element) noteList.item(i);

                // Extract information from the "pitch" child element if it exists
                Element pitchElement = (Element) noteElement.getElementsByTagName("pitch").item(0);
                if (pitchElement != null) {
                    String step = pitchElement.getElementsByTagName("step").item(0).getTextContent();
                    String octave = pitchElement.getElementsByTagName("octave").item(0).getTextContent();
                    System.out.println("Note " + (i+1) + ": " + step + octave);
                } else {
                    System.out.println("Note " + (i+1) + ": No pitch information");
                }
                // Extract and print duration
                String duration = getElementTextContent(noteElement, "duration");
                System.out.println("Note " + (i + 1) + ": Duration - " + duration);

                // Extract and print type
                String type = getElementTextContent(noteElement, "type");
                System.out.println("Note " + (i + 1) + ": Type - " + type);

                // Extract and print voice
                String voice = getElementTextContent(noteElement, "voice");
                System.out.println("Note " + (i + 1) + ": Voice - " + voice);

                // Extract and print staff
                String staff = getElementTextContent(noteElement, "staff");
                System.out.println("Note " + (i + 1) + ": Staff - " + staff);

                // Extract and print stem direction
                String stem = getElementTextContent(noteElement, "stem");
                System.out.println("Note " + (i + 1) + ": Stem - " + stem);

                System.out.println(); // For readability between notes
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