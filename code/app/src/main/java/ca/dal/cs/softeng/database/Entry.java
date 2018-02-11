package ca.dal.cs.softeng.database;

import java.util.HashMap;


/**
 * Single entry in the database
 */
public class Entry {

    private HashMap<String, Object> content = new HashMap<>();

    public boolean valid = false;

    public Entry(String line) {
        String[] columns = line.split(",");
        if (columns.length == 20) {
            valid = true;
            content.put(Constants.FACULTY, columns[0]);
            content.put(Constants.ID, columns[1]);
            content.put(Constants.NAME, columns[2]);
            content.put(Constants.CRN, columns[3]);
            content.put(Constants.TYPE, columns[4]);
            content.put(Constants.SECTION, columns[5]);
            content.put(Constants.START, columns[6]);
            content.put(Constants.END, columns[7]);
            content.put(Constants.DAYS, columns[8]);
            content.put(Constants.DESCRIPTION, columns[9]);
            content.put(Constants.SEATS_LEFT, columns[10]);
            content.put(Constants.SEATS_TAKEN, columns[11]);
            content.put(Constants.WAITLIST_LEFT, columns[12]);
            content.put(Constants.WAITLIST_TAKEN, columns[13]);
            content.put(Constants.TERM, columns[14]);
            content.put(Constants.CREDIT_HOURS, columns[15]);
            content.put(Constants.LOCATION, columns[16]);
            content.put(Constants.INSTRUCTOR, columns[17]);
            content.put(Constants.TUITION, columns[18]);
            content.put(Constants.CAMPUS, columns[19]);
        }
    }

    public Object get(String key) {
        return content.get(key);
    }

    @Override
    public String toString() {
        return content.toString();
    }
}
