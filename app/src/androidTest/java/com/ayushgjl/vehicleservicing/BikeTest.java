package com.ayushgjl.vehicleservicing;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class BikeTest {

    @Rule
    public ActivityTestRule<BikeActivity> testRule = new ActivityTestRule<> (BikeActivity.class);
    String expected ="true";



    @Test
    public void BikeTest() {

        onView(withId(R.id.bfullname))
                .perform(typeText("ayushgjl"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.bcontact))
                .perform(typeText("9844435087"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.blocation))
                .perform(typeText("kathmandu"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.bvehiclenum))
                .perform(typeText("Ba97Pa948"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.bproblem))
                .perform(typeText("anything"))
                .perform(ViewActions.closeSoftKeyboard());

               ViewInteraction bspin = onView(withId(R.id.bspin));
        bspin.check(matches(withSpinnerText("Sports")));

        ViewInteraction bspin1 = onView(withId(R.id.bspin1));
        bspin1.check(matches(withSpinnerText("Honda")));





        onView(withId(R.id.btnbook)) .perform(click());
    }


}
