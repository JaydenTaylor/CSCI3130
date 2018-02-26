package ca.dal.cs.softeng;

import android.view.View;
import android.widget.ListView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by sam on 2018-02-26.
 * custom matcher class retrieved from
 * source: https://stackoverflow.com/questions/30361068/assert-proper-number-of-items-in-list-with-espresso
 */

public class Matchers {
        public static Matcher<View> withListSize (final int size) {
            return new TypeSafeMatcher<View>() {
                @Override
                public boolean matchesSafely(final View view) {
                    return ((ListView) view).getCount() == size;
                }
                @Override public void describeTo (final Description description) {
                    description.appendText ("ListView should have " + size + " items");
                }
            };
        }
}
