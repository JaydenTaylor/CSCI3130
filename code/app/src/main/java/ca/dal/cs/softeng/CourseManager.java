package ca.dal.cs.softeng;
import java.util.*;
/**
 * Created by jaydentaylor on 2018-02-12.
 */



public class CourseManager {
    public ArrayList<String> registeredCourses = new ArrayList<String>();

    public boolean addCourse(String crn) {
        if(!validCRN(crn))
            return false;//error message
        if(registeredCourses.contains(crn))
            return false;//error message
        registeredCourses.add(crn);
        return true;
    }

    public boolean dropCourse(String crn) {
        if(!validCRN(crn))
            return false;//error message
        if(!registeredCourses.contains(crn))
            return false;//error message
        registeredCourses.remove(crn);
        return true;
    }

    public static boolean validCRN(String crn) {
        if(crn.length() != 6)
            return false;
        for(char c: crn.toCharArray()) {
            if(!(c >= 48 && c <= 57))
                return false;
        }
        return true;
    }
}
