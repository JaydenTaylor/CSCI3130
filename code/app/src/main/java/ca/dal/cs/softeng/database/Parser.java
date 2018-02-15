package ca.dal.cs.softeng.database;

import ca.dal.cs.softeng.common.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * CSV File parser.
 */
public class Parser {

    /**
     * Reads the CSV file at <code>fileLocation</code> and returns a {@link Database} object containing each
     * line of the file represented as {@link Entry} objects.
     *
     * @param fileLocation String pointing to location of a CSV file.
     * @return {@link Database} object containing {@link Entry} objects for each line of the CSV file.
     */
    public Database parse(String fileLocation) {
        String line;
        Database database = new Database();

        try {
            FileReader fileReader = new FileReader(fileLocation);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int count = 0;

            while((line = bufferedReader.readLine()) != null) {
                // Skip lines that are column names
                if (line.equals(Constants.START_LINE)) {
                    continue;
                }
                Entry entry = new Entry(line);

                // Check if entry had the right number of columns, only use math and cs courses for now.
                if (entry.isValid() &&
                        (entry.get(Constants.FACULTY).equals("CSCI") || entry.get(Constants.FACULTY).equals("MATH"))) {
                    database.addEntry(entry);
                    count++;
                }
            }

            System.out.println(String.format("Read %d items from %s", count, fileLocation));

            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to open file \"" + fileLocation + "\"");
        } catch(IOException ex) {
            System.out.println("Error reading file \"" + fileLocation + "\"");
        }
        return database;
    }
}
