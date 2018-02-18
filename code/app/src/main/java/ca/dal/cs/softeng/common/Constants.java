package ca.dal.cs.softeng.common;

public class Constants {

    /* AWS Constants */

    // Keys used to give read-only permission
    public static final String AWS_KEY = "AKIAIDHGFSPGP3ZICHRA";
    public static final String AWS_SECRET = "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";

    // AWS Region we are using. Tables are stored per region.
    public static final String REGION = "us-east-2";

    // Case sensitive table name
    public static final String TABLE_NAME = "course_info";


    /* Database Object Stuff */
    public static final String START_LINE = "Faculty,Course_Id,Course Name,CRN,Lec Lab Tut,Section,Tme_start," +
            "Time_end,MTWTF,Course Description,Seats Available,Enrollment,Waitlist Seats,Waitlist Enrolled,Term," +
            "Cedit Hours,Location,Instructor ,Tuition,Campus";

    public static final String FACULTY         = "faculty";
    public static final String ID              = "id";
    public static final String NAME            = "name";
    public static final String CRN             = "crn";
    public static final String TYPE            = "type";
    public static final String SECTION         = "section";
    public static final String START           = "start";
    public static final String END             = "end";
    public static final String DAYS            = "days";
    public static final String DESCRIPTION     = "description";
    public static final String TOTAL_SEATS     = "seats";
    public static final String SEATS_TAKEN     = "taken";
    public static final String TOTAL_WAITLIST  = "wait_list";
    public static final String WAITLIST_TAKEN  = "w_taken";
    public static final String TERM            = "term";
    public static final String CREDIT_HOURS    = "hours";
    public static final String LOCATION        = "location";
    public static final String INSTRUCTOR      = "instructor";
    public static final String TUITION         = "tuition";
    public static final String CAMPUS          = "campus";

    public static final int ESTIMATED_SIZE     = 8025;
}
