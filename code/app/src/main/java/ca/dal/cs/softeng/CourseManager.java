package ca.dal.cs.softeng;
import java.util.*;
/**
 * Created by jaydentaylor on 2018-02-12.
 */



public class CourseManager {
    //arraylist acts as mock database
    public ArrayList<String> registeredCourses = new ArrayList<String>();
    //these can/will be optimized in the future
    int courseCap = 5;
    int courseCount = 0;

    public boolean addCourse(String crn) {
        if(!validCRN(crn))
            return false;//error message
        if(registeredCourses.contains(crn))
            return false;//error message
        if(courseCount >= courseCap)
            return false;//error message
        registeredCourses.add(crn);
        courseCount++;
        return true;
    }

    public boolean dropCourse(String crn) {
        if(!validCRN(crn))
            return false;//error message
        if(!registeredCourses.contains(crn))
            return false;//error message
        registeredCourses.remove(crn);
        courseCount--;
        return true;
    }

    public static boolean validCRN(String crn) {
        if(crn.length() != 6)
            return false;
        for(char c: crn.toCharArray()) {
            if(!(c >= 48 && c <= 57))//ascii values 0-9
                return false;
        }
        return true;
    }
}
