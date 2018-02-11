package ca.dal.cs.softeng.database;

import java.util.ArrayList;

/**
 * Java object representing the database.
 */
public class Database {

    private static final int ESTIMATED_SIZE = 8025;

    private ArrayList<Entry> content;


    public Database() {
        content = new ArrayList<>(ESTIMATED_SIZE);
    }

    public void addEntry(Entry entry) {
        content.add(entry);
    }

    public Entry getEntry(int index) {
        return content.get(index);
    }

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
