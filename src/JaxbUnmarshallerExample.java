import org.xml.sax.SAXException;
import xjcproblem.RootElementType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JaxbUnmarshallerExample {

       /*
        * *****  JAXB Unmarshal Instructions  *****
        *
        * 0. Install the JAXB 2.0 xjc generator plugin if you have not already.
        *
        * 1. Get an xsd for the xml format you wish to unmarshal. if you cannot
        *    find an xsd then find a sample xml and create an xsd from the xml
        *    file.
        *
        *   - Open and select the xml - Tools -> XML Actions -> Create XSD
        *
        * 2. Use the XSD and use JAXB to generate java code from the XML schema.
        *
        *   - Open and select the xsd - Tools -> JAXB -> Generate Java Code from XML Schema
        *
        * 3. Set the root element for JAXB by adding the @XMLRootElement annotation to the root class
        *
        *   a. Open the java class that corresponds to the root element of your xml.
        *   b. Add the @XmlRootElement(name = "name_of_root_element_from_xml") annotation next to
        *      the existing annotations. For the name property, use the actual element name from
        *      the xml file, not the name of your java class.
        *
        *  4. Setup the main method and the unmarshalExampleMethod for your xml file and root element
        *     java class and run it.
        */

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        /* Instantiate an instance of this class */
        JaxbUnmarshallerExample jaxbDemo = new JaxbUnmarshallerExample();

        try {

            /* Create a file object of your input xml */
            File problemXml = new File("problem.xml");

            /*
             * Call unmarshallExample() passing in the file.
             * Set the return object as the type of your root element class (see step 3 above)
             */
            RootElementType rootElement = jaxbDemo.unmarshalExample(problemXml);

            /* It is a good idea to override the toString of your xjc objects */
            System.out.println(rootElement.toString());

        } catch (JAXBException e) {

            e.printStackTrace();
        }
    }

    /**
     * This method will use jaxb to unmarshal an xml file and map it to
     * the class structure created by xjc.
     *
     * @param inputXML a file object of the xml to be unmapped
     * @return the rootElement mapped with information from the xml
     */
    public RootElementType unmarshalExample(File inputXML) throws JAXBException {

            /*
             * Create a new instance of a JAXBContext object passing in the class to
             * be bound. Make sure the argument in the method ends with '.class'.
             */
            JAXBContext jaxbContext = JAXBContext.newInstance(RootElementType.class);

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
             RootElementType rootElement = (RootElementType) jaxbUnmarshaller.unmarshal(inputXML);

            return rootElement;
    }

}
