import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class JaxbBookExample {

    //static Logger log = BookieLogger.xml;

    public static void main(String[] args) throws IOException {

        /* Instantiate an instance of this class */
        JaxbBookExample jaxbBookDemo = new JaxbBookExample();

        /* Some books  */
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


        /* ***** Marshalling Example ***** */

        /* make a bookshelf and put the books in it */
        BookshelfBean bookshelf = new BookshelfBean();
        bookshelf.add(bookOne);
        bookshelf.add(bookTwo);

        /* Create output file */
        File outputFile = new File("bookshelf.xml");

        /* Call marshalBookshelf method passing in the bookshelf and output file  */
        jaxbBookDemo.marshalBookshelf(bookshelf, outputFile);


//        /* ***** Unmarshalling Example ***** */
//
//        /* Create a file object of your input xml */
//        File bookshelfXml = new File("bookshelf.xml");
//
//        /*
//         * Call unmarshallExample() passing in the file.
//         * Set the return object as the type of your root element class (see step 3 above)
//         */
//        BookshelfBean myBookshelf = jaxbBookDemo.unmarshalBookshelf(bookshelfXml);
//
//        /* It is a good idea to override the toString of your xjc objects */
//        System.out.println(myBookshelf.toString());
//
//        System.out.println("Books on shelf: " + myBookshelf.getBookshelf().size());
//        System.out.println("Book 1 Author: " + myBookshelf.getBookshelf().get(1).getAuthor());

    }


    public void marshalBookshelf(BookshelfBean bookshelf, File outputXML) {

        try {

            /*
            * Create a new instance of a JAXBContext object passing in the class to
            * be bound. Make sure the argument in the method ends with '.class'.
            */
            JAXBContext jaxbContext = JAXBContext.newInstance(BookshelfBean.class);

            /* Instantiate the unmarshaller */
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /*  Set formatting property */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(bookshelf, outputXML);
            jaxbMarshaller.marshal(bookshelf, System.out);

        } catch (JAXBException e) {

            e.printStackTrace();
        }
    }


    public BookshelfBean unmarshalBookshelf(File inputXML) {

        BookshelfBean bookshelf = null;

        try {

        /*
         * Create a new instance of a JAXBContext object passing in the class to
         * be bound. Make sure the argument in the method ends with '.class'.
         */
        JAXBContext jaxbContext = JAXBContext.newInstance(BookshelfBean.class);

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
        bookshelf = (BookshelfBean) jaxbUnmarshaller.unmarshal(inputXML);

        } catch (JAXBException e) {

            e.printStackTrace();
        }

        return bookshelf;
    }

}