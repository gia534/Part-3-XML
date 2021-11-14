import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class PlaylistXmlValidate {
    public static void main(String[] args) {
        try{
            // Schema Validation Testing
//            Source playlistXml = new StreamSource(new File("src/Playlist.xml"));
//            File playlistSchema = new File("src/PlaylistSchema.xsd");
//            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//            Schema schema = factory.newSchema(playlistSchema);
//            Validator validator = schema.newValidator();
//            validator.validate(playlistXml);
//            System.out.println("Playlist Xml is a valid schema file.");
//            System.out.println(" ");
//            System.out.println("-------------------------------------");
//            System.out.println(" ");


            //DTD Validation Testing
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setValidating(true);
            dbf.setNamespaceAware(true);

            DocumentBuilder builder = dbf.newDocumentBuilder();
            builder.setErrorHandler(new ErrorHandler() {
                @Override
                public void warning(SAXParseException exception) throws SAXException {
                    System.out.println("Warning exception message: " + exception.getMessage());
                }

                @Override
                public void error(SAXParseException exception) throws SAXException {
                    System.out.print("Error exception message: " + exception.getMessage());
                }

                @Override
                public void fatalError(SAXParseException exception) throws SAXException {
                    System.out.print("Fatal error exception message: " + exception.getMessage());
                }
            });
//
            System.out.println("Playlist XML is a valid DTD file.");

        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("The Playlist XML File is not a valid schema file");
        }
    }
}
