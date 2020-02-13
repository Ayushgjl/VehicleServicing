package com.ayushgjl.vehicleservicing;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class LoginTest {

    @Rule
    public ActivityTestRule<LoginActivity> testRule = new ActivityTestRule<> (LoginActivity.class);

    @Test
    public void LoginTest(){
        onView(withId(R.id.etemail)) .perform(typeText("ayushghj011"));

        onView(withId(R.id.etpassword)) .perform(typeText("ayushghj011"));

    }

}
