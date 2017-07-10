package com.acme.a3csci3130;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class crudTest {


    @Rule
    public ActivityTestRule<MainActivity> mainActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference mContactsRef= mRootRef.child("contacts");

    // Tests creating data in firebase
    @Test
    public void createTest() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText("Fishy McGee"),closeSoftKeyboard());
        onView(withId(R.id.email)).perform(typeText("fishSticks@gmal.com"),closeSoftKeyboard());
        onView(withId(R.id.business_number)).perform(typeText("555989834"),closeSoftKeyboard());
        onView(withId(R.id.primary_business)).perform(typeText("Fisher"),closeSoftKeyboard());
        onView(withId(R.id.address)).perform(typeText("123 Ocean drive"),closeSoftKeyboard());
        onView(withId(R.id.province_territory)).perform(typeText("NS"),closeSoftKeyboard());
        onView(withId(R.id.submitButton)).perform(click());


        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.name)).check(matches(withText("Fishy McGee")));
        onView(withId(R.id.email)).check(matches(withText("Fishy McGee")));
        onView(withId(R.id.business_number)).check(matches(withText("555989834")));
        onView(withId(R.id.primary_business)).check(matches(withText("Fisher")));
        onView(withId(R.id.address)).check(matches(withText("123 Ocean drive")));
        onView(withId(R.id.province_territory)).check(matches(withText("NS")));

            }
    // Tests reading data from firebase
    @Test
    public void readTest() throws Exception {
        onView(withId(R.id.submitButton)).perform(click());
    }
    // Tests updating data in firebase
    @Test
    public void updateTest() throws Exception {

    }
    // Tests the deleting data in firebase
    @Test
    public void deleteTest() throws Exception {

    }
}