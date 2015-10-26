
package xjcproblem;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xjcproblem package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RootElement_QNAME = new QName("", "root_element");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xjcproblem
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RootElementType }
     * 
     */
    public RootElementType createRootElementType() {
        return new RootElementType();
    }

    /**
     * Create an instance of {@link ChildType }
     * 
     */
    public ChildType createChildType() {
        return new ChildType();
    }

    /**
     * Create an instance of {@link ParentType }
     * 
     */
    public ParentType createParentType() {
        return new ParentType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RootElementType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "root_element")
    public JAXBElement<RootElementType> createRootElement(RootElementType value) {
        return new JAXBElement<RootElementType>(_RootElement_QNAME, RootElementType.class, null, value);
    }

}
