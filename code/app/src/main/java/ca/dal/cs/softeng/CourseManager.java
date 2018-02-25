package ca.dal.cs.softeng;
import java.util.*;

import ca.dal.cs.softeng.common.Constants;
import ca.dal.cs.softeng.database.Entry;
/**
 * Created by jaydentaylor on 2018-02-12.
 */



public class CourseManager {
    //arraylist acts as mock database
    private ArrayList<String> fallCourses = new ArrayList<String>();
    private ArrayList<String> winterCourses = new ArrayList<String>();
    private ArrayList<String> summerCourses = new ArrayList<String>();
    //these can/will be optimized in the future
    private int courseCap = 5;
    private String term = "fall";

    public void setTerm(String t) {
        if(t.equalsIgnoreCase("fall") || t.equalsIgnoreCase("winter") || t.equalsIgnoreCase("summer"))
            term = t.toLowerCase();
    }

    public String getTerm() {
        return term;
    }

    public ArrayList<String> getFallCourses() {
        return fallCourses;
    }

    public ArrayList<String> getWinterCourses() {
        return winterCourses;
    }

    public ArrayList<String> getSummerCourses() {
        return summerCourses;
    }


    public boolean addCourse(Entry entry) {
        String crn = (String) entry.get(Constants.CRN);
        if(!validCRN(crn))
            return false;//error message
        switch(term) {
            case "fall":
                if(fallCourses.contains(crn))
                    return false;//error message
                if(fallCourses.size() == courseCap)
                    return false;//error message
                fallCourses.add(crn);
                return true;
            case "winter":
                if(winterCourses.contains(crn))
                    return false;//error message
                if(winterCourses.size() == courseCap)
                    return false;//error message
                winterCourses.add(crn);
                return true;
            case "summer":
                if(summerCourses.contains(crn))
                    return false;//error message
                if(summerCourses.size() == courseCap)
                    return false;//error message
                summerCourses.add(crn);
                return true;
        }
        return false;
    }

    public boolean dropCourse(Entry entry) {
        String crn = (String) entry.get(Constants.CRN);
        if(!validCRN(crn))
            return false;//error message
        switch(term) {
            case "fall":
                if(!fallCourses.contains(crn))
                    return false;//error message
                fallCourses.remove(crn);
                return true;
            case "winter":
                if(!winterCourses.contains(crn))
                    return false;//error message
                winterCourses.remove(crn);
                return true;
            case "summer":
                if(!summerCourses.contains(crn))
                    return false;//error message
                summerCourses.remove(crn);
                return true;
        }
        return false;
    }

    public static boolean validCRN(String crn) {
        if(crn.length() != 5)
            return false;
        for(char c: crn.toCharArray()) {
            if(!(c >= 48 && c <= 57))//ascii values 0-9
                return false;
        }
        return true;
    }
    //Unused, helpful for future user story
    public boolean overrideCourseCap(int cap) {
        if(cap == 6 || cap == 5)
            courseCap = cap;
        else
            return false;
        return true;
    }
}
