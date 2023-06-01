package homework;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
//import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
public class ConferenceTest {

    private Conference conference;

    @Mock
    private Student mockStudent;

    @Before
    public void setUp() {
        conference = new Conference(10);
    }

    @Test
    public void calculateTotalPricePaid_noAttendees_shouldReturnZero() {
        double totalPrice = conference.calculateTotalPricePaid();
        assertEquals(0.0, totalPrice, 0.01);
    }

    @Test
    public void calculateTotalPricePaid_attendeesWithoutDiscount_shouldReturnCorrectTotalPrice() {
        List<Student> attendees = new ArrayList<>();
        attendees.add(new Student("Viktorija", "Serafimovska", Course.OTHER, 20));
        attendees.add(new Student("Mike", "Smith", Course.OS, 22));

        conference.getAttendees().addAll(attendees);

        double expectedPrice = Conference.TICKET_PRICE * attendees.size();
        double totalPrice = conference.calculateTotalPricePaid();
        assertEquals(expectedPrice, totalPrice, 0.01);
    }

    @Test
    public void calculateTotalPricePaid_attendeesWithEMTDiscount_shouldReturnCorrectTotalPrice() {
        List<Student> attendees = new ArrayList<>();
        attendees.add(new Student("Viktorija", "Serafimovska", Course.EMT, 22));
        attendees.add(new Student("Jane", "Smith", Course.EMT, 23));

        conference.getAttendees().addAll(attendees);

        double expectedPrice = (1 - Conference.EMT_DISCOUNT) * Conference.TICKET_PRICE * attendees.size();
        double totalPrice = conference.calculateTotalPricePaid();
        assertEquals(expectedPrice, totalPrice, 0.01);
    }

    @Test
    public void calculateTotalPricePaid_attendeesWithWEBDiscount_shouldReturnCorrectTotalPrice() {
        List<Student> attendees = new ArrayList<>();
        attendees.add(new Student("John", "Doe", Course.WEB, 20));
        attendees.add(new Student("Jane", "Smith", Course.WEB, 22));

        conference.getAttendees().addAll(attendees);

        double expectedPrice = (1 - Conference.WEB_DISCOUNT) * Conference.TICKET_PRICE * attendees.size();
        double totalPrice = conference.calculateTotalPricePaid();
        assertEquals(expectedPrice, totalPrice, 0.01);
    }

    @Test
    public void addAttendeeToConference_capacityNotExceeded_shouldReturnTrue() {
        boolean added = conference.addAttendeeToConference(mockStudent);
        assertTrue(added);
        assertEquals(1, conference.getAttendees().size());
        assertTrue(conference.getAttendees().contains(mockStudent));
    }

//    @Test
//    public void addAttendeeToConference_capacityExceeded_shouldReturnFalse() {
//        for (int i = 0; i < 10; i++) {
//            conference.addAttendeeToConference(mockStudent);
//        }
//
//        boolean added = conference.addAttendeeToConference(mockStudent);
//        assertFalse(added);
//        assertEquals(10, conference.getAttendees().size());
//        assertFalse(conference.getAttendees().contains(mockStudent));
//    }

    @Test
    public void addAttendeeToConference_capacityTripled_shouldReturnTrueAndTripleCapacity() {
        assertTrue(conference.tripleCapacity());
        assertEquals(30, conference.getCapacity());
    }
}
