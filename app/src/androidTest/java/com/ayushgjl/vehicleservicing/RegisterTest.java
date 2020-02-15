package com.ayushgjl.vehicleservicing;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class RegisterTest {
    @Rule
    public ActivityTestRule<RegisterActivity> testRule = new ActivityTestRule<> (RegisterActivity.class);
    String expected ="true";

    @Test
    public void RegisterTest(){
        onView(withId(R.id.etfirstname))
                .perform(typeText("ayush"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etlastname))
                .perform(typeText("gjl"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etPhoneNumber))
                .perform(typeText("9844435087"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etUsername))
                .perform(typeText("ayushgjl011"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etpassword))
                .perform(typeText("ayushgjl011"))
                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.etrepassword))
                .perform(typeText("ayushgjl011"))
                .perform(ViewActions.closeSoftKeyboard());

//        onView(withId(R.id.imgProfile))
//                .perform()
//                .perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnregister)) .perform(click());



    }
}
