package ca.dal.cs.softeng;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import ca.dal.cs.softeng.CourseManager;
import ca.dal.cs.softeng.common.Constants;
import ca.dal.cs.softeng.database.*;

public class MainActivity extends AppCompatActivity {

    
    private ListView listView;
    private CourseManager courseManager = new CourseManager();

    private Entry entry = null;
    private View prevView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("Creating db");
        final Database database = new Parser().parse("info.csv", this);
        System.out.println("Created db");
        final Context context = this;

        // Create adapter
        EntryAdapter adapter = new EntryAdapter(context, database.getContent());

        // Create list view
        listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        // Set what happens when a list view item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                entry = database.getEntry(position);
                if (prevView != null) {
                    prevView.setBackgroundColor(Color.WHITE);
                }
                //crn = (String) entry.get(Constants.CRN);
                view.setBackgroundColor(getColor(R.color.colorBalanced));
                prevView = view;

            }
        });

        Button addButton = findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entry == null)
                    return;
                if(!courseManager.addCourse(entry)) {
                    System.out.println("Adding failed");
                }
                //debug can be removed
                switch(courseManager.getTerm()) {
                    case "fall":
                        System.out.println(courseManager.getFallCourses().toString());
                        break;
                    case "winter":
                        System.out.println(courseManager.getWinterCourses().toString());
                        break;
                    case "summer":
                        System.out.println(courseManager.getSummerCourses().toString());
                        break;
                }
                //System.out.println(courseManager.registeredCourses.toString());
            }
        });

        Button dropButton = findViewById(R.id.dropbutton);
        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(entry == null)
                    return;
                if(!courseManager.dropCourse(entry)) {
                    System.out.println("Dropping failed");
                }
                //debug can be removed
                switch(courseManager.getTerm()) {
                    case "fall":
                        System.out.println(courseManager.getFallCourses().toString());
                        break;
                    case "winter":
                        System.out.println(courseManager.getWinterCourses().toString());
                        break;
                    case "summer":
                        System.out.println(courseManager.getSummerCourses().toString());
                        break;
                }
                //System.out.println(courseManager.registeredCourses.toString());
            }
        });
    }

    public void changeTermFall(View view) {
        courseManager.setTerm("fall");
    }

    public void changeTermWinter(View view) {
        courseManager.setTerm("winter");
    }

    public void changeTermSummer(View view) {
        courseManager.setTerm("summer");
    }

}
