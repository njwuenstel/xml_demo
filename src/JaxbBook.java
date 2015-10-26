import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import xjcproblem.RootElementType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

public class JaxbBook {

    //static Logger log = BookieLogger.xml;

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        BookBean bookOne = new BookBean();
        bookOne.setTitle("Killing Mister Spock");
        bookOne.setAuthor("Bill O'Reilley");
        bookOne.setIsbn(6548);
        bookOne.setGoodReadsId(808);

        BookBean bookTwo = new BookBean();
        bookTwo.setTitle("MST3K Unchained");
        bookTwo.setAuthor("Dr. Thomas Servo");
        bookTwo.setIsbn(3001);
        bookTwo.setGoodReadsId(37);

//        // Marshalling Example
//        try {
//
//            BookshelfBean bookshelf = new BookshelfBean();
//            bookshelf.add(bookOne);
//            bookshelf.add(bookTwo);
//
//            File file = new File("booksout.xml");
//            JAXBContext jaxbContext = JAXBContext.newInstance(BookshelfBean.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            // output pretty printed
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//
//            jaxbMarshaller.marshal(bookshelf, file);
//            jaxbMarshaller.marshal(bookshelf, System.out);
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }

        // Unmarshalling Example
        try {

            File file = new File("booksout.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(BookshelfBean.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            BookshelfBean bookshelf = (BookshelfBean) jaxbUnmarshaller.unmarshal(file);
            System.out.println(bookshelf);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    public RootElementType unmarshalExample(File problemXML) throws JAXBException {

        RootElementType rootElement = new RootElementType();

            /*
             * Create a new instance of a JAXBContext object passing in the class to
             * be bound. Make sure the
             */
        JAXBContext jaxbContext = JAXBContext.newInstance("RootElementType");

            /* Instantiate the unmarshaller */
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            /*
             * 1. Create a variable of the xjc type of the root element in your xml
             * 2. Cast to your root element type
             * 3. Call 'unmarshal' method from the jaxBUnmarshaller passing the problemXML file
             *
             * This will return an object containing all the information in your xml, mapped
             * to the individual xjc objects.
             */
        rootElement = (RootElementType) jaxbUnmarshaller.unmarshal(problemXML);

        return rootElement;
    }


}