package ca.dal.cs.softeng.database;

import java.util.HashMap;

import ca.dal.cs.softeng.common.Constants;


/**
 * POJ representing a single entry (line) in the database (or item set in the future).
 */
public class Entry {

    private HashMap<String, Object> content = new HashMap<>();
    private boolean valid = false;

    /**
     * Create an Entry object using a line from a CSV file.
     *
     * @param line Line of a CSV file with exactly 20 columns.
     */
    public Entry(String line) {
        String[] columns = line.split(",");
        if (columns.length == 20) {
            valid = true;

            // If columns are incorrect length, buffer with 0's on right
            if (columns[1].length() != 4) {
                columns[1] = buffer(columns[1], 4 - columns[1].length());
            }
            if (columns[8].length() != 5) {
                columns[8] = buffer(columns[1], 5 - columns[8].length());
            }

            content.put(Constants.FACULTY, columns[0]);
            content.put(Constants.ID, Integer.parseInt(columns[1]));
            content.put(Constants.NAME, columns[2]);
            content.put(Constants.CRN, columns[3]);
            content.put(Constants.TYPE, columns[4]);
            content.put(Constants.SECTION, columns[5]);
            content.put(Constants.START, columns[6]);
            content.put(Constants.END, columns[7]);
            content.put(Constants.DAYS, columns[8]);
            content.put(Constants.DESCRIPTION, columns[9]);
            content.put(Constants.TOTAL_SEATS, Integer.parseInt(columns[10]));
            content.put(Constants.SEATS_TAKEN, Integer.parseInt(columns[11]));
            content.put(Constants.TOTAL_WAITLIST, Integer.parseInt(columns[12]));
            content.put(Constants.WAITLIST_TAKEN, Integer.parseInt(columns[13]));
            content.put(Constants.TERM, columns[14]);
            content.put(Constants.CREDIT_HOURS, Float.parseFloat(columns[15]));
            content.put(Constants.LOCATION, columns[16]);
            content.put(Constants.INSTRUCTOR, columns[17]);
            content.put(Constants.TUITION, columns[18]);
            content.put(Constants.CAMPUS, columns[19]);
        }
    }

    /**
     *
     * @param columnName Column name
     * @return Return the have in column <i>columnName</i> of this Entry object.
     */
    public Object get(String columnName) {
        return content.get(columnName);
    }

    /**
     * Utility method to append n 0's on the right side of a string. This is needed because Mitch mentioned
     * that some columns may contain values that are not the correct length.
     *
     * @param str String to add buffer append on
     * @param n Length of buffer to append
     * @return str buffered with n 0's on the right side
     */
    private String buffer(String str, int n) {
        StringBuilder add = new StringBuilder(str);
        for (int i = 0; i < n; i++) {
            add.append("0");
        }
        return add.toString();
    }

    /**
     * Get the number of seats that are remaining for this Class.
     *
     * @return Number of seats remaining for this Class
     */
    public int getRemainingSeats() {
        return (int) content.get(Constants.TOTAL_SEATS) - (int) content.get(Constants.SEATS_TAKEN);
    }

    /**
     * Get the number of waitlist seats that are remaining for this Class.
     *
     * @return Number of waitlist seats remaining for this Class
     */
    public int getRemainingWaitlist() {
        return (int) content.get(Constants.TOTAL_WAITLIST) - (int) content.get(Constants.WAITLIST_TAKEN);
    }

    /**
     * Increase the number of people enrolled by 1 and return that number.
     * @return The new number of people enrolled.
     */
    public int incrementEnrollment() {
        int currentEnrolled = (int) content.get(Constants.SEATS_TAKEN);
        if (getRemainingSeats() == 0) {
            return currentEnrolled;
        }
        // Increment enrollment
        currentEnrolled++;
        content.put(Constants.SEATS_TAKEN, currentEnrolled);
        return currentEnrolled;
    }

    /**
     * Decrease the number of people enrolled by 1 and return that number.
     * @return The new number of people enrolled.
     */
    public int decrementEnrollment() {
        int currentEnrolled = (int) content.get(Constants.SEATS_TAKEN);
        if (currentEnrolled == 0) {
            return currentEnrolled;
        }
        // Decrement enrollment
        currentEnrolled--;
        content.put(Constants.SEATS_TAKEN, currentEnrolled);
        return currentEnrolled;
    }

    /**
     * Increase the number of people on the waitlist by 1 and return that number.
     * @return The new number of people on the waitlist.
     */
    public int incrementWaitlist() {
        int currentEnrolled = (int) content.get(Constants.WAITLIST_TAKEN);
        if (getRemainingWaitlist() == 0) {
            return currentEnrolled;
        }
        // Increment enrollment
        currentEnrolled++;
        content.put(Constants.WAITLIST_TAKEN, currentEnrolled);
        return currentEnrolled;
    }

    /**
     * Decrease the number of people on the waitlist by 1 and return that number.
     * @return The new number of people on the waitlist.
     */
    public int decrementWaitlist() {
        int currentEnrolled = (int) content.get(Constants.WAITLIST_TAKEN);
        if (currentEnrolled == 0) {
            return currentEnrolled;
        }

        // Decrement enrollment
        currentEnrolled--;
        content.put(Constants.WAITLIST_TAKEN, currentEnrolled);
        return currentEnrolled;
    }

    /**
     * Designates if this entry is valid. A valid entry has exactly 20 columns.
     * @return If entry is valid, as in has the correct number of columns.
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * TODO: Change this for out list view.
     * @return String representation of this object. Currently just uses {@link HashMap#toString()}.
     */
    @Override
    public String toString() {
        return content.toString();
    }

    //Added for testing
    public void setCRN(String crn) {
        content.put(Constants.CRN, crn);
    }
}
