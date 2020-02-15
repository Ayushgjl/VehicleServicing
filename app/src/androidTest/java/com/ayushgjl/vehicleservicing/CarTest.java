package com.ayushgjl.vehicleservicing;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import com.ayushgjl.vehicleservicing.Model.CarBooking;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CarTest {

    @Rule
    public ActivityTestRule<BookingActivity> testRule = new ActivityTestRule<> (BookingActivity.class);
    String expected ="true";

    @Test
    public void CarTest() {
        onView(withId(R.id.cfullname))
                .perform(typeText("ayushgjl"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.ccontact))
                .perform(typeText("9844435087"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.clocation))
                .perform(typeText("kathmandu"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.cvehiclenum))
                .perform(typeText("Ba97Pa948"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.cproblem))
                .perform(typeText("anything"))
                .perform(ViewActions.closeSoftKeyboard());

        ViewInteraction spin = onView(withId(R.id.spin));
        spin.check(matches(withSpinnerText("SUVs")));

        ViewInteraction spin1 = onView(withId(R.id.spin1));
        spin1.check(matches(withSpinnerText("Hyundai")));

        ViewInteraction spin2 = onView(withId(R.id.spin2));
        spin2.check(matches(withSpinnerText("Full Servicing")));





        onView(withId(R.id.btncbook)) .perform(click());
    }

}

