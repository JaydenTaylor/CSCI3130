package ca.dal.cs.softeng;

import org.junit.*;


import static org.junit.Assert.*;

/**
 * Created by jaydentaylor on 2018-02-12.
 */
public class CourseManagerUnitTest {
    CourseManager cm = new CourseManager();

    @Test
    public void validateCRN() throws Exception {
        assertEquals(true, CourseManager.validCRN("111111"));
    }

    @Test
    public void validateCRN2() throws Exception {
        assertEquals(false, CourseManager.validCRN("1b1111"));
    }

    @Test
    public void validateCRN3() throws Exception {
        assertEquals(false, CourseManager.validCRN("123456789"));
    }

    @Test
    public void validateCRN4() throws Exception {
        assertEquals(false, CourseManager.validCRN("123"));
    }

    @Test
    public void addProper() throws Exception {
        String crn = "100000";
        cm.addCourse(crn);
        assertEquals(crn, cm.registeredCourses.get(cm.registeredCourses.size()-1));
    }

    @Test
    public void addInvalid() throws Exception {
        String crn = "100000000bad";
        assertEquals(false, cm.addCourse(crn));
    }

    @Test
    public void dropInvalid() throws Exception {
        String crn = "999999";
        assertEquals(false, cm.dropCourse(crn));
    }

    @Test
    public void dropValid() throws Exception {
        String crn = "100000";
        cm.addCourse(crn);
        assertEquals(true, cm.dropCourse(crn));
    }

    @Test
    public void addDuplicate() throws Exception {
        cm.addCourse("000000");
        assertEquals(false, cm.addCourse("000000"));
    }

    @Test
    public void tooManyCourses() throws Exception {
        cm.addCourse("000000");
        cm.addCourse("000001");
        cm.addCourse("000002");
        cm.addCourse("000003");
        cm.addCourse("000004");
        assertEquals(false, cm.addCourse("000006"));
    }

}