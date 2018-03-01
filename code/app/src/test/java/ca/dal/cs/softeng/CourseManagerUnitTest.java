package ca.dal.cs.softeng;
import ca.dal.cs.softeng.common.Constants;
import ca.dal.cs.softeng.database.Entry;
import org.junit.*;


import static org.junit.Assert.*;

/**
 * Created by jaydentaylor on 2018-02-12.
 */
public class CourseManagerUnitTest {
    CourseManager cm = new CourseManager();
    Entry entry = new Entry("");

    @Test
    public void validateCRN() throws Exception {
        assertEquals(true, CourseManager.validCRN("11111"));
    }

    @Test
    public void validateCRNError() throws Exception {
        assertEquals(false, CourseManager.validCRN("1b111"));
    }

    @Test
    public void validateCRNLong() throws Exception {
        assertEquals(false, CourseManager.validCRN("123456789"));
    }

    @Test
    public void validateCRNShort() throws Exception {
        assertEquals(false, CourseManager.validCRN("123"));
    }

    @Test
    public void addProper() throws Exception {
        String crn = "10000";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        cm.addCourse(entry);
        assertEquals(crn, cm.getFallCourses().get(cm.getFallCourses().size()-1).getCRN());
    }

    @Test
    public void addInvalid() throws Exception {
        String crn = "100000000bad";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        assertEquals(false, cm.addCourse(entry));
    }

    @Test
    public void dropInvalid() throws Exception {
        String crn = "999999";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        assertEquals(false, cm.dropCourse(entry));
    }

    @Test
    public void dropValid() throws Exception {
        String crn = "10000";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        cm.addCourse(entry);
        assertEquals(true, cm.dropCourse(entry));
    }

    @Test
    public void dropValidAssertArraySize() throws Exception {
        String crn = "10000";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        cm.addCourse(entry);
        int size = cm.getFallCourses().size();
        cm.dropCourse(entry);
        assertEquals(size - 1, cm.getFallCourses().size());
    }

    @Test
    public void addDuplicate() throws Exception {
        String crn = "00000";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        cm.addCourse(entry);
        assertEquals(false, cm.addCourse(entry));
    }

    @Test
    public void addToWinter() throws Exception {
        cm.setTerm("Winter");
        String crn = "10000";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        cm.addCourse(entry);
        assertEquals(crn, cm.getWinterCourses().get(cm.getWinterCourses().size()-1).getCRN());
    }

    @Test
    public void addToSummer() throws Exception {
        cm.setTerm("Summer");
        String crn = "10000";
        entry.setCRN(crn);
        entry.setTime("0000", "0000");
        cm.addCourse(entry);
        assertEquals(crn, cm.getSummerCourses().get(cm.getSummerCourses().size()-1).getCRN());
    }

    @Test
    public void tooManyCourses() throws Exception {
        entry.setCRN("00000");
        entry.setTime("0100", "0100");
        cm.addCourse(entry);
        entry.setCRN("00001");
        entry.setTime("0200", "0200");
        cm.addCourse(entry);
        entry.setCRN("00002");
        entry.setTime("0300", "0300");
        cm.addCourse(entry);
        entry.setCRN("00003");
        entry.setTime("0400", "0400");
        cm.addCourse(entry);
        entry.setCRN("00004");
        entry.setTime("0500", "0500");
        cm.addCourse(entry);
        entry.setCRN("00005");
        entry.setTime("0600", "0600");
        assertEquals(false, cm.addCourse(entry));
    }

}