package ca.dal.cs.softeng;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.intent.Intents;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;

/**
 * Created by agagne on 18/02/18.
 */
@RunWith(AndroidJUnit4.class)
public class LoginAndSignUpActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> login =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void LoginCorrect() {
        Intents.init();
        login.getActivity();

        onView(withId(R.id.email_sign_in))
                .perform(clearText()).perform(typeText("fred123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.password_sign_in))
                .perform(clearText()).perform(typeText("password"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_sign_in)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));

        Intents.release();
    }

    @Test
    public void LoginIncorrect() {
        login.getActivity();

        //wrong password
        onView(withId(R.id.email_sign_in))
                .perform(clearText()).perform(typeText("fred123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.password_sign_in))
                .perform(clearText()).perform(typeText("invalid"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_sign_in)).perform(click());
        onView(withText(" Invalid username or password ")).check(matches(isDisplayed()));

        //user doesn't exist
        onView(withId(R.id.email_sign_in))
                .perform(clearText()).perform(typeText("incognito"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.password_sign_in))
                .perform(clearText()).perform(typeText("invalid"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_sign_in)).perform(click());
        onView(withText(" Invalid username or password ")).check(matches(isDisplayed()));
    }

    @Test
    public void signUpCorrect() {
        Intents.init();
        login.getActivity();

        //on LoginActivity
        onView(withId(R.id.button_sign_up)).perform(click());
        intended(hasComponent(SignUpActivity.class.getName()));

        //on SignUpActivity
        onView(withId(R.id.sign_up_user))
                .perform(clearText()).perform(typeText("newUser1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password))
                .perform(clearText()).perform(typeText("password"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password_confirm))
                .perform(clearText()).perform(typeText("password"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_account)).perform(click());

        //back on LoginActivity
        onView(withId(R.id.email_sign_in))
                .perform(clearText()).perform(typeText("newUser1"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.password_sign_in))
                .perform(clearText()).perform(typeText("password"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.button_sign_in)).perform(click());
        intended(hasComponent(MainActivity.class.getName()));

        Intents.release();
    }

    @Test
    public void signUpIncorrect() {
        Intents.init();
        login.getActivity();

        //on LoginActivity
        onView(withId(R.id.button_sign_up)).perform(click());

        //on SignUpActivity
        intended(hasComponent(SignUpActivity.class.getName()));

        //add existing user
        onView(withId(R.id.sign_up_user))
                .perform(clearText()).perform(typeText("fred123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password))
                .perform(clearText()).perform(typeText("anything"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password_confirm))
                .perform(clearText()).perform(typeText("anything"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_account)).perform(click());
        onView(withText(" Username already exists ")).check(matches(isDisplayed()));

        //password fields do not match
        onView(withId(R.id.sign_up_user))
                .perform(clearText()).perform(typeText("newUser2"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password))
                .perform(clearText()).perform(typeText("anything"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password_confirm))
                .perform(clearText()).perform(typeText("different"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_account)).perform(click());
        onView(withText(" Passwords do not match ")).check(matches(isDisplayed()));

        //both user already exists and password incorrect
        onView(withId(R.id.sign_up_user))
                .perform(clearText()).perform(typeText("fred123"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password))
                .perform(clearText()).perform(typeText("anything"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.sign_up_password_confirm))
                .perform(clearText()).perform(typeText("different"));
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.add_account)).perform(click());
        onView(withText(" Passwords do not match ")).check(matches(isDisplayed()));

        Intents.release();
    }
}