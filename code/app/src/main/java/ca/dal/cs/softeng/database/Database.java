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
public class Database implements Iterable<Entry> {

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
     * @return {@link Entry} object at <id>index</id>.
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

    /**
     * Makes this object iterable.
     * @return
     */
    @Override
    public Iterator<Entry> iterator() {
        return content.iterator();
    }
}
