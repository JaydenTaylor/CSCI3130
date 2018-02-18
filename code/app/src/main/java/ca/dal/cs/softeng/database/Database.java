package ca.dal.cs.softeng.database;

import java.util.ArrayList;

import ca.dal.cs.softeng.common.Constants;


/**
 * POJ Representing our database. In the future this might be changes to be EntrySet, which will represent
 * the result of our Query on our actual database.
 *
 * This class will expand
 */
public class Database {

    private ArrayList<Entry> content;

    protected Database() {
        content = new ArrayList<>(Constants.ESTIMATED_SIZE);
    }

    protected void addEntry( Entry entry) {
        content.add(entry);
    }

    /**
     * Return the {@link Entry} object at the index provided.
     *
     * @param index index of {@link Entry} object.
     * @return {@link Entry} object at <code>index</code>.
     */
    public Entry getEntry(int index) {
        return content.get(index);
    }

    /**
     *
     * @return returns content of this database.
     */
    public ArrayList<Entry> getContent() {
        return content;
    }

    /**
     * TODO: Change this for our list view.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Entry entry: content) {
            string.append(entry);
            string.append("\n");
        }
        return string.toString();
    }

}
