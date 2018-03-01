package ca.dal.cs.softeng;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

/**
 * Created by Paul & Sam on 21/02/2018.
 * Implemented the start of add, drop, radio button, listview espresso tests
 * To be updated in other iterations
 */
public class AddDropCourseActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> main =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeTermFall() throws Exception {
        main.getActivity();
        onView(withId(R.id.fall)).perform(click());
        onView(withId(R.id.fall)).check(matches(isChecked()));
        onView(withId(R.id.winter)).check(matches(isNotChecked()));
        onView(withId(R.id.summer)).check(matches(isNotChecked()));
    }

    @Test
    public void changeTermWinter() throws Exception {
        main.getActivity();
        onView(withId(R.id.winter)).perform(click());
        onView(withId(R.id.winter)).check(matches(isChecked()));
        onView(withId(R.id.fall)).check(matches(isNotChecked()));
        onView(withId(R.id.summer)).check(matches(isNotChecked()));
    }

    @Test
    public void changeTermSummer() throws Exception {
        main.getActivity();
        onView(withId(R.id.summer)).perform(click());
        onView(withId(R.id.summer)).check(matches(isChecked()));
        onView(withId(R.id.winter)).check(matches(isNotChecked()));
        onView(withId(R.id.fall)).check(matches(isNotChecked()));
    }

    @Test
    public void selectFirstCourse() throws Exception {
        main.getActivity();
        onData(anything()).inAdapterView(withId(R.id.list_view)).atPosition(0).perform(click());
    }

    @Test
    public void addButton() throws Exception {
        main.getActivity();
        onView(withId(R.id.addbutton)).perform(click());
    }

    @Test
    public void dropButton() throws Exception {
        main.getActivity();
        onView(withId(R.id.dropbutton)).perform(click());
    }

// uses custom matcher in Matchers Class
    @Test
    public void TenCoursesDisplayed() throws Exception {
        main.getActivity();
        onView (withId (R.id.list_view)).check (ViewAssertions.matches (Matchers.withListSize (10)));
    }

}