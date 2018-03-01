package ca.dal.cs.softeng;
import ca.dal.cs.softeng.common.Constants;
import ca.dal.cs.softeng.database.Entry;

/**
 * Created by jaydentaylor on 2018-03-01.
 */

public class Course {
    private String crn;
    private int timeStart;
    private int timeEnd;

    public Course(Entry entry) {
        crn = (String) entry.get(Constants.CRN);
        String timeS = (String) entry.get(Constants.START);
        String timeE = (String) entry.get(Constants.END);
        timeStart = Integer.parseInt(timeS);
        timeEnd = Integer.parseInt(timeE);
    }

    public String getCRN() {
        return crn;
    }

    public int getTimeStart() {
        return timeStart;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public boolean conflicting(Entry entry) {
        Course c = new Course(entry);
        if(c.getTimeStart() >= timeStart && c.getTimeStart() <= timeEnd)
            return false;
        if(c.getTimeEnd() >= timeStart && c.getTimeEnd() <= timeEnd)
            return false;
        return true;
    }

}
