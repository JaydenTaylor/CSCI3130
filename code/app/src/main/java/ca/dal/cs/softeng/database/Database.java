package ca.dal.cs.softeng.database;

import java.util.ArrayList;
import java.util.Iterator;

import ca.dal.cs.softeng.common.Constants;


/**
 * POJ Representing our database. In the future this might be changes to be EntrySet, which will represent
 * the result of our Query on our actual database.
 *
 * This class will expand
 */
public class Database implements Iterable<Course> {

    private ArrayList<Course> content;

    protected Database() {
        content = new ArrayList<>(Constants.ESTIMATED_SIZE);
    }

    protected void addEntry( Course entry) {
        content.add(entry);
    }

    /**
     * Return the {@link Course} object at the index provided.
     *
     * @param index index of {@link Course} object.
     * @return {@link Course} object at <id>index</id>.
     */
    public Course getEntry(int index) {
        return content.get(index);
    }

    /**
     *
     * @return returns content of this database.
     */
    public ArrayList<Course> getContent() {
        return content;
    }

    /**
     * TODO: Change this for our list view.
     * @return String representation of this object.
     */
    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Course entry: content) {
            string.append(entry);
            string.append("\n");
        }
        return string.toString();
    }

    /**
     * Makes this object iterable.
     * @return
     */
    @Override
    public Iterator<Course> iterator() {
        return content.iterator();
    }
}
