
package ticketclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ticketclient package. 
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

    private final static QName _BookingResponse_QNAME = new QName("http://TicketServer/", "bookingResponse");
    private final static QName _Details_QNAME = new QName("http://TicketServer/", "details");
    private final static QName _DetailsResponse_QNAME = new QName("http://TicketServer/", "detailsResponse");
    private final static QName _Booking_QNAME = new QName("http://TicketServer/", "booking");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ticketclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DetailsResponse }
     * 
     */
    public DetailsResponse createDetailsResponse() {
        return new DetailsResponse();
    }

    /**
     * Create an instance of {@link Booking }
     * 
     */
    public Booking createBooking() {
        return new Booking();
    }

    /**
     * Create an instance of {@link Details }
     * 
     */
    public Details createDetails() {
        return new Details();
    }

    /**
     * Create an instance of {@link BookingResponse }
     * 
     */
    public BookingResponse createBookingResponse() {
        return new BookingResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BookingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TicketServer/", name = "bookingResponse")
    public JAXBElement<BookingResponse> createBookingResponse(BookingResponse value) {
        return new JAXBElement<BookingResponse>(_BookingResponse_QNAME, BookingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Details }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TicketServer/", name = "details")
    public JAXBElement<Details> createDetails(Details value) {
        return new JAXBElement<Details>(_Details_QNAME, Details.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TicketServer/", name = "detailsResponse")
    public JAXBElement<DetailsResponse> createDetailsResponse(DetailsResponse value) {
        return new JAXBElement<DetailsResponse>(_DetailsResponse_QNAME, DetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Booking }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://TicketServer/", name = "booking")
    public JAXBElement<Booking> createBooking(Booking value) {
        return new JAXBElement<Booking>(_Booking_QNAME, Booking.class, null, value);
    }

}
