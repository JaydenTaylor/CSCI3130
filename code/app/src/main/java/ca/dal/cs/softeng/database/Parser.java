package ca.dal.cs.softeng.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * CSV file parser
 */
public class Parser {

    private static final String START_LINE = "Faculty,Course_Id,Course Name,CRN,Lec Lab Tut,Section,Tme_start," +
            "Time_end,MTWTF,Course Description,Seats Available,Enrollment,Waitlist Seats,Waitlist Enrolled,Term," +
            "Cedit Hours,Location,Instructor ,Tuition,Campus";


    public Database parse(String file) {
        String line;
        Database database = new Database();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int c = 0;

            while((line = bufferedReader.readLine()) != null) {
                if (line.equals(START_LINE)) {
                    continue;
                }
                Entry entry = new Entry(line);
                if (entry.valid) {
                    database.addEntry(entry);
                    c++;
                }
            }

            System.out.println(String.format("Read %d items from %s", c, file));

            bufferedReader.close();
        } catch(FileNotFoundException ex) {
            System.out.println("Unable to open file \"" + file + "\"");
        } catch(IOException ex) {
            System.out.println("Error reading file \"" + file + "\"");
        }
        return database;
    }
}
