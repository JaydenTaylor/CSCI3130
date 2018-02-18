package ca.dal.cs.softeng.database;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EntryTest {

    private final static int BASE_ENROLLMENT = 50;
    private final static int FULL_ENROLLMENT = 100;
    private final static int EMPTY_ENROLLMENT = 0;
    private final static int WAITLIST_ENROLLMENT = 5;
    private final static int FULL_WAITLIST = 10;
    private final static int EMPTY_WAITLIST = 0;

    private String line;
    private String line2;
    private String line3;

    @Before
    public void setup() {
        line = "ACSC,3720,Life Contingencies I,20033,Lec,N/A,1135,1225,11101,Placeholder,100," +
                BASE_ENROLLMENT +",10," + WAITLIST_ENROLLMENT + ",Winter,3,LSC 230,Dr. Who,T410,Halifax";
        line2 = "ACSC,3720,Life Contingencies I,20033,Lec,N/A,1135,1225,11101,Placeholder,100," +
                FULL_ENROLLMENT +",10," + FULL_WAITLIST + ",Winter,3,LSC 230,Dr. Who,T410,Halifax";
        line3 = "ACSC,3720,Life Contingencies I,20033,Lec,N/A,1135,1225,11101,Placeholder,100," +
                EMPTY_ENROLLMENT +",10," + EMPTY_WAITLIST + ",Winter,3,LSC 230,Dr. Who,T410,Halifax";
    }

    @Test
    public void testGetRemainingSeats() {
        Entry entry = new Entry(line);

        assertEquals(BASE_ENROLLMENT, entry.getRemainingSeats());
    }

    @Test
    public void testIncrementEnrollment() {
        Entry entry = new Entry(line);
        entry.incrementEnrollment();

        assertEquals(BASE_ENROLLMENT - 1, entry.getRemainingSeats());
        assertEquals(BASE_ENROLLMENT + 2, entry.incrementEnrollment());
    }

    @Test
    public void testDecrementEnrollment() {
        Entry entry = new Entry(line);
        entry.decrementEnrollment();

        // Seats remaining.
        assertEquals(BASE_ENROLLMENT + 1, entry.getRemainingSeats());

        // Students enrolled
        assertEquals(BASE_ENROLLMENT - 2, entry.decrementEnrollment());
    }

    @Test
    public void testGetRemainingWaitlist() {
        Entry entry = new Entry(line);

        assertEquals(WAITLIST_ENROLLMENT, entry.getRemainingWaitlist());
    }

    @Test
    public void testIncrementWaitlist() {
        Entry entry = new Entry(line);
        entry.incrementWaitlist();

        assertEquals(WAITLIST_ENROLLMENT - 1, entry.getRemainingWaitlist());
        assertEquals(WAITLIST_ENROLLMENT + 2, entry.incrementWaitlist());
    }

    @Test
    public void testDecrementWaitlist() {
        Entry entry = new Entry(line);
        entry.decrementWaitlist();

        // Seats remaining.
        assertEquals(WAITLIST_ENROLLMENT + 1, entry.getRemainingWaitlist());

        // Students enrolled
        assertEquals(WAITLIST_ENROLLMENT - 2, entry.decrementWaitlist());
    }

    @Test
    public void testFullEnrollment() {
        Entry entry = new Entry(line2);
        entry.incrementEnrollment();

        assertEquals(0, entry.getRemainingSeats());
        assertEquals(FULL_ENROLLMENT, entry.incrementEnrollment());
    }

    @Test
    public void testEmptyEnrollment() {
        Entry entry = new Entry(line3);
        entry.decrementEnrollment();

        assertEquals(FULL_ENROLLMENT, entry.getRemainingSeats());
        assertEquals(0, entry.decrementEnrollment());
    }

    @Test
    public void testFullWaitlist() {
        Entry entry = new Entry(line2);
        entry.incrementWaitlist();

        assertEquals(0, entry.getRemainingWaitlist());
        assertEquals(FULL_WAITLIST, entry.incrementWaitlist());
    }

    @Test
    public void testEmptyWaitlist() {
        Entry entry = new Entry(line3);
        entry.decrementWaitlist();

        assertEquals(FULL_WAITLIST, entry.getRemainingWaitlist());
        assertEquals(0, entry.decrementWaitlist());
    }
}
