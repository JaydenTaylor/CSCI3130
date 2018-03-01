package ca.dal.cs.softeng;
import java.util.*;

import ca.dal.cs.softeng.common.Constants;
import ca.dal.cs.softeng.database.Entry;
/**
 * Created by jaydentaylor on 2018-02-12.
 */



public class CourseManager {
    //arraylist acts as mock database
    private ArrayList<Class> fallCourses = new ArrayList<Class>();
    private ArrayList<Class> winterCourses = new ArrayList<Class>();
    private ArrayList<Class> summerCourses = new ArrayList<Class>();
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

    public ArrayList<Class> getFallCourses() {
        return fallCourses;
    }

    public ArrayList<Class> getWinterCourses() {
        return winterCourses;
    }

    public ArrayList<Class> getSummerCourses() {
        return summerCourses;
    }

    public boolean addCourse(Entry entry) {
        Class c = new Class(entry);
        String crn = (String) entry.get(Constants.CRN);
        if(!validCRN(crn))
            return false;//error message
        switch(term) {
            case "fall":
                if(contains(crn, fallCourses) >= 0)
                    return false;//error message
                if(fallCourses.size() == courseCap)
                    return false;//error message
                fallCourses.add(c);
                return true;
            case "winter":
                if(contains(crn, winterCourses) >= 0)
                    return false;//error message
                if(winterCourses.size() == courseCap)
                    return false;//error message
                winterCourses.add(c);
                return true;
            case "summer":
                if(contains(crn, summerCourses) >= 0)
                    return false;//error message
                if(summerCourses.size() == courseCap)
                    return false;//error message
                summerCourses.add(c);
                return true;
        }
        return false;
    }

    public boolean dropCourse(Entry entry) {
        Class c = new Class(entry);
        String crn = (String) entry.get(Constants.CRN);
        if(!validCRN(crn))
            return false;//error message
        switch(term) {
            case "fall":
                if(contains(crn, fallCourses) == -1)
                    return false;//error message
                fallCourses.remove(contains(crn, fallCourses));
                return true;
            case "winter":
                if(contains(crn, winterCourses) == -1)
                    return false;//error message
                winterCourses.remove(contains(crn, winterCourses));
                return true;
            case "summer":
                if(contains(crn, summerCourses) == -1)
                    return false;//error message
                summerCourses.remove(contains(crn, summerCourses));
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

    public int contains(String crn, ArrayList<Class> list) {
        Class c;
        for(int i = 0; i < list.size(); i++) {
            c = list.get(i);
            if(crn.equals(c.getCRN()))
                return i;
        }
        return -1;
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
