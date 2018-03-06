package ca.dal.cs.softeng;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.*;

import ca.dal.cs.softeng.common.Constants;
import ca.dal.cs.softeng.database.Course;
/**
 * Created by jaydentaylor on 2018-02-12.
 */



public class CourseManager {
    private DatabaseReference mDatabase;
    private FirebaseUser user;

    private int fallCourses = 0;
    private int winterCourses = 0;
    private int summerCourses = 0;

    /*
    //arraylist acts as mock database
    private ArrayList<Course> fallCourses = new ArrayList<Course>();
    private ArrayList<Course> winterCourses = new ArrayList<Course>();
    private ArrayList<Course> summerCourses = new ArrayList<Course>();
    */
    //these can/will be optimized in the future
    private int courseCap = 5;
    private String term = "fall";

    public CourseManager () {
        user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("USERDATA").child(uid);
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fallCourses = 0;
                for (DataSnapshot item: dataSnapshot.child("fallCourses").getChildren())
                    fallCourses++;

                winterCourses = 0;
                for (DataSnapshot item: dataSnapshot.child("winterCourses").getChildren())
                    winterCourses++;

                summerCourses = 0;
                for (DataSnapshot item: dataSnapshot.child("summerCourses").getChildren())
                    summerCourses++;

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }


    public void setTerm(String t) {
        if(t.equalsIgnoreCase("fall") || t.equalsIgnoreCase("winter") || t.equalsIgnoreCase("summer"))
            term = t.toLowerCase();
    }

    public String getTerm() {
        return term;
    }

    public int getFallCourses() {
        return fallCourses;
    }

    public int getWinterCourses() {
        return winterCourses;
    }

    public int getSummerCourses() {
        return summerCourses;
    }

    public boolean addCourse(Course c) {
        String crn = (String) c.get(Constants.CRN);
        if(!validCRN(crn))
            return false;//error message
        switch(term) {
            case "fall":
                if(fallCourses == courseCap)
                    return false;//error message
                fallCourses++;
                mDatabase.child("fallCourses").child(crn).setValue(c);
                //mDatabase.child("fallCourses").child("courseCount").setValue(fallCourses);
                return true;
            case "winter":
                if(winterCourses == courseCap)
                    return false;//error message
                winterCourses++;
                mDatabase.child("winterCourses").child(crn).setValue(c);
                //mDatabase.child("winterCourses").child("courseCount").setValue(winterCourses);
                return true;
            case "summer":
                if(summerCourses == courseCap)
                    return false;//error message
                summerCourses++;
                mDatabase.child("summerCourses").child(crn).setValue(c);
                //mDatabase.child("summerCourses").child("courseCount").setValue(summerCourses);
                return true;
        }
        return false;
    }

    public boolean dropCourse(Course c) {
        String crn = (String) c.get(Constants.CRN);
        if(!validCRN(crn))
            return false;//error message
        switch(term) {
            case "fall":
                /*
                if(contains(crn, "fallCourses") == false)
                    return false;//error message
                */
                //fallCourses--;
                mDatabase.child("fallCourses").child(crn).removeValue();
                return true;
            case "winter":
                /*
                if(contains(crn, "winterCourses") == false)
                    return false;//error message
                */
                //winterCourses--;
                mDatabase.child("winterCourses").child(crn).removeValue();
                return true;
            case "summer":
                /*
                if(contains(crn, "summerCourses") == false)
                    return false;//error message
                */
                //summerCourses--;
                mDatabase.child("summerCourses").child(crn).removeValue();
                return true;
        }
        return false;
    }

    public static boolean validCRN(String crn) {
        if (crn.length() != 5)
            return false;
        for (char c : crn.toCharArray()) {
            if (!(c >= 48 && c <= 57))//ascii values 0-9
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


    public boolean contains(String crn, String season) {
        //for(int i = 0; i < courseCap; i++)
            //if(mDatabase.child(season).)
        return false;
    }
}
